package de.volkswagen.inventory.domain.spi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookDAO,Long> {
}