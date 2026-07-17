package com.sotofit.Ifraud.dtos;

import jakarta.validation.constraints.NotNull;

public class UserRequestByEmail {

	@NotNull(message = "User Id is required")
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
