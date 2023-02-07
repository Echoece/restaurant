package com.echo.restaurant.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by Rafiq(Rafiq@itconquest.com) on 2023-01-29.
 */
public class ApiBadGatewayException extends ApiException {

    public ApiBadGatewayException() {

    }

    /**
     * @param message
     */
    public ApiBadGatewayException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public ApiBadGatewayException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public ApiBadGatewayException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpStatus getServiceStatus() {
        return HttpStatus.BAD_GATEWAY;
    }
}
