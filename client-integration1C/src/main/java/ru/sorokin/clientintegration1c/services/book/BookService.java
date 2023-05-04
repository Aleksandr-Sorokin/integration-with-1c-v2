package ru.sorokin.clientintegration1c.services.book;

import ru.sorokin.clientintegration1c.models.book.Book;

import java.util.List;

public interface BookService {
    Book findById(Long id);
    List<Book> getAllBooks();
    void addBook(Book book);
}
