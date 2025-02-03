package br.com.gabriel.bookshelfapi.services;

import br.com.gabriel.bookshelfapi.data.vo.v1.CategoryVO;
import br.com.gabriel.bookshelfapi.exceptions.ResourceNotFoundException;
import br.com.gabriel.bookshelfapi.mapper.Mapper;
import br.com.gabriel.bookshelfapi.model.Book;
import br.com.gabriel.bookshelfapi.model.Category;
import br.com.gabriel.bookshelfapi.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository repository;

    public CategoryVO create(CategoryVO category){
        var entity = Mapper.parseObject(category, Category.class);
        return Mapper.parseObject(repository.save(entity), CategoryVO.class);
    }

    public CategoryVO findById(Long id){
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No category found for this id"));
        return Mapper.parseObject(entity, CategoryVO.class);
    }

    public List<CategoryVO> findAll(){
        return Mapper.parseListObject(repository.findAll(), CategoryVO.class);
    }

    public CategoryVO update(CategoryVO category){
        var entity = repository.findById(category.getId()).orElseThrow(() -> new ResourceNotFoundException("No category found for this id"));

        entity.setName(category.getName());
        entity.setDescription(category.getDescription());
        entity.setBooks(category.getBooks() != null ? Mapper.parseListObject(category.getBooks(), Book.class) : null);

        return Mapper.parseObject(repository.save(entity), CategoryVO.class);
    }

    public void delete(Long id){
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No category found for this id"));
        repository.delete(entity);
    }
}

