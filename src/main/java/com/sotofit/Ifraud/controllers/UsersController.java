package com.sotofit.Ifraud.controllers;

import com.sotofit.Ifraud.dtos.UserRequestByEmail;
import com.sotofit.Ifraud.dtos.UserUpdateRequest;
import com.sotofit.Ifraud.dtos.UsersRequest;
import com.sotofit.Ifraud.dtos.UsersResponse;
import com.sotofit.Ifraud.services.UsersService;
import jakarta.validation.Valid;
import java.util.List;
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

	@PostMapping("/users/email")
	public ResponseEntity<UsersResponse> getUserByEmail(@Valid @RequestBody UserRequestByEmail requestByEmail) {
		return ResponseEntity.ok(usersService.getUserByEmail(requestByEmail));
	}

	@PutMapping("user/{email}")
	public ResponseEntity<UsersResponse> updateUserByEmail(
		@Valid @RequestBody UserUpdateRequest userUpdateRequest,
		@Valid @PathVariable String email
	) {
		System.out.println("email " + email);

		return ResponseEntity.ok(usersService.updateByEmail(userUpdateRequest, email));
	}
}
