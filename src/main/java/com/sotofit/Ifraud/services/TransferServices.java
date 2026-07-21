package com.sotofit.Ifraud.services;

import com.sotofit.Ifraud.ErrorHandler.AccountNotFoundException;
import com.sotofit.Ifraud.dtos.TransferRequestDto;
import com.sotofit.Ifraud.repositories.CustomerOnBoardingRepository;
import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class TransferServices {

	private static final Logger log = LoggerFactory.getLogger(TransferServices.class);
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
			.orElseThrow(() -> new AccountNotFoundException("Account number " + fromAccount + " was not found"));
		if (amount.compareTo(BigDecimal.ZERO) <= 0) {
			return ResponseEntity.badRequest().body("Amount must be greater than zero");
		}
		if (fromAccount.equals(toAccount)) {
			return ResponseEntity.badRequest().body("Cannot transfer to the same account");
		}
		if (customer.getBalance().compareTo(amount) < 0) {
			log.warn("Balance {}", customer.getBalance());

			return ResponseEntity.badRequest().body("Insufficient balance");
		}

		var newDebitBalance = customer.getBalance().subtract(amount);

		customer.setBalance(newDebitBalance);

		customerOnBoardingRepository.save(customer);

		// credit the other customer leg

		var customer2 = customerOnBoardingRepository
			.findByAccountNumber(toAccount)
			.orElseThrow(() -> new AccountNotFoundException("Account number " + toAccount + " was not found"));
		var newCreditBalance = customer2.getBalance().add(amount);
		customer2.setBalance(newCreditBalance);
		customerOnBoardingRepository.save(customer2);

		var totalBalance = customer.getBalance().add(customer2.getBalance());

		return ResponseEntity.ok("Transfer was Successful");
	}
}
