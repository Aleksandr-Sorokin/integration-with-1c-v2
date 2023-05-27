package ru.sorokin.serverintegration1c.models.users;

import lombok.Value;

@Value
public class User {
    String login;
    String password;
}
