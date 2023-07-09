package com.app.custom_exception;

@SuppressWarnings("serial")
public class CustomException extends RuntimeException {

	public CustomException(String message) {
		super(message);
	}

}
