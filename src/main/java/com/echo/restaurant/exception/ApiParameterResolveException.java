package com.echo.restaurant.exception;

import org.springframework.http.HttpStatus;

/**
 * ParameterResolveException
 *
 * @author Rafiq(Rafiq@itconquest.com) on 2023-01-29.
 */
public class ApiParameterResolveException extends ApiException {

    private static final long serialVersionUID = 7729045683866048832L;

    public ApiParameterResolveException() {
    }

    ApiParameterResolveException(String message) {
        super(message);
    }

    @Override
    HttpStatus getServiceStatus() {
        return null;
    }
}
