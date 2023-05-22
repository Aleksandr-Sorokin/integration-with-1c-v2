package ru.sorokin.serverintegration1c.services.book;

import ru.sorokin.serverintegration1c.models.book.Book;
import ru.sorokin.serverintegration1c.models.book.BookRequest;

import java.util.List;

public interface BookService {
    Book findById(Long id);
    List<Book> getAllBooks();
    void addBook(BookRequest bookRequest);
    List<Book> findBookByAuthor(String author);
}
