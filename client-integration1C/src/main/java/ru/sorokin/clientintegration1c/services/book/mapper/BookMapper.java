package ru.sorokin.clientintegration1c.services.book.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.sorokin.clientintegration1c.exceptions.ValidationException;
import ru.sorokin.clientintegration1c.models.book.Book;
import ru.sorokin.clientintegration1c.models.book.entitys.BookEntity;

@Component
@RequiredArgsConstructor
public class BookMapper {

    private final ModelMapper mapper;
    private String emptyData = "Отсутствуют данные";

    public Book toBook(BookEntity bookEntity) {
        if (bookEntity != null) {
            return mapper.map(bookEntity, Book.class);
        } else {
            throw new ValidationException(emptyData);
        }
    }

    public BookEntity toBookEntity(Book book) {
        if (book != null) {
            return mapper.map(book, BookEntity.class);
        } else {
            throw new ValidationException(emptyData);
        }
    }
}
