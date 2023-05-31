package ru.sorokin.serverintegration1c.controllers.authentication;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sorokin.serverintegration1c.models.authentication.TokenResponse;
import ru.sorokin.serverintegration1c.models.users.User;
import ru.sorokin.serverintegration1c.services.authentication.AuthenticationService;
import ru.sorokin.serverintegration1c.services.authentication.TokenService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authService;
    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity<String> register(@RequestBody User user) {
        authService.register(user.getLogin(), user.getPassword());
        return ResponseEntity.ok(String.format("%s успешно зарегистрирован", user.getLogin()));
    }

    @PostMapping
    public TokenResponse getToken(@RequestBody User user) {
        authService.checkCredentials(user.getLogin(), user.getPassword());
        return new TokenResponse(tokenService.generatedToken(user.getLogin()));
    }
}
