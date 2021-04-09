package com.metanet.vacation.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.metanet.vacation.dto.ResponseDto;
import com.metanet.vacation.exception.BadRequestException;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> error400(BadRequestException e) {
		Map<String, Object> resBody = new HashMap<>();
		resBody.put("result", e.getMessage());
        return new ResponseEntity<>(resBody, e.getStatus());
    }
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> processValidationError(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();

        StringBuilder builder = new StringBuilder();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
//            builder.append(fieldError.getField());
            builder.append("패스워드");
            builder.append("는 ");
            builder.append(fieldError.getDefaultMessage());
//            builder.append(" 입력된 값: [");
//            builder.append(fieldError.getRejectedValue());
//            builder.append("]");
        }

        return ResponseEntity.badRequest()
        		.body(new ResponseDto<>(HttpStatus.BAD_REQUEST.value(), builder.toString()));
    }
	
	@ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> processCredentialsError(BadCredentialsException e) {
		
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
        		.body(new ResponseDto<>(HttpStatus.UNAUTHORIZED.value(), "로그인 정보가 일치하지 않습니다!"));
    }
}
