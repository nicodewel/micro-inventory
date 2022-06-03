package de.volkswagen.inventory.application.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import de.volkswagen.inventory.domain.model.Book;
import de.volkswagen.inventory.domain.service.BookService;


public class BookControllerTest {

	BookController bookController;
	BookService bookService;
	List<Book> bookList;
	
	@BeforeEach
	public void setUp(){
		bookService = Mockito.mock(BookService.class);
		bookController = new BookController(bookService);
		bookList = new ArrayList<>();
	    bookList.add(new Book("ABC1","SciFi","StarWars","Lucas"));
	    bookList.add(new Book("ABC23","Thriller","Es","King"));
	}
	
	@Test
	public void returnAllSavesBooksAsDtosTest() {
		Mockito.when(bookService.getAllBooks()).thenReturn(bookList);
		Assertions.assertTrue(bookController.getAllBooks().get(0) instanceof BookDTO);
		
	    List<String> bookListIsbn = bookList.stream().map(book -> book.getISBN()).collect(Collectors.toList());
	    List<String> getListIsbn = bookController.getAllBooks().stream().map(book -> book.getISBN()).collect(Collectors.toList());
	    
	    Assertions.assertEquals(bookListIsbn, getListIsbn);
	}
	
	@Test
	public void returnBookByIsbnAsDtoTest() {
		Mockito.when(bookService.findByIsbn(bookList.get(0).getISBN())).thenReturn(bookList.get(0));
		Assertions.assertTrue(bookController.getBookByIsbn(bookList.get(0).getISBN()) instanceof BookDTO);
		
		Assertions.assertEquals(bookController.getBookByIsbn(bookList.get(0).getISBN()).getISBN(), bookList.get(0).getISBN());
		Assertions.assertEquals(bookController.getBookByIsbn(bookList.get(0).getISBN()).getAuthor(), bookList.get(0).getAuthor());
		Assertions.assertEquals(bookController.getBookByIsbn(bookList.get(0).getISBN()).getGenre(), bookList.get(0).getGenre());
		Assertions.assertEquals(bookController.getBookByIsbn(bookList.get(0).getISBN()).getTitle(), bookList.get(0).getTitle());
	}
}
