package domain.exceptions;

public class InvalidProductException extends RuntimeException{
    private InvalidProductException(String message) {
        super(message);
    }

    public static InvalidProductException create(String message) {
        return new InvalidProductException(message);
    }
}
