package com.echo.restaurant.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by Rafiq(Rafiq@itconquest.com) on 2023-01-29.
 */
public class ApiTimeoutException extends ApiException {

    public ApiTimeoutException() {
    }

    /**
     * @param message
     */
    public ApiTimeoutException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public ApiTimeoutException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public ApiTimeoutException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpStatus getServiceStatus() {
        return HttpStatus.REQUEST_TIMEOUT;
    }
}
