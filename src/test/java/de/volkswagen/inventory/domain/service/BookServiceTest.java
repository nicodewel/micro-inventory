package de.volkswagen.inventory.domain.service;

import de.volkswagen.inventory.domain.model.Book;
import de.volkswagen.inventory.infrastructure.BookDaoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class BookServiceTest {
BookDaoService bookDaoService;
BookService bookService;

@BeforeEach
public void setUp(){
    bookDaoService = Mockito.mock(BookDaoService.class);
    bookService = new BookService(bookDaoService);
}

@Test
public void returnsAListOfBooks(){
    Assertions.assertNotNull(bookService.getAllBooks());
}

@Test
public void returnsAllSavedBooks(){

    List<Book> bookList = new ArrayList<>();
    bookList.add(new Book("ABC1","SciFi","StarWars","Lucas"));
    bookList.add(new Book("ABC23","Thriller","Es","King"));

    Mockito.when(bookDaoService.getAllBooks()).thenReturn(bookList);
    Assertions.assertEquals(bookList, bookService.getAllBooks());
}

}