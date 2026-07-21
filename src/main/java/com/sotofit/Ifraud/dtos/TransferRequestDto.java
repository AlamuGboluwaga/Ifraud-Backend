package com.sotofit.Ifraud.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public class TransferRequestDto {

	@NotBlank(message = "Account number is required")
	@Size(max = 10, min = 10, message = "Account Number  must be 11 digits ")
	private String fromAccountNumber;

	@NotBlank(message = "Account number is required")
	@Size(max = 10, min = 10, message = "Account Number  must be 11 digits ")
	private String toAccountNumber;

	@NotNull(message = "Amount is required")
	@Positive(message = "Amount can not be negative ")
	private BigDecimal amount;

	public String getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	public String getToAccountNumber() {
		return toAccountNumber;
	}

	public void setToAccountNumber(String toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
