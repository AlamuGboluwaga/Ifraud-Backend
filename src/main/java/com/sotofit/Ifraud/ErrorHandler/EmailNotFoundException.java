package com.sotofit.Ifraud.ErrorHandler;

public class EmailNotFoundException extends RuntimeException {

	public EmailNotFoundException(String message) {
		super(message);
	}
}
