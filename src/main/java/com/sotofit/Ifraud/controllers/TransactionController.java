package com.sotofit.Ifraud.controllers;

import com.sotofit.Ifraud.dtos.TransferRequestDto;
import com.sotofit.Ifraud.services.TransferServices;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TransactionController {

	private TransferServices transferServices;

	public TransactionController(TransferServices transferServices) {
		this.transferServices = transferServices;
	}

	@PostMapping("/transfer")
	public ResponseEntity<?> transfer(@Valid @RequestBody TransferRequestDto request) {

        log.warn("Request {} ",request.getFromAccountNumber(),request.getToAccountNumber(),request.getAmount());
		return transferServices.transfer(request);
	}
}
