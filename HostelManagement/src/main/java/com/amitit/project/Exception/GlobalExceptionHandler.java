package com.amitit.project.Exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CommonException.class)
	public ResponseEntity<ErrorDetails> handleCommonException(CommonException ex, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(
				LocalDateTime.now(), 
				ex.getMessage(), 
				request.getDescription(false));
		
		return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleGlobalException(Exception ex, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(
				LocalDateTime.now(), 
				ex.getMessage(), 
				request.getDescription(false));
		
		return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
