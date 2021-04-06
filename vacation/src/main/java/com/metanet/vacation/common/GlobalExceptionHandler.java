package com.metanet.vacation.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.metanet.vacation.exception.BadRequestException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> error400(BadRequestException e) {
		
        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST) ;
    }
}
