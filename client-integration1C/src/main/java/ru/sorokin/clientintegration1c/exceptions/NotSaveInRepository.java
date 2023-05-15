package ru.sorokin.clientintegration1c.exceptions;

public class NotSaveInRepository extends RuntimeException {
    public NotSaveInRepository(String message) {
        super(message);
    }
}
