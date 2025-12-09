package com.avsoft.hostelmanagement.exceptionHandler;

import org.springframework.http.HttpStatus;

public class RoomServiceException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private String errorMessage;
	private HttpStatus httpStatus;
	
	
	public RoomServiceException(String errorMessage, HttpStatus httpStatus) {
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
