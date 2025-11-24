package com.avsoft.hostelmanagement.exceptionHandler;



import org.springframework.http.HttpStatus;

public class HostelServiceExceptionHandler  extends RuntimeException{
	
	private String errorMessage;
	private HttpStatus httpStatus;
	
		public HostelServiceExceptionHandler(String errorMessage, HttpStatus httpStatus) {
			this.errorMessage = errorMessage;
			this.httpStatus=httpStatus;
		}
		
		public String getHostelServiceExceptionMessage() {
			return errorMessage;
		}
		
		public HttpStatus getStatus() {
			return httpStatus;
		}

		public String getErrorMessage() {
			return errorMessage;
		}

		public HttpStatus getHttpStatus() {
			return httpStatus;
		}		
}
