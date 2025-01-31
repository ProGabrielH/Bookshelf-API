package br.com.gabriel.bookshelfapi.data.vo.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AurhorVO {

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

    public AurhorVO() {}

    public AurhorVO(Long id, String name, List<BookVO> books) {
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
        AurhorVO aurhorVO = (AurhorVO) o;
        return Objects.equals(id, aurhorVO.id) && Objects.equals(name, aurhorVO.name) && Objects.equals(books, aurhorVO.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, books);
    }
}
