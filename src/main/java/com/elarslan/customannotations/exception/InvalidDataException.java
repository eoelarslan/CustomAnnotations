package com.elarslan.customannotations.exception;

/**
 * This checked exception class is created for static/compile-time classes
 */
public class InvalidDataException extends Exception {

    @java.io.Serial
    private static final long serialVersionUID = 1L;

    public InvalidDataException(String message) {
        super(message);
    }

    public InvalidDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
