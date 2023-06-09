package ru.sorokin.serverintegration1c.controllers.book;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sorokin.serverintegration1c.exceptions.ValidationException;
import ru.sorokin.serverintegration1c.models.book.Book;
import ru.sorokin.serverintegration1c.models.book.BookRequest;
import ru.sorokin.serverintegration1c.services.book.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private String emptyVariable = "Пустая, NULL или меньше 1 переменная ";
    private String emptyOrNullBodyRequest = "Пустой или NULL тело запроса ";

    @GetMapping("/{id}")
    public Book findBookById(@PathVariable(name = "id") Long id) {
        if (id != null && id > 0) {
            return bookService.findById(id);
        } else {
            throw new ValidationException(emptyVariable);
        }
    }

    @GetMapping
    public List<Book> getAllBooks(@RequestParam(required = false) String author) {
        List<Book> books;
        if (!author.isEmpty()) {
            books =  bookService.findBookByAuthor(author);
        } else {
            books = bookService.getAllBooks();
        }
        return books;
    }

    @PostMapping
    public void addBook(@RequestBody BookRequest bookRequest) {
        if (bookRequest != null) {
            bookService.addBook(bookRequest);
        } else {
            throw new ValidationException(emptyOrNullBodyRequest);
        }
    }
}
