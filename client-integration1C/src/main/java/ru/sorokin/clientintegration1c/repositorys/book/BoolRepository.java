package ru.sorokin.clientintegration1c.repositorys.book;

import org.springframework.data.repository.CrudRepository;
import ru.sorokin.clientintegration1c.models.book.entitys.BookEntity;

public interface BoolRepository extends CrudRepository<BookEntity, Long> {
}
