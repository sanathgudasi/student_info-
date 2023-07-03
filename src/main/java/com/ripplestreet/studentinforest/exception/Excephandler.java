package com.ripplestreet.studentinforest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Excephandler {
	
	@ExceptionHandler(StudentInfoException.class)
	public ResponseEntity<String> handler(StudentInfoException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getHttpStatus()+" "+e.getMessage());
	
		
	}

}
