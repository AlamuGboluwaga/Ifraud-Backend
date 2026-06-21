package com.sotofit.Ifraud.entities;

import jakarta.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Product {

	private String name;
	private String Description;
	private BigDecimal price;
	private String stock;
	private String category;
	private String createdAt;
	private String UpdatedAt;
}
