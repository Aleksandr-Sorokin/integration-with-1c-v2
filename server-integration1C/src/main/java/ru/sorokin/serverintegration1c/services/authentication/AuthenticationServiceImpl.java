package ru.sorokin.serverintegration1c.services.authentication;

import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import ru.sorokin.serverintegration1c.exceptions.LoginException;
import ru.sorokin.serverintegration1c.exceptions.RegistrationException;
import ru.sorokin.serverintegration1c.models.authentication.ClientEntity;
import ru.sorokin.serverintegration1c.repositorys.authentication.AuthenticationRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationRepository authenticationRepository;

    @Override
    public void register(String login, String password) {
        if (authenticationRepository.findById(login).isPresent()) {
            throw new RegistrationException(String.format("Пользователь с логином %s зарегистрирован", login));
        }
        String hash = BCrypt.hashpw(password, BCrypt.gensalt());
        authenticationRepository.save(new ClientEntity(login, hash));
    }

    @Override
    public void checkCredentials(String login, String password) {
        Optional<ClientEntity> authEntity = authenticationRepository.findById(login);
        if (authEntity.isEmpty()) {
            throw new LoginException(String.format("Пользователь с логином %s не найден", login));
        }
        ClientEntity clientEntity = authEntity.get();
        if (!BCrypt.checkpw(password, clientEntity.getHash())) {
            throw new LoginException("Не верный пароль");
        }
    }
}
