package ru.sorokin.clientintegration1c.exceptions.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import ru.sorokin.clientintegration1c.exceptions.BookNotFoundException;
import ru.sorokin.clientintegration1c.exceptions.models.ErrorResponse;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HandleExceptionsController {

    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleBookNotFoundException(final BookNotFoundException e) {
        return new ErrorResponse(String.format("Message: " + e.getMessage()
                + "\nStackTrace:" + e.getStackTrace().toString()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleMethodMismatchException(MethodArgumentTypeMismatchException e) {
        Map<String, String> response = new HashMap<>();
        response.put("error", String.format("Unknown %s: %s", e.getName(), e.getValue()));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
