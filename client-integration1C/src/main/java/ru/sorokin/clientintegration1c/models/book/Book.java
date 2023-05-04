package ru.sorokin.clientintegration1c.models.book;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class Book {
    private final Long id;
    private final String author;
    private final String title;
    private final Double price;
}
