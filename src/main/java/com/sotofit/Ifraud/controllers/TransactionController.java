package com.sotofit.Ifraud.controllers;

import com.sotofit.Ifraud.dtos.CreditRequestDto;
import com.sotofit.Ifraud.entities.CustomerOnboarding;
import com.sotofit.Ifraud.services.CustomerOnboardingServices;
import com.sotofit.Ifraud.services.TransferServices;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    private TransferServices transferServices;

    public TransactionController(TransferServices transferServices) {
        this.transferServices = transferServices;
    }

    @PostMapping("/transfer")
    public ResponseEntity<?> transfer(@Valid @RequestBody CreditRequestDto request) {
        transferServices.transfer(request);
        return null;
    }
}