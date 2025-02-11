package br.com.gabriel.bookshelfapi.services;

import br.com.gabriel.bookshelfapi.data.vo.v1.BookVO;
import br.com.gabriel.bookshelfapi.exceptions.ResourceNotFoundException;
import br.com.gabriel.bookshelfapi.mapper.Mapper;
import br.com.gabriel.bookshelfapi.model.Book;
import br.com.gabriel.bookshelfapi.repositories.AuthorRepository;
import br.com.gabriel.bookshelfapi.repositories.BookRepository;
import br.com.gabriel.bookshelfapi.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository repository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    CategoryRepository categoryRepository;

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

    public BookVO update(BookVO book) {
        var entity = repository.findById(book.getId()).orElseThrow(() -> new ResourceNotFoundException("No book found for this ID"));

        entity.setName(book.getName());
        entity.setDescription(book.getDescription());

        if (book.getAuthor() != null && book.getAuthor().getId() != null) {
            var author = authorRepository.findById(book.getAuthor().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("No author found for this ID"));
            entity.setAuthor(author);
        }

        if (book.getCategory() != null && book.getCategory().getId() != null) {
            var category = categoryRepository.findById(book.getCategory().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("No category found for this ID"));
            entity.setCategory(category);
        }

        return Mapper.parseObject(repository.save(entity), BookVO.class);
    }

    public void delete(Long id){
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No book found for this ID"));
        repository.delete(entity);
    }
}
