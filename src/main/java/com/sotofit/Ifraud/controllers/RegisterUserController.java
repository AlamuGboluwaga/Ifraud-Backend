package com.sotofit.Ifraud.controllers;

import com.sotofit.Ifraud.entities.RegisterUser;
import com.sotofit.Ifraud.services.RegisterUserService;
import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterUserController {

	private final RegisterUserService registerUserService;

	public RegisterUserController(RegisterUserService registerUserService) {
		this.registerUserService = registerUserService;
	}

	@PostMapping("/register-user")
	public RegisterUser registerUser(@Valid @RequestBody RegisterUser registerUser) {
		return registerUserService.registerUser(registerUser);
	}

	@GetMapping("/registered-users")
	public List<RegisterUser> getAllRegisteredUser() {
		return registerUserService.getAllRegisteredUser();
	}

	@GetMapping("/registered-user/{id}")
	public RegisterUser getRegisteredUserById(@PathVariable("id") UUID id) {
		return registerUserService.getRegisteredUserById(id);
	}
}
