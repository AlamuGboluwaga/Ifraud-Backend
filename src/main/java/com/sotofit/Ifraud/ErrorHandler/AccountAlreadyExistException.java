package com.sotofit.Ifraud.ErrorHandler;

public class AccountAlreadyExistException extends RuntimeException {

	public AccountAlreadyExistException(String message) {
		super(message);
	}
}
