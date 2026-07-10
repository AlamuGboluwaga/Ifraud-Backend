package com.sotofit.Ifraud.controllers;


import com.sotofit.Ifraud.dtos.RegisteredUserResponseDto;
import com.sotofit.Ifraud.entities.RegisterUser;
import com.sotofit.Ifraud.services.RegisterUserService;
import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
	public List<RegisteredUserResponseDto> getAllRegisteredUser() {
		return registerUserService.getAllRegisteredUser();
	}

	@GetMapping("/registered-user/{id}")
	public RegisterUser getRegisteredUserById(@PathVariable("id") UUID id) {
		return registerUserService.getRegisteredUserById(id);
	}

    @PutMapping("update-registered-user/{id}")
    public ResponseEntity<String> updateRegisteredUserById(@Valid @RequestBody RegisterUser registerUser , @PathVariable UUID id){
        System.out.println("REGg" + registerUser.getClass());
        var user =registerUserService.updateRegisteredUserBtId(registerUser,id);
        return ResponseEntity.ok("Successfully updated");
    }
    @DeleteMapping("/delete-registered-user/{id}")
    public String deleteRegisteredUserById(@PathVariable UUID id) {
        registerUserService.deleteRegisteredUserById(id);
        return "User was successfully deleted";
    }
}
