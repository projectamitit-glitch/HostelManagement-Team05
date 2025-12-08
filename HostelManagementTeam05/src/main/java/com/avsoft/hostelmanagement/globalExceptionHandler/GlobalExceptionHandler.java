package com.avsoft.hostelmanagement.globalExceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.avsoft.hostelmanagement.exceptionHandler.BedException;
import com.avsoft.hostelmanagement.exceptionHandler.BuildingException;
import com.avsoft.hostelmanagement.exceptionHandler.FloorServiceException;
import com.avsoft.hostelmanagement.exceptionHandler.HostelServiceExceptionHandler;
import com.avsoft.hostelmanagement.exceptionHandler.ImageServiceException;
import com.avsoft.hostelmanagement.exceptionHandler.OrganizationException;
import com.avsoft.hostelmanagement.service.ImageService;

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

	@ExceptionHandler(FloorServiceException.class)
	public ResponseEntity<String> flooServiceException(BuildingException buildingExp) {
	    return new ResponseEntity<>(buildingExp.getErrorMessage(), buildingExp.getHttpStatus());
	}
	
	@ExceptionHandler(BedException.class)
	public ResponseEntity<String> bedException(BedException ex) {
	    return new ResponseEntity<>(ex.getErrorMessage(), ex.getHttpStatus());
	}
	
	@ExceptionHandler(ImageServiceException.class)
	public ResponseEntity<String> ImageServiceException(ImageServiceException imgExp) {
	    return new ResponseEntity<>(imgExp.getErrorMessage(), imgExp.getStatus());
	}
	

	
}
