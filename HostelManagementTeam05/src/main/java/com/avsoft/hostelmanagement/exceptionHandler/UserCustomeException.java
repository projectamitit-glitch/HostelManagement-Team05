package com.avsoft.hostelmanagement.exceptionHandler;

import org.springframework.http.HttpStatus;

public class UserCustomeException extends RuntimeException  {
	
	private HttpStatus status;
	
	private String errorMessage;

    
    public UserCustomeException(String errorMessage, HttpStatus status) {
		super();
		this.status = status;
		this.errorMessage = errorMessage;
	}


	public HttpStatus getStatus() {
		return status;
	}


	public void setStatus(HttpStatus status) {
		this.status = status;
	}


	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	
}

