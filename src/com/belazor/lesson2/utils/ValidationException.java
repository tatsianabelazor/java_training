package com.belazor.lesson2.utils;

/**
 * Created by Tatsiana_Belazor on 12-Feb-18.
 */
public class ValidationException extends Exception {

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
