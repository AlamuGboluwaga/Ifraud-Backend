package com.sotofit.Ifraud.controllers;

import com.sotofit.Ifraud.entities.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

	@GetMapping("/products")
	public ResponseEntity<String> GellAllProducts() {
		return null;
	}

	@PostMapping
	public ResponseEntity<Product> CreateProduct() {
		return ResponseEntity.ok(new Product());
	}
}
