package de.volkswagen.inventory.infrastructure;

import de.volkswagen.inventory.domain.model.Book;
import de.volkswagen.inventory.domain.spi.BookDAO;
import de.volkswagen.inventory.domain.spi.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookDaoService {

BookRepository bookRepository;

public BookDaoService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
}

public List<Book> getAllBooks() {
    return  mapBookDao(bookRepository.findAll());
}

public List<Book> mapBookDao(List<BookDAO> bookDAOS){
    return  bookDAOS.stream().map(b -> new Book(b.getISBN(),b.getGenre(),b.getTitle(),b.getAuthor())).collect(Collectors.toList());
}
}