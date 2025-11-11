package pmoc.services;

import jakarta.servlet.http.HttpServletRequest;
import pmoc.entities.ManagersEntity;

import java.time.Instant;

public interface TokenService {
    String generateToken(ManagersEntity manager);
    String validateToken(String token);
    Instant generateExpirationTime();
    String recoverToken(HttpServletRequest request);
}
