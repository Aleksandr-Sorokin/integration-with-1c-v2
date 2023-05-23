package ru.sorokin.serverintegration1c.services.authentication;

public interface AuthenticationService {
    void register(String login, String password);
    void checkCredentials(String login, String password);
}
