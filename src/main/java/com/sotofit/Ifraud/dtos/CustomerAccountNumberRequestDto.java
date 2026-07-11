package com.sotofit.Ifraud.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CustomerAccountNumberRequestDto {


	@NotBlank
	@Size(max = 11, min = 11, message = "Account Number  must be 11 digits ")
	private String accountNumber;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
