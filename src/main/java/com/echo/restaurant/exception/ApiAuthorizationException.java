package com.echo.restaurant.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by Rafiq(Rafiq@itconquest.com) on 2023-01-29.
 */
public class ApiAuthorizationException extends ApiException {

    public ApiAuthorizationException() {
    }


    /**
     * @param message
     */
    public ApiAuthorizationException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public ApiAuthorizationException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public ApiAuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpStatus getServiceStatus() {
        return HttpStatus.UNAUTHORIZED;
    }
}
