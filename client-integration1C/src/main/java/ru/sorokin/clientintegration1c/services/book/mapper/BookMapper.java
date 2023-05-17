package ru.sorokin.clientintegration1c.services.book.mapper;

import ru.sorokin.clientintegration1c.exceptions.ValidationException;
import ru.sorokin.clientintegration1c.models.book.Book;
import ru.sorokin.clientintegration1c.models.book.BookRequest;
import ru.sorokin.clientintegration1c.models.book.entitys.BookEntity;

public interface BookMapper {
    <T> T toBookTargetState(Object bookSource, Class<T> classBookTarget);
}
