package com.sotofit.Ifraud.mapper;

import com.sotofit.Ifraud.dtos.CustomerAccountNumberRequestDto;
import com.sotofit.Ifraud.entities.CustomerOnboarding;
import org.springframework.stereotype.Component;

@Component
public class CustomerAccountNumberRequestMapper {

	public CustomerOnboarding toAccountNumberEntity(CustomerAccountNumberRequestDto customerAccountNumberDto) {
		CustomerOnboarding entity = new CustomerOnboarding();

		entity.setAccountNumber(customerAccountNumberDto.getAccountNumber());
		return entity;
	}
}
