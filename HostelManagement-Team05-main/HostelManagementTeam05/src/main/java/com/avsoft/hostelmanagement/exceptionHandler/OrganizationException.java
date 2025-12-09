package com.avsoft.hostelmanagement.exceptionHandler;

import org.springframework.http.HttpStatus;

public class OrganizationException extends RuntimeException{
	
	private String errorMessage;
	private HttpStatus httpStatus;
	
	
	public OrganizationException(String errorMessage, HttpStatus httpStatus) {
		this.errorMessage = errorMessage;
		this.httpStatus = httpStatus;
	}
	
	public String getMessage() {
		return errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}


}
