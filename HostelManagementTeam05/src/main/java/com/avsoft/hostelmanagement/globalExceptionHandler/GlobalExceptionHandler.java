package com.avsoft.hostelmanagement.globalExceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.avsoft.hostelmanagement.exceptionHandler.BuildingException;
import com.avsoft.hostelmanagement.exceptionHandler.HostelServiceExceptionHandler;
import com.avsoft.hostelmanagement.exceptionHandler.OrganizationException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(com.avsoft.hostelmanagement.exceptionHandler.HostelServiceExceptionHandler.class)
	public ResponseEntity hostelException(HostelServiceExceptionHandler hostelExpHandler) {
		return new ResponseEntity(hostelExpHandler.getErrorMessage(),hostelExpHandler.getHttpStatus());
	}
	
	@ExceptionHandler(OrganizationException.class)
	public ResponseEntity<String> organizationException(OrganizationException orgExpHandler) {
		return new ResponseEntity<>(orgExpHandler.getErrorMessage(),orgExpHandler.getHttpStatus());
	}
	
	
	@ExceptionHandler(BuildingException.class)
	public ResponseEntity<String> buildingException(BuildingException buildingExp) {
	    return new ResponseEntity<>(buildingExp.getErrorMessage(), buildingExp.getHttpStatus());
	}

	
	
}
