package com.sotofit.Ifraud.controllers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@PostMapping
	public ResponseEntity<String> CreateOrder() {
		return ResponseEntity.ok("ok");
	}

	@GetMapping
	public ResponseEntity<String> GetAllOrders() {
		return ResponseEntity.ok("Good");
	}

	@GetMapping("/{id}")
	public Object GetOrderById() {
		return "Order by id";
	}
}
