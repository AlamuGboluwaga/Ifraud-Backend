package com.sotofit.Ifraud.services;

import com.sotofit.Ifraud.dtos.CreditRequestDto;
import com.sotofit.Ifraud.entities.CustomerOnboarding;
import com.sotofit.Ifraud.repositories.CustomerOnBoardingRepository;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class TransferServices {

	private CustomerOnBoardingRepository customerOnBoardingRepository;

	public TransferServices(CustomerOnBoardingRepository customerOnBoardingRepository) {
		this.customerOnBoardingRepository = customerOnBoardingRepository;
	}

	public CustomerOnboarding transfer(CreditRequestDto request) {
		var fromCustomerBalance = customerOnBoardingRepository
			.findByAccountNumber(request.getAccountNumber())
			.orElseThrow(() -> new RuntimeException("Customer not found "));
		var balance = fromCustomerBalance.getBalance();
		System.out.println("Balance: " + balance);

		//		if (fromCustomerBalance.getBalance() < amount) {
		//			return null;
		//		}

		//		var debitFromCustomer = fromCustomerBalance.getBalance().subtract(amount);
		//		fromCustomerBalance.setBalance(debitFromCustomer);
		//		var updateBalance1 = customerOnBoardingRepository.save(fromCustomerBalance);
		//
		//		var toCustomerAccountBalance = customerOnBoardingRepository
		//			.findByAccountNumber(toCustomerAccountNumber)
		//			.orElseThrow(() -> new RuntimeException("Customer not found "));
		//		var creditToCustomer = toCustomerAccountBalance.getBalance().add(amount);
		//        toCustomerAccountBalance.setBalance(creditToCustomer);
		//        var updateBalance2 = customerOnBoardingRepository.save(toCustomerAccountBalance);

		return null;
	}
}
