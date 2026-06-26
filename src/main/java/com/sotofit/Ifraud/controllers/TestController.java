package com.sotofit.Ifraud.controllers;

import com.sotofit.Ifraud.test.Coatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	// Empty varaible decearation
	private Coatch coatch;

	@Autowired
	public TestController(Coatch coatch) {
		this.coatch = coatch;
	}

	//This is just for tes
	@GetMapping("/test")
	public String getTEst() {
		return coatch.learnBoxing();
	}

	@GetMapping
	public String getUserById() {
		return coatch.learnBoxing();
	}
    @GetMapping
    public String getUserAll() {
        return coatch.learnBoxing();
    }
    @GetMapping
    public String deletebyId() {
        return coatch.learnBoxing();
    }
    @GetMapping
    public String updateUserBId() {
        return coatch.learnBoxing();
    }
}
