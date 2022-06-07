package de.volkswagen.inventory.domain.service;

import de.volkswagen.inventory.domain.model.Book;
import de.volkswagen.inventory.domain.spi.BookDAO;
import de.volkswagen.inventory.domain.spi.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class BookService {

	BookRepository bookRepository;

public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
}

public List<Book> getAllBooks(){
    return mapBookDao(bookRepository.findAll());
}
public List<Book> mapBookDao(List<BookDAO> bookDAOS){
    return  bookDAOS.stream().map(b -> new Book(b.getISBN(),b.getGenre(),b.getTitle(),b.getAuthor())).collect(Collectors.toList());
}

public Book findByIsbn(String isbn) {
	BookDAO b = bookRepository.findByIsbn(isbn);
	return new Book(b.getISBN(),b.getGenre(),b.getTitle(),b.getAuthor()) ;
}
}