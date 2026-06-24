package com.sotofit.Ifraud.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {

	@PostMapping
	public Object CreateOrderItems() {
		return "Created";
	}

	@GetMapping
	public Object GetAllOrderItem() {
		return "Get OrderedItems";
	}
}
