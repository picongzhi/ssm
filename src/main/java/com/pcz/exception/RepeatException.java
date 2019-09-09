package com.pcz.exception;

public class RepeatException extends RuntimeException {
    public RepeatException(String message) {
        super(message);
    }

    public RepeatException(String message, Throwable cause) {
        super(message, cause);
    }
}
