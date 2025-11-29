package com.avsoft.hostelmanagement.exceptionHandler;

import org.springframework.http.HttpStatus;

public class BuildingException extends RuntimeException {

    private String errorMessage;
    private HttpStatus httpStatus;

    public BuildingException(String errorMessage, HttpStatus httpStatus) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
