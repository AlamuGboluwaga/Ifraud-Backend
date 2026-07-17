package com.sotofit.Ifraud.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UsersRequest {

	@NotNull(message = "First name is required")
	private String firstname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @NotNull(message = "Email is required")
	private String email;

	@NotNull(message = "Phone is required")
	@Size(min = 11, max = 11, message = "Phone number must be 11 digits")
	private String phone;

	@NotNull(message = "Password is required")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
