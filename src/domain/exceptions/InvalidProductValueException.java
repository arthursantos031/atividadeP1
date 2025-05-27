package domain.exceptions;

public class InvalidProductValueException extends RuntimeException{

    private InvalidProductValueException(String message) {
        super(message);
    }

    public static InvalidProductValueException create(String message) {
        return new InvalidProductValueException(message);
    }
}
