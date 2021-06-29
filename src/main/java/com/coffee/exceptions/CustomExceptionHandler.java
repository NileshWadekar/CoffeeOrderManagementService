package com.coffee.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {


	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> parentException(Exception ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("SERVER_ERROR");
		response.setErrorMessage("SERVER ERROR : PLEASE CONTACT ADMISTRATOR!");
		response.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<ExceptionResponse> noDataFoundException(NoDataFoundException ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("NOT_FOUND");
		response.setErrorMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
	

}