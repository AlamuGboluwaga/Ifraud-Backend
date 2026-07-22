package com.sotofit.Ifraud.controllers;


import com.sotofit.Ifraud.dtos.RegisteredUserResponseDto;
import com.sotofit.Ifraud.entities.RegisterUser;
import com.sotofit.Ifraud.services.RegisterUserService;
import java.util.List;
import java.util.UUID;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Registered Users", description = "API for managing registered users")
public class RegisterUserController {

	private final RegisterUserService registerUserService;

	public RegisterUserController(RegisterUserService registerUserService) {
		this.registerUserService = registerUserService;
	}

	@PostMapping("/register-user")
    @Operation(summary = "Register users")
	public RegisterUser registerUser(@Valid @RequestBody RegisterUser registerUser) {
		return registerUserService.registerUser(registerUser);
	}

	@GetMapping("/registered-users")
    @Operation(summary = "Get all users")
	public List<RegisteredUserResponseDto> getAllRegisteredUser() {
		return registerUserService.getAllRegisteredUser();
	}

	@GetMapping("/registered-user/{id}")
    @Operation(summary = "Get registered user by id")
	public ResponseEntity<RegisterUser> getRegisteredUserById(@PathVariable("id") UUID id) {
		return ResponseEntity.status(201).body(registerUserService.getRegisteredUserById(id));
	}

    @PutMapping("update-registered-user/{id}")
    @Operation(summary = "Update registered user by id")
    public ResponseEntity<String> updateRegisteredUserById(@Valid @RequestBody RegisterUser registerUser , @PathVariable UUID id){
        System.out.println("REGg" + registerUser.getClass());
        var user =registerUserService.updateRegisteredUserBtId(registerUser,id);
        return ResponseEntity.ok("Successfully updated");
    }
    @DeleteMapping("/delete-registered-user/{id}")
    @Operation(summary = "Delete registered user by id")
    public String deleteRegisteredUserById(@PathVariable UUID id) {
        registerUserService.deleteRegisteredUserById(id);
        return "User was successfully deleted";
    }
}
