package de.volkswagen.inventory.domain.service;

import de.volkswagen.inventory.domain.model.Book;
import de.volkswagen.inventory.infrastructure.BookDaoService;

import java.util.List;

public class BookService {

BookDaoService bookDaoService;

public BookService(BookDaoService bookDaoService) {
    this.bookDaoService = bookDaoService;
}

public List<Book> getAllBooks(){
    return bookDaoService.getAllBooks();
}
}