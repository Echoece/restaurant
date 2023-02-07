package com.echo.restaurant.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by Rafiq(Rafiq@itconquest.com) on 2023-01-29.
 */
public abstract class ApiException extends Exception {

    private String extraMessage;

    public ApiException() {
    }

    /**
     * @param message
     */
    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Object extraMessage) {
        super(message);
        this.extraMessage = extraMessage.toString();
    }

    /**
     * @param cause
     */
    public ApiException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getExtraMessage() {
        return this.extraMessage;
    }

    abstract HttpStatus getServiceStatus();

    public String getServiceMessage() {
        return "";
    }
}
