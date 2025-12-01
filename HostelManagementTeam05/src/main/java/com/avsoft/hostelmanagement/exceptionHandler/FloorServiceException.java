
package com.avsoft.hostelmanagement.exceptionHandler;

import org.springframework.http.HttpStatus;

public class FloorServiceException extends RuntimeException{
	 private String errorMessage;
	    private HttpStatus httpStatus;
	    
	    public  FloorServiceException (String errorMessage, HttpStatus httpStatus) {
	    	super(errorMessage);
	        this.errorMessage = errorMessage;
	        this.httpStatus = httpStatus;
	    }

	    @Override
	    public String getMessage() {
	        return errorMessage;
	    }
}
