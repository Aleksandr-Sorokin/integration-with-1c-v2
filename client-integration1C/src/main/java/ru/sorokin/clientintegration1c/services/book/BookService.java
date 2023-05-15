package ru.sorokin.clientintegration1c.services.book;

import ru.sorokin.clientintegration1c.models.book.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book findById(Long id);
    List<Book> getAllBooks();
    void addBook(Book book);
}
