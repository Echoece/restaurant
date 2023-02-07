package com.echo.restaurant.dto;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Rafiq(Rafiq@itconquest.com) on 2023-01-29.
 */
public class ErrorMessage {
    private List<HashMap> errors;

    public ErrorMessage() {
    }

    public ErrorMessage(List<HashMap> errors) {
        this.errors = errors;
    }

    public List<HashMap> getErrors() {
        return errors;
    }

    public void setErrors(List<HashMap> errors) {
        this.errors = errors;
    }
}
