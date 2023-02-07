package com.echo.restaurant.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by Rafiq(Rafiq@itconquest.com) on 2023-01-29.
 */
public class ApiForbiddenException extends ApiException {

    public ApiForbiddenException() {
    }

    /**
     * @param message
     */
    public ApiForbiddenException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public ApiForbiddenException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public ApiForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpStatus getServiceStatus() {
        return HttpStatus.FORBIDDEN;
    }
}
