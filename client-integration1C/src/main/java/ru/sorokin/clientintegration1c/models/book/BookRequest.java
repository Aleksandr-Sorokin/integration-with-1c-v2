package ru.sorokin.clientintegration1c.models.book;

import lombok.Data;

@Data
public class BookRequest {
    private String author;
    private String title;
    private Double price;
}
