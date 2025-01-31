package br.com.gabriel.bookshelfapi.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;

public class BookVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String description;
    private AuthorVO author;
    private CategoryVO category;

    public BookVO() {}

    public BookVO(Long id, String name, String description, AuthorVO author, CategoryVO category) {
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

    public AuthorVO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorVO author) {
        if (this.author != null) {
            this.author.getBooks().remove(this);
        }
        this.author = author;
        if (author != null) {
            author.getBooks().add(this);
        }
    }

    public CategoryVO getCategory() {
        return category;
    }

    public void setCategory(CategoryVO category) {
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
        BookVO bookVO = (BookVO) o;
        return Objects.equals(id, bookVO.id) && Objects.equals(name, bookVO.name) && Objects.equals(description, bookVO.description) && Objects.equals(author, bookVO.author) && Objects.equals(category, bookVO.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, author, category);
    }
}
