package com.sotofit.Ifraud.services;

import com.sotofit.Ifraud.ErrorHandler.AccountAlreadyExistException;
import com.sotofit.Ifraud.ErrorHandler.EmailAllReadyExistException;
import com.sotofit.Ifraud.dtos.CreditRequestDto;
import com.sotofit.Ifraud.dtos.CustomerAccountNumberRequestDto;
import com.sotofit.Ifraud.dtos.CustomerAccountNumberResponseDto;
import com.sotofit.Ifraud.dtos.CustomerOnBoardingDto;
import com.sotofit.Ifraud.mapper.CustomerAccountNumberRequestMapper;
import com.sotofit.Ifraud.mapper.CustomerAccountNumberResponseMapper;
import com.sotofit.Ifraud.mapper.CustomerOnBoardingMapper;
import com.sotofit.Ifraud.repositories.CustomerOnBoardingRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerOnboardingServices {

	private final CustomerOnBoardingRepository repository;
	private final CustomerOnBoardingMapper customerOnBoardingMapper;
	private final CustomerAccountNumberRequestMapper customerAccountNumberRequestMapper;
	private final CustomerAccountNumberResponseMapper customerAccountNumberResponseMapper;

	public CustomerOnboardingServices(
		CustomerOnBoardingRepository customerOnBoardingRepository,
		CustomerOnBoardingMapper customerOnBoardingMapper,
		CustomerAccountNumberRequestMapper customerAccountNumberRequestMapper,
		CustomerAccountNumberResponseMapper customerAccountNumberResponseMapper
	) {
		this.repository = customerOnBoardingRepository;
		this.customerOnBoardingMapper = customerOnBoardingMapper;
		this.customerAccountNumberRequestMapper = customerAccountNumberRequestMapper;
		this.customerAccountNumberResponseMapper = customerAccountNumberResponseMapper;
	}

	public CustomerOnBoardingDto onBoardCustomer(CustomerOnBoardingDto requestDto) {
		var accountNumber = requestDto.getAccountNumber();
		var email = requestDto.getEmail();
		if (repository.existsByEmail(email)) {
			throw new EmailAllReadyExistException("Email " + email + " already exist");
		}
		if (repository.existsByAccountNumber(accountNumber)) {
			throw new AccountAlreadyExistException("Account number " + accountNumber + " already exist");
		}

		var toBeSaved = customerOnBoardingMapper.toEntity(requestDto);

		var customers = repository.save(toBeSaved);

		return customerOnBoardingMapper.toDto(customers);
	}

	public List<CustomerOnBoardingDto> getAllAccounts() {
		var customer = repository.findAll();
		List<CustomerOnBoardingDto> accounts = customer.stream().map(customerOnBoardingMapper::toDto).toList();

		return accounts;
	}

	public CustomerOnBoardingDto getCustomerById(UUID id) {
		if (id == null) {
			throw new IllegalArgumentException("Customer id is required");
		}
		var customer = repository
			.findById(id)
			.orElseThrow(() -> new RuntimeException("Customer with id " + id + " was not found"));
		return customerOnBoardingMapper.toDto(customer);
	}

	public CustomerAccountNumberResponseDto getCustomerAccountNumber(CustomerAccountNumberRequestDto request) {
		if (request == null) {
			throw new IllegalArgumentException("Account number is required");
		}

		var customerAccountNumber = repository
			.findByAccountNumber(request.getAccountNumber())
			.orElseThrow(() -> new RuntimeException("Account number  not found"));

		return customerAccountNumberResponseMapper.toDto(customerAccountNumber);
	}

	public ResponseEntity<?> creditCustomerAccount(CreditRequestDto requestDto) {
		var accountNumber = requestDto.getAccountNumber();
		var amount = requestDto.getAmount();
		var customer = repository
			.findByAccountNumber(accountNumber)
			.orElseThrow(() -> new RuntimeException("Customer with account number " + accountNumber + " was not found")
			);

		var newBalance = customer.getBalance().add(amount);
		customer.setBalance(newBalance);

		repository.save(customer);

		return ResponseEntity.ok(customer);
	}
}
