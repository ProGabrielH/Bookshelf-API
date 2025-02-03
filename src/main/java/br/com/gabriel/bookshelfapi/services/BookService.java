package br.com.gabriel.bookshelfapi.services;

import br.com.gabriel.bookshelfapi.data.vo.v1.BookVO;
import br.com.gabriel.bookshelfapi.exceptions.ResourceNotFoundException;
import br.com.gabriel.bookshelfapi.mapper.Mapper;
import br.com.gabriel.bookshelfapi.model.Author;
import br.com.gabriel.bookshelfapi.model.Book;
import br.com.gabriel.bookshelfapi.model.Category;
import br.com.gabriel.bookshelfapi.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository repository;

    public BookVO create(BookVO book){
        var entity = Mapper.parseObject(book, Book.class);
        return Mapper.parseObject(repository.save(entity), BookVO.class);
    }

    public BookVO findById(Long id){
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No book found for this ID"));
        return Mapper.parseObject(entity, BookVO.class);
    }

    public List<BookVO> findAll(){
        return Mapper.parseListObject(repository.findAll(), BookVO.class);
    }

    public BookVO update(BookVO book){
        var entity = repository.findById(book.getId()).orElseThrow(() -> new ResourceNotFoundException("No book found for this ID"));

        entity.setName(book.getName());
        entity.setDescription(book.getDescription());
        entity.setAuthor(book.getAuthor() != null ? Mapper.parseObject(book.getAuthor(), Author.class) : null);
        entity.setCategory(book.getCategory()!= null ? Mapper.parseObject(book.getCategory(), Category.class) : null);

        return Mapper.parseObject(repository.save(entity), BookVO.class);
    }

    public void delete(Long id){
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No book found for this ID"));
        repository.delete(entity);
    }
}
