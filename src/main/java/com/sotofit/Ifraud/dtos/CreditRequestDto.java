package com.sotofit.Ifraud.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class CreditRequestDto {

	@NotNull(message = "Account number is required")
    @Positive(message = "Account number can not be negative")
    @Size(max = 10, min = 10, message = "Account Number must be 11 digits ")
	private String accountNumber;

	@NotNull
    @Positive(message = "Amount can not be negative ")
	private BigDecimal amount;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
