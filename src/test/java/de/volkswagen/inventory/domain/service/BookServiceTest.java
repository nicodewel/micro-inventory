package de.volkswagen.inventory.domain.service;

import de.volkswagen.inventory.domain.spi.BookDAO;
import de.volkswagen.inventory.domain.spi.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookServiceTest {
BookRepository bookRepository;
BookService bookService;
List<BookDAO> bookList;

@BeforeEach
public void setUp(){
	bookRepository = Mockito.mock(BookRepository.class);
    bookService = new BookService(bookRepository);
    bookList = new ArrayList<>();
    bookList.add(new BookDAO("ABC1","SciFi","StarWars","Lucas"));
    bookList.add(new BookDAO("ABC23","Thriller","Es","King"));
}

@Test
public void returnsAListOfBooks(){
    Assertions.assertNotNull(bookService.getAllBooks());
}

@Test
public void returnsAllSavedBooksTest(){

    Mockito.when(bookRepository.findAll()).thenReturn(bookList);
    List<String> bookListIsbn = bookList.stream().map(book -> book.getISBN()).collect(Collectors.toList());
    List<String> getListIsbn = bookService.getAllBooks().stream().map(book -> book.getISBN()).collect(Collectors.toList());
    
    Assertions.assertEquals(bookListIsbn, getListIsbn);
}

@Test
public void returnsSavedBookByIsbnTest() {
	
	Mockito.when(bookRepository.findByIsbn(bookList.get(0).getISBN())).thenReturn(bookList.get(0));
	
	Assertions.assertEquals(bookList.get(0).getISBN(), bookService.findByIsbn(bookList.get(0).getISBN()).getISBN());
	Assertions.assertEquals(bookList.get(0).getAuthor(), bookService.findByIsbn(bookList.get(0).getISBN()).getAuthor());
	Assertions.assertEquals(bookList.get(0).getTitle(), bookService.findByIsbn(bookList.get(0).getISBN()).getTitle());
	
}


}