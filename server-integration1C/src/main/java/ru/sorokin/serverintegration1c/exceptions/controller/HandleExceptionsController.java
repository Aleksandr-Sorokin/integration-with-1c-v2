package ru.sorokin.serverintegration1c.exceptions.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import ru.sorokin.serverintegration1c.exceptions.BookNotFoundException;
import ru.sorokin.serverintegration1c.exceptions.NotSaveInRepository;
import ru.sorokin.serverintegration1c.exceptions.ValidationException;
import ru.sorokin.serverintegration1c.exceptions.models.ErrorResponse;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HandleExceptionsController {
    private final String titleMessage = "Message: ";
    private final String titleStackTrace = "StackTrace: ";

    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleBookNotFoundException(final BookNotFoundException e) {
        return new ErrorResponse(String.format(
                titleMessage + e.getMessage() + "\n" +
                        titleStackTrace + e.getStackTrace().toString()
        ));
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidationException(final ValidationException e) {
        return new ErrorResponse(String.format(
                titleMessage + e.getMessage() + "\n" +
                        titleStackTrace + e.getStackTrace().toString()
        ));
    }
    @ExceptionHandler(NotSaveInRepository.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleNotSaveInRepository(final NotSaveInRepository e) {
        return new ErrorResponse(String.format(
                titleMessage + e.getMessage() + "\n" +
                        titleStackTrace + e.getStackTrace().toString()
        ));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleMethodMismatchException(MethodArgumentTypeMismatchException e) {
        Map<String, String> response = new HashMap<>();
        response.put("error", String.format("Unknown %s: %s", e.getName(), e.getValue()));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
