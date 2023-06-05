package com.example.productservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.productservice.model.ErrorResponse;

@ControllerAdvice
public class Restresponseentityexceptionhandler extends ResponseEntityExceptionHandler{
    
	@ExceptionHandler(ProductServiceCustomException.class)
	public ResponseEntity<ErrorResponse> handledProductServiceException(ProductServiceCustomException exception){
		
		return new ResponseEntity<>(new ErrorResponse().builder()
				.errormessage(exception.getMessage())
				.errorcode(exception.getErrorcode()).build(),HttpStatus.NOT_FOUND);
		
	}
}
