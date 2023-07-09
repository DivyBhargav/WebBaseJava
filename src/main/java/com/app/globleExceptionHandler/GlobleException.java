package com.app.globleExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.custom_exception.CustomException;
import com.app.dto.ResponceApi;

@RestControllerAdvice
public class GlobleException {
@ExceptionHandler(CustomException.class)
public ResponseEntity<?> HandleCustomExceptionHandle(CustomException e){
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponceApi(e.getMessage()));
}

@ExceptionHandler(Exception.class)
public ResponseEntity<?> handleException(Exception e){
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponceApi(e.getMessage()));
}
}
