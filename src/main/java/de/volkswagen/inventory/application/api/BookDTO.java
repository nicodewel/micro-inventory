package de.volkswagen.inventory.application.api;

public class BookDTO {
	
	private String ISBN;
	private String genre;
	private String title;
	private String author;

	public String getISBN() {
	    return ISBN;
	}

	public void setISBN(String ISBN) {
	    this.ISBN = ISBN;
	}

	public String getGenre() {
	    return genre;
	}

	public void setGenre(String genre) {
	    this.genre = genre;
	}

	public String getTitle() {
	    return title;
	}

	public void setTitle(String title) {
	    this.title = title;
	}

	public String getAuthor() {
	    return author;
	}

	public void setAuthor(String author) {
	    this.author = author;
	}

	public BookDTO(String ISBN, String genre, String title, String author) {
	    this.ISBN = ISBN;
	    this.genre = genre;
	    this.title = title;
	    this.author = author;
	}

}
