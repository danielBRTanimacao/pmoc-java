package pmoc.exceptions.customs;

public class JWTAuthException extends RuntimeException {
    public JWTAuthException(String message) {
        super(message);
    }
    public JWTAuthException(String message, Throwable cause) {
        super(message, cause);
    }
}
