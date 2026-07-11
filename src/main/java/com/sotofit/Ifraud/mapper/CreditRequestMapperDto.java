package com.sotofit.Ifraud.mapper;

import com.sotofit.Ifraud.dtos.CreditRequestDto;
import com.sotofit.Ifraud.entities.CustomerOnboarding;

public class CreditRequestMapperDto {

	public CreditRequestDto toDto(CreditRequestDto request) {
		CreditRequestDto creditRequestDto = new CreditRequestDto();

		creditRequestDto.setAccountNumber(request.getAccountNumber());
		creditRequestDto.setAmount(request.getAmount());

		return creditRequestDto;
	}
}
