package com.echo.restaurant.exception;

import org.springframework.http.HttpStatus;

/**
 * CCreated by Rafiq(Rafiq@itconquest.com) on 2023-01-29.
 */
public class ApiConflictException extends ApiException {

    public ApiConflictException() {
    }

    /**
     * @param message
     */
    public ApiConflictException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public ApiConflictException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public ApiConflictException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpStatus getServiceStatus() {
        return HttpStatus.CONFLICT;
    }
}
