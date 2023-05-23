package ru.sorokin.serverintegration1c.exceptions;

public class LoginException extends RuntimeException {
    public LoginException(String massage) {
        super(massage);
    }
}
