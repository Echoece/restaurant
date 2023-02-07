package com.echo.restaurant.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by Rafiq(Rafiq@itconquest.com) on 2023-01-29.
 */
public class ApiNotAcceptableException extends ApiException {

    public ApiNotAcceptableException() {
    }

    /**
     * @param message
     */
    public ApiNotAcceptableException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public ApiNotAcceptableException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public ApiNotAcceptableException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpStatus getServiceStatus() {
        return HttpStatus.NOT_ACCEPTABLE;
    }
}
