package com.echo.restaurant.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Rafiq(Rafiq@itconquest.com)
 * @created on 2023-01-29.
 */

public class ApiUnProcessableEntityException extends ApiException {

    public ApiUnProcessableEntityException() {
    }


    /**
     * @param message
     */
    public ApiUnProcessableEntityException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public ApiUnProcessableEntityException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public ApiUnProcessableEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpStatus getServiceStatus() {
        return HttpStatus.UNPROCESSABLE_ENTITY;
    }
}
