package ru.sorokin.serverintegration1c.services.authentication;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

@Service
@Slf4j
public class TokenServiceImpl implements TokenService {
    @Value("${auth.jwt.secret}")
    private String secretKey;

    @Value("{$auth.jwt.issuer}")
    private String issuer;

    @Value("{$auth.jwt.audience}")
    private String audience;

    @Override
    public String generatedToken(String login) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        Instant timeNow = Instant.now();
        Instant timeExpiration = timeNow.plus(5, ChronoUnit.MINUTES);
        return JWT.create()
                .withIssuer(this.issuer)
                .withAudience(this.audience)
                .withSubject(login)
                .withIssuedAt(Date.from(timeNow))
                .withExpiresAt(Date.from(timeExpiration))
                .sign(algorithm);
    }

    @Override
    public boolean checkToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = verifier.verify(token);
            if (!decodedJWT.getIssuer().equals(this.issuer)) {
                log.error("Issuer is incorrect");
                return false;
            }
            if (!decodedJWT.getAudience().equals(this.audience)) {
                log.error("Audience is incorrect");
                return false;
            }
            return true;
        } catch (JWTVerificationException e) {
            log.error(String.format("Token is invalid: %s", e.getMessage()));
            return false;
        }
    }
}
