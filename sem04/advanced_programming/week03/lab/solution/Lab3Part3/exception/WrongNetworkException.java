package Lab3Part3.exception;

/**
 * This exception is thrown when the network is not the expected one.
 */
public class WrongNetworkException extends Exception {
    public WrongNetworkException(String message) {
        super(message);
    }
}
