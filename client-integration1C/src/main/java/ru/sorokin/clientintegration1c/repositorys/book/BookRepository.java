package ru.sorokin.clientintegration1c.repositorys.book;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sorokin.clientintegration1c.models.book.entitys.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
