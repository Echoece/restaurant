package com.echo.restaurant.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by Rafiq(Rafiq@itconquest.com) on 2023-01-29.
 */
public class ApiBadRequestException extends ApiException {

    public ApiBadRequestException() {
    }

    /**
     * @param message
     */
    public ApiBadRequestException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public ApiBadRequestException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public ApiBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpStatus getServiceStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
