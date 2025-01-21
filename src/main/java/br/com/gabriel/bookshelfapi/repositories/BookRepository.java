package br.com.gabriel.bookshelfapi.repositories;

import br.com.gabriel.bookshelfapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
