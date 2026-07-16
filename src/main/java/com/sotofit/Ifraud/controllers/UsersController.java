package com.sotofit.Ifraud.controllers;

import com.sotofit.Ifraud.entities.Users;
import com.sotofit.Ifraud.services.UsersService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UsersController {

	private  UsersService usersService;

	public UsersController(UsersService usersService) {
		this.usersService = usersService;
	}

	@PostMapping("create/users")
	public ResponseEntity <Users> createUsers(@Valid @RequestBody Users users) {

        return ResponseEntity.ok(usersService.createUser(users));
	}

    @GetMapping("/users")
    public Iterable<Users> getAllUsers() {
        return usersService.getAllUsers();
    }
}
