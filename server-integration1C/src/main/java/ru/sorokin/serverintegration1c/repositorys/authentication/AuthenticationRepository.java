package ru.sorokin.serverintegration1c.repositorys.authentication;

import org.springframework.data.repository.CrudRepository;
import ru.sorokin.serverintegration1c.models.authentication.ClientEntity;

public interface AuthenticationRepository extends CrudRepository<ClientEntity, String> {
}
