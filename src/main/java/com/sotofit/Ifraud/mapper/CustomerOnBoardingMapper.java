package com.sotofit.Ifraud.mapper;

import com.sotofit.Ifraud.dtos.CustomerOnBoardingDto;
import com.sotofit.Ifraud.entities.CustomerOnboarding;
import org.springframework.stereotype.Component;

@Component
public class CustomerOnBoardingMapper {

	public CustomerOnboarding toEntity(CustomerOnBoardingDto customerOnBoardingDto) {
		CustomerOnboarding entity = new CustomerOnboarding();

		entity.setFirstName(customerOnBoardingDto.getFirstName());
		entity.setSurName(customerOnBoardingDto.getSurName());
		entity.setEmail(customerOnBoardingDto.getEmail());
		entity.setAccountNumber(customerOnBoardingDto.getAccountNumber());
		entity.setBalance(customerOnBoardingDto.getBalance());

		return entity;
	}

	public CustomerOnBoardingDto toDto(CustomerOnboarding customerOnBoarding) {
		CustomerOnBoardingDto dto = new CustomerOnBoardingDto();
		dto.setId(customerOnBoarding.getId());
		dto.setFirstName(customerOnBoarding.getFirstName());
		dto.setSurName(customerOnBoarding.getSurName());
		dto.setEmail(customerOnBoarding.getEmail());
		dto.setAccountNumber(customerOnBoarding.getAccountNumber());
		dto.setBalance(customerOnBoarding.getBalance());

		return dto;
	}
}
