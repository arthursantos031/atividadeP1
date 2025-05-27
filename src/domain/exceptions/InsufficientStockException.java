package domain.exceptions;

public class InsufficientStockException extends RuntimeException
{
    private InsufficientStockException(String message) {
        super(message);
    }

    public static InsufficientStockException create(String message) {
        return new InsufficientStockException(message);
    }
}
