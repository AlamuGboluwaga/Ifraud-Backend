package com.sotofit.Ifraud.services;

import com.sotofit.Ifraud.dtos.TransferRequestDto;
import com.sotofit.Ifraud.repositories.CustomerOnBoardingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class TransferServices {

	private final CustomerOnBoardingRepository customerOnBoardingRepository;

	public TransferServices(CustomerOnBoardingRepository customerOnBoardingRepository) {
		this.customerOnBoardingRepository = customerOnBoardingRepository;
	}

	public ResponseEntity<?> transfer(TransferRequestDto request) {
		var fromAccount = request.getFromAccountNumber();
		var toAccount = request.getToAccountNumber();
		var amount = request.getAmount();

		var customer = customerOnBoardingRepository
			.findByAccountNumber(fromAccount)
			.orElseThrow(() -> new IllegalArgumentException("Account number not found"));

		if (customer.getBalance().compareTo(amount) < 0) {
			return ResponseEntity.badRequest().body("Insufficient balance");
		}

		var newDebitBalance = customer.getBalance().subtract(amount);

		customer.setBalance(newDebitBalance);
		customerOnBoardingRepository.save(customer);

		// credit the other customer leg

		var customer2 = customerOnBoardingRepository
			.findByAccountNumber(toAccount)
			.orElseThrow(() -> new IllegalArgumentException("Account number not found"));
		var newCreditBalance = customer2.getBalance().add(amount);
		customer2.setBalance(newCreditBalance);
		customerOnBoardingRepository.save(customer2);

        var totalBalance = customer.getBalance().add(customer2.getBalance());


		return ResponseEntity.ok(totalBalance);
	}
}
