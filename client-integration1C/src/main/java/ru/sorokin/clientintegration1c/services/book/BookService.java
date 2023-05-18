package ru.sorokin.clientintegration1c.services.book;

import ru.sorokin.clientintegration1c.models.book.Book;
import ru.sorokin.clientintegration1c.models.book.BookRequest;
import ru.sorokin.clientintegration1c.models.book.entitys.BookEntity;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book findById(Long id);
    List<Book> getAllBooks();
    void addBook(BookRequest bookRequest);
    List<Book> findBookByAuthor(String author);
}
