package ru.sorokin.serverintegration1c.models.book;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Long id;
    private String author;
    private String title;
    private Double price;
}
