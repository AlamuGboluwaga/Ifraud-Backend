package com.sotofit.Ifraud.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.UUID;

public class CustomerOnBoardingDto {

	private UUID id;

	@NotBlank
	private String firstName;

	@NotBlank(message = "Surname is required")
	private String surName;

	@Email(message = "Invalid email format")
	@NotBlank(message = "email is required")
	private String email;

	@NotBlank(message = "Account number is required")
	@Size(max = 10, min = 10, message = "Account Number  must be 10 digits ")
	private String accountNumber;

	@NotNull(message = "Balance is required")
	private BigDecimal balance;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}
