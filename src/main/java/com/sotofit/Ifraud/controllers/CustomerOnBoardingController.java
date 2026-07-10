package com.sotofit.Ifraud.controllers;

import com.sotofit.Ifraud.dtos.CustomerOnBoardingDto;
import com.sotofit.Ifraud.services.CustomerOnboardingServices;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerOnBoardingController {

	private CustomerOnboardingServices services;

	public CustomerOnBoardingController(CustomerOnboardingServices services) {
		this.services = services;
	}

	@PostMapping("/onboard-customer")
	public ResponseEntity<CustomerOnBoardingDto> OnBoard(@Valid @RequestBody CustomerOnBoardingDto requestDto) {
		var createdCustomer = services.onBoard(requestDto);

		return ResponseEntity.status(201).body(createdCustomer);
	}

	@GetMapping("/onboarded-customers")
	public ResponseEntity<List<CustomerOnBoardingDto>> getAllCustomers() {
		var customers = services.getAllAccounts();
		if (customers == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(customers);
	}

	@GetMapping("/onboarded-customers/{id}")
	public ResponseEntity<CustomerOnBoardingDto> getCustomerById(@PathVariable UUID id) {
		return ResponseEntity.ok(services.getCustomerById(id));
	}

	@PutMapping
	public ResponseEntity<CustomerOnBoardingDto> updateAccount() {
		return null;
	}
}
