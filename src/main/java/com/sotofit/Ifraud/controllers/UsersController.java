package com.sotofit.Ifraud.controllers;

import com.sotofit.Ifraud.dtos.UserRequestById;
import com.sotofit.Ifraud.dtos.UsersRequest;
import com.sotofit.Ifraud.dtos.UsersResponse;
import com.sotofit.Ifraud.services.UsersService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {

	private final UsersService usersService;

	public UsersController(UsersService usersService) {
		this.usersService = usersService;
	}

	@PostMapping("/user")
	public ResponseEntity<UsersResponse> createUsers(@Valid @RequestBody UsersRequest usersRequest) {
		return ResponseEntity.status(201).body(usersService.createUser(usersRequest));
	}

	@GetMapping("/users")
	public ResponseEntity<List<UsersResponse>> getAllUsers() {
		return ResponseEntity.ok(usersService.getAllUsers());
	}

	@PostMapping("/user/id")
	public UsersResponse getUserById(@Valid @RequestBody UserRequestById requestById) {
		return usersService.getUserById(requestById);
	}
}
