package com.avsoft.hostelmanagement.exceptionHandler;

import org.springframework.http.HttpStatus;

public class ImageServiceException extends  RuntimeException{
	private HttpStatus status;
	
	private String errorMessage;

   

	public ImageServiceException(HttpStatus status, String errorMessage) {
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
