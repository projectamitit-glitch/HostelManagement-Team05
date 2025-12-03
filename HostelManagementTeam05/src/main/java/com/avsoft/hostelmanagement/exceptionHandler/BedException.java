package com.avsoft.hostelmanagement.exceptionHandler;

import org.springframework.http.HttpStatus;

public class BedException  extends RuntimeException{
	
	private String message;
	private HttpStatus status;

    public BedException(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }

    public String getErrorMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return status;
    }
}
	
	


