package br.com.gabriel.bookshelfapi.repositories;

import br.com.gabriel.bookshelfapi.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
