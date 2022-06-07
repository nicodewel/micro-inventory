package de.volkswagen.inventory.domain.spi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BookRepository extends JpaRepository<BookDAO,Long> {

	BookDAO findByIsbn(String isbn);
}