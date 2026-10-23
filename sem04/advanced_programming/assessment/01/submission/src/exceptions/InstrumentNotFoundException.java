package exceptions;

import logging.AssignmentLogger;    // Logger

/**
 * Custom exception class for handling cases where an instrument is not found.
 */
public class InstrumentNotFoundException extends Exception {
    public InstrumentNotFoundException(String message) {
        super(message);
        AssignmentLogger.logConstructor(this);  // Logger
    }
}
