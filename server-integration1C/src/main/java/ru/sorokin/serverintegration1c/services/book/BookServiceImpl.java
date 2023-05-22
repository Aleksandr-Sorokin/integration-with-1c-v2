package ru.sorokin.serverintegration1c.services.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sorokin.serverintegration1c.configurations.MapperUtil;
import ru.sorokin.serverintegration1c.exceptions.BookNotFoundException;
import ru.sorokin.serverintegration1c.exceptions.NotSaveInRepository;
import ru.sorokin.serverintegration1c.models.book.Book;
import ru.sorokin.serverintegration1c.models.book.BookRequest;
import ru.sorokin.serverintegration1c.models.book.entitys.BookEntity;
import ru.sorokin.serverintegration1c.repositorys.book.BookRepository;
import ru.sorokin.serverintegration1c.services.book.mapper.BookMapperImpl;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapperImpl bookMapper;
    private String bookByIdNotFound = "Книга не найдена по ID ";
    private String bookNotSave = "Не охранена книга ";

    @Override
    public Book findById(Long id) {
        BookEntity bookEntity = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(String.format(bookByIdNotFound + id)));
        return bookMapper.toBookTargetState(bookEntity, Book.class);
    }

    @Override
    public List<Book> getAllBooks() {
        List<BookEntity> bookEntities = bookRepository.findAll();
        return MapperUtil.convertList(bookEntities, bookEntity -> bookMapper.toBookTargetState(bookEntity, Book.class));
    }

    @Override
    @Transactional
    public void addBook(BookRequest bookRequest) {
        Book book = bookMapper.toBookTargetState(bookRequest, Book.class);
        BookEntity entity = bookRepository.save(bookMapper.toBookTargetState(book, BookEntity.class));
        if (entity.getId() == null) throw new NotSaveInRepository(bookNotSave + book.toString());
    }

    @Override
    public List<Book> findBookByAuthor(String author) {
        List<BookEntity> bookEntities = bookRepository.findBookEntitiesByAuthorContaining(author);
        return MapperUtil.convertList(bookEntities, bookEntity -> bookMapper.toBookTargetState(bookEntity, Book.class));
    }
}
