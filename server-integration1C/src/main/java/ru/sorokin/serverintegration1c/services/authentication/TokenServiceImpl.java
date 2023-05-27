package ru.sorokin.serverintegration1c.services.authentication;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService {
    @Value("${auth.jwt.secret}")
    private String secretKey;

    @Override
    public String generatedToken(String login) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        Instant timeNow = Instant.now();
        Instant timeExpiration = timeNow.plus(5, ChronoUnit.MINUTES);
        return JWT.create()
                .withIssuer("auth-service")
                .withAudience("integrationWith1C")
                .withSubject(login)
                .withIssuedAt(Date.from(timeNow))
                .withExpiresAt(Date.from(timeExpiration))
                .sign(algorithm);
    }
}
