package com.sotofit.Ifraud.services;

import com.sotofit.Ifraud.dtos.CustomerOnBoardingDto;
import com.sotofit.Ifraud.mapper.CustomerOnBoardingMapper;
import com.sotofit.Ifraud.repositories.CustomerOnBoardingRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerOnboardingServices {

	private final CustomerOnBoardingRepository repository;
	private final CustomerOnBoardingMapper mapper;

	public CustomerOnboardingServices(
		CustomerOnBoardingRepository customerOnBoardingRepository,
		CustomerOnBoardingMapper mapper
	) {
		this.repository = customerOnBoardingRepository;
		this.mapper = mapper;
	}

	public CustomerOnBoardingDto onBoard(CustomerOnBoardingDto requestDto) {
		if (requestDto == null) {
			return null;
		}

		var toBeSaved = mapper.toEntity(requestDto);

		var customers = repository.save(toBeSaved);

		return mapper.toDto(customers);
	}

	public List<CustomerOnBoardingDto> getAllAccounts() {
		var customer = repository.findAll();
		List<CustomerOnBoardingDto> accounts = customer.stream().map(mapper::toDto).toList();

		return accounts;
	}

	public CustomerOnBoardingDto getCustomerById(UUID id) {
		if (id == null) {
			return null;
		}
		var customer = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));

		return mapper.toDto(customer);
	}
}
