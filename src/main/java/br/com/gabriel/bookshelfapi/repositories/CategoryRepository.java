package br.com.gabriel.bookshelfapi.repositories;

import br.com.gabriel.bookshelfapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
