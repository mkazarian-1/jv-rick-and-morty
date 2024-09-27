package mate.academy.rickandmorty.exeption;

public class ConnectionException extends RuntimeException{
    public ConnectionException(String message) {
        super(message);
    }

    public ConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
