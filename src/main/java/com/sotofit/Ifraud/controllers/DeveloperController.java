package com.sotofit.Ifraud.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeveloperController {

	@Value("${developer.name}")
	String developerName;

	@Value("${developer.stack}")
	String developerStack;

	@Value("${age}")
	int age;

	@Value("${spring.application.name}")
	String project;

	@GetMapping("/developers")
	public String developerDetails() {
		return (
			"Developer's name  = " +
			developerName +
			" and the stack = " +
			" age = " +
			age +
			" project name = " +
			project
		);
	}
}
