package br.com.gabriel.bookshelfapi.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@JsonIncludeProperties({"id", "name", "description" })
public class CategoryVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String description;
    private List<BookVO> books = new ArrayList<>();

    public void addBook(BookVO book){
        books.add(book);
        book.setCategory(this);
    }

    public void removeBook(BookVO book){
        books.remove(book);
        book.setCategory(null);
    }

    public CategoryVO() {}

    public CategoryVO(Long id, String name, String description, List<BookVO> books) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookVO> getBooks() {
        return books;
    }

    public void setBooks(List<BookVO> books) {
        this.books = books;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryVO that = (CategoryVO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(books, that.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, books);
    }
}
