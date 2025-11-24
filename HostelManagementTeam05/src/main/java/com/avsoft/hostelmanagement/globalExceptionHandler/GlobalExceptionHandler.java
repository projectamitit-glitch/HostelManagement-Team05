package com.avsoft.hostelmanagement.globalExceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.avsoft.hostelmanagement.exceptionHandler.HostelServiceExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(com.avsoft.hostelmanagement.exceptionHandler.HostelServiceExceptionHandler.class)
	public ResponseEntity hostelException(HostelServiceExceptionHandler hostelExpHandler) {
		return new ResponseEntity(hostelExpHandler.getErrorMessage(),hostelExpHandler.getHttpStatus());
	}
	
	
}
