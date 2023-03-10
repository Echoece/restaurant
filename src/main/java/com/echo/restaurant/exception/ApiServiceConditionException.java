package com.echo.restaurant.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by Rafiq(Rafiq@itconquest.com) on 2023-01-29.
 */
public class ApiServiceConditionException extends ApiException {

    private boolean needToAlert = false;

    public ApiServiceConditionException() {
    }

    /**
     * @param message
     */
    public ApiServiceConditionException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public ApiServiceConditionException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public ApiServiceConditionException(String message, Throwable cause) {
        super(message, cause);
    }

    public boolean isNeedToAlert() {
        return needToAlert;
    }

    public void setNeedToAlert(boolean needToAlert) {
        this.needToAlert = needToAlert;
    }


    public HttpStatus getServiceStatus() {
        return HttpStatus.SERVICE_UNAVAILABLE;
    }


}
