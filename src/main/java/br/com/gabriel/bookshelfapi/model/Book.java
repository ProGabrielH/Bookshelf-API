package br.com.gabriel.bookshelfapi.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "book")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80)
    private String name;

    @Column(length = 255)
    private String description;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Book() {}

    public Book(Long id,String name, String description, Author author, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.author = author;
        this.category = category;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        if (this.author != null) {
            this.author.getBooks().remove(this);
        }
        this.author = author;
        if (author != null) {
            author.getBooks().add(this);
        }
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        if (this.category != null) {
            this.category.getBooks().remove(this);
        }
        this.category = category;
        if (category != null) {
            category.getBooks().add(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(name, book.name) && Objects.equals(description, book.description) && Objects.equals(author, book.author) && Objects.equals(category, book.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, author, category);
    }
}
