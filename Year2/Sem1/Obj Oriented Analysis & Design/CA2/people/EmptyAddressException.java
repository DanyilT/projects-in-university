package people;

import java.lang.RuntimeException;

public class EmptyAddressException extends RuntimeException {

    public EmptyAddressException(String message) {
        super(message);
    }
}
