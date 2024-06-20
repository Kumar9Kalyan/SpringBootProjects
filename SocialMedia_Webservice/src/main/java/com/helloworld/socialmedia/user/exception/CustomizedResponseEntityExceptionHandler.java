package com.helloworld.socialmedia.user.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.helloworld.socialmedia.user.UserNotFoundException;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionDetails> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		
		ExceptionDetails exceptionDetails = new ExceptionDetails(LocalDateTime.now(),ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ExceptionDetails>(exceptionDetails,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ExceptionDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		
		ExceptionDetails exceptionDetails = new ExceptionDetails(LocalDateTime.now(),ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ExceptionDetails>(exceptionDetails,HttpStatus.NOT_FOUND);
		
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		String error="";
		for(FieldError a: ex.getFieldErrors()) {
			
			 error+=a.getDefaultMessage()+" ";
			 
		}
		

		ExceptionDetails exceptionDetails = new ExceptionDetails(LocalDateTime.now(),error/*"Total Errors:"+ex.getErrorCount()+" "+ex.getFieldError().getDefaultMessage()*/,request.getDescription(false));
		
		return new ResponseEntity(exceptionDetails,HttpStatus.BAD_REQUEST);
	}
}
