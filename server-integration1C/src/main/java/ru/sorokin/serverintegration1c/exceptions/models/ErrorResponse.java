package ru.sorokin.serverintegration1c.exceptions.models;

import lombok.Data;

@Data
public class ErrorResponse {
    private final String textException;
}
