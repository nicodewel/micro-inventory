package de.volkswagen.inventory.application.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.volkswagen.inventory.domain.model.Book;
import de.volkswagen.inventory.domain.service.BookService;

@RestController
public class BookController {
	
	BookService bookService;
	
	public BookController (BookService bookService) {		
		this.bookService = bookService;
	}

	@GetMapping("/books")
	public List<BookDTO> getAllBooks() {
		return bookService.getAllBooks().stream().map(b -> new BookDTO(b.getISBN(),b.getGenre(),b.getTitle(),b.getAuthor())).collect(Collectors.toList());
	}
	
	@GetMapping("/bookByIsbn")
	public BookDTO getBookByIsbn(String isbn) {
		Book book = bookService.findByIsbn(isbn);
		BookDTO bookDto = new BookDTO(book.getISBN(), book.getGenre(), book.getTitle(), book.getAuthor());
		return bookDto;
	}
}
