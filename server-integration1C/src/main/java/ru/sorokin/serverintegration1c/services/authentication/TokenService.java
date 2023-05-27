package ru.sorokin.serverintegration1c.services.authentication;

public interface TokenService {
    String generatedToken(String login);
}
