package ru.sorokin.clientintegration1c.services.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sorokin.clientintegration1c.models.book.Book;
import ru.sorokin.clientintegration1c.repositorys.book.BoolRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BoolRepository boolRepository;

    @Override
    public Book findById(Long id) {
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return null;
    }

    @Override
    public void addBook(Book book) {

    }
}
