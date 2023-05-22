package ru.sorokin.serverintegration1c.exceptions;

public class NotSaveInRepository extends RuntimeException {
    public NotSaveInRepository(String message) {
        super(message);
    }
}
