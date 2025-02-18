package br.com.gabriel.bookshelfapi.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonIncludeProperties({"name", "description" })
public class AuthorVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private List<BookVO> books = new ArrayList<>();

    public void addBook(BookVO book){
        books.add(book);
        book.setAuthor(this);
    }

    public void removeBook(BookVO book){
        books.remove(book);
        book.setAuthor(null);
    }

    public AuthorVO() {}

    public AuthorVO(Long id, String name, List<BookVO> books) {
        this.id = id;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorVO authorVO = (AuthorVO) o;
        return Objects.equals(id, authorVO.id) && Objects.equals(name, authorVO.name) && Objects.equals(books, authorVO.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, books);
    }
}
