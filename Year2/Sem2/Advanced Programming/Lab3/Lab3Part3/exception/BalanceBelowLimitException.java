package Lab3Part3.exception;

/**
 * This exception is thrown when the balance is below the limit.
 */
public class BalanceBelowLimitException extends Exception {
    public BalanceBelowLimitException(String message) {
        super(message);
    }
}
