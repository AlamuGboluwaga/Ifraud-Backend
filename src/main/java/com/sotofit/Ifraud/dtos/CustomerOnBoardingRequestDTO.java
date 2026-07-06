package com.sotofit.Ifraud.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CustomerOnBoardingRequestDTO {

	@NotBlank
	private String firstName;

	@NotBlank
	private String surName;

	@NotBlank
	@Email(message = "Invalid email format")
	private String email;

	@NotBlank
	private String accountNumber;

	@NotNull
	private BigDecimal balance;

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
	//
	//	private LocalDateTime createdAt;
	//
	//	private LocalDateTime updatedAt;
}
