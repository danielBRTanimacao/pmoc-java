package pmoc.services.impl;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pmoc.entities.ManagersEntity;
import pmoc.exceptions.customs.JWTAuthException;
import pmoc.services.TokenService;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenServiceImpl implements TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    @Override
    public String generateToken(ManagersEntity manager) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.create()
                    .withIssuer("login-auth-api")
                    .withSubject(manager.getEmail())
                    .withExpiresAt(this.generateExpirationTime())
                    .sign(algorithm);

        } catch (JWTCreationException e) {
            throw new JWTAuthException("Error while authenticating");
        }
    }

    @Override
    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("login-auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            return null;
        }
    }

    @Override
    public Instant generateExpirationTime() {
        return LocalDateTime.now().plusHours(23).toInstant(ZoneOffset.of("-03:00"));
    }

    @Override
    public String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if(authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }
}
