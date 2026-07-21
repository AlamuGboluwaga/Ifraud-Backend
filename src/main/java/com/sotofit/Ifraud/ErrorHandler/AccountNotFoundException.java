package com.sotofit.Ifraud.ErrorHandler;

public class AccountNotFoundException extends RuntimeException {

	public AccountNotFoundException(String message) {
		super(message);
	}
}
