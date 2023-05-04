package ru.sorokin.clientintegration1c.exceptions.models;

import lombok.Data;

@Data
public class ErrorResponse {
    private final String textException;
}
