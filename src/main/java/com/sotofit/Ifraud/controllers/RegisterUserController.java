package com.sotofit.Ifraud.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterUserController {

	@PostMapping
	public String RegisterUser() {
		return "Registered";
	}

	@GetMapping("/registered-user")
	public String getAllRegisteredUser() {
		return null;
	}
}
