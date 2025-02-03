package br.com.gabriel.bookshelfapi.services;

import br.com.gabriel.bookshelfapi.data.vo.v1.AuthorVO;
import br.com.gabriel.bookshelfapi.exceptions.ResourceNotFoundException;
import br.com.gabriel.bookshelfapi.mapper.Mapper;
import br.com.gabriel.bookshelfapi.model.Author;
import br.com.gabriel.bookshelfapi.model.Book;
import br.com.gabriel.bookshelfapi.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository repository;

    public AuthorVO create(AuthorVO author){
        var entity = Mapper.parseObject(author, Author.class);
        return Mapper.parseObject(repository.save(entity), AuthorVO.class);
    }

    public AuthorVO findById(Long id){
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No author found for this id"));
        return Mapper.parseObject(entity, AuthorVO.class);
    }

    public List<AuthorVO> findAll(){
        return Mapper.parseListObject(repository.findAll(), AuthorVO.class);
    }

    public AuthorVO update(AuthorVO author){
        var entity = repository.findById(author.getId()).orElseThrow(() -> new ResourceNotFoundException("No author found for this id"));

        entity.setName(author.getName());
        entity.setBooks(author.getBooks() != null ? Mapper.parseListObject(author.getBooks(), Book.class) : null);

        return Mapper.parseObject(repository.save(entity), AuthorVO.class);
    }

    public void delete(Long id){
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No author found for this id"));
        repository.delete(entity);
    }
}
