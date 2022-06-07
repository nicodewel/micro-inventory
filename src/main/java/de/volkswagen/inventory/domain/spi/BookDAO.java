package de.volkswagen.inventory.domain.spi;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Book")
public class BookDAO {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
//@GeneratedValue
private long id;
private String isbn;
private String genre;
private String title;
private String author;

public BookDAO() {
	
}

public BookDAO(String ISBN, String genre, String title, String author) {
    this.isbn = ISBN;
    this.genre = genre;
    this.title = title;
    this.author = author;
}

public long getId() {
    return id;
}

public void setId(long id) {
    this.id = id;
}

public String getISBN() {
    return isbn;
}

public void setISBN(String ISBN) {
    this.isbn = ISBN;
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
}