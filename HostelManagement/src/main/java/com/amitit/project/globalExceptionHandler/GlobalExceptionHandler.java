package com.amitit.project.globalExceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.amitit.project.customExceptionHandler.HostelServiceExceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.amitit.project.customExceptionHandler.HostelServiceExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(HostelServiceExceptionHandler.class)
	public ResponseEntity hostelException(HostelServiceExceptionHandler hosteExpHandler) {
		return new ResponseEntity(hosteExpHandler.getErrorMessage(), hosteExpHandler.getHttpStatus());
	}

	@ExceptionHandler(exception =  HostelServiceExceptionHandler.class)
	public ResponseEntity floorException(HostelServiceExceptionHandler floorExpHandler) {
		return new ResponseEntity(floorExpHandler.getMessage(),floorExpHandler.getStatus());
	}
}