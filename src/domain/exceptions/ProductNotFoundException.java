package domain.exceptions;

public class ProductNotFoundException extends RuntimeException{

    private ProductNotFoundException(String message) {
        super(message);
    }

    public static ProductNotFoundException create(String message) {
        return new ProductNotFoundException(message);
    }
}
