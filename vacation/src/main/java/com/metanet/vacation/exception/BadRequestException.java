package com.metanet.vacation.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BadRequestException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private HttpStatus status;
	private String message;
	
}
