package com.sotofit.Ifraud.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

	private String name;
	private String Description;
	private BigDecimal price;
	private String stock;
	private String category;
	private String createdAt;
	private String UpdatedAt;
}
