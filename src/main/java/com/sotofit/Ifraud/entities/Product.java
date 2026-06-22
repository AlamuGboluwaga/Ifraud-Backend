package com.sotofit.Ifraud.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Name is required")
    @Min(value = 3, message = "Name must be at least 3 characters long")
	@Column(name = "name", nullable = false)
	private String name;

	@NotBlank(message = "Description is required")
    @Min(value = 10, message = "Description must be at least 10 characters long")
	@Column(name = "description", nullable = false)
	private String description;

	@NotNull(message = "Price is required")
	@PositiveOrZero(message = "Price cannot be negative")
	@Column(name = "price", nullable = false)
	private BigDecimal price;

	@NotNull(message = "Stock is required")
	@Min(value = 0, message = "Stock cannot be negative")
	@Column(name = "stock", nullable = false)
	private Integer stock;

	@NotBlank(message = "Category is required")
	@Column(name = "category", nullable = false)
	private String category;

	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;
}
