package com.sotofit.Ifraud.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
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
	@Size(min = 3, message = "Name must be at least 3 characters long")
	@Column(name = "name", nullable = false)
	private String name;

	@NotBlank(message = "Description is required")
	@Size(min = 3, message = "Description must be at least 3 characters long")
	@Column(name = "description", nullable = false)
	private String description;

	@NotNull(message = "Price is required")
	@PositiveOrZero(message = "Price cannot be negative")
	@Column(name = "price", nullable = false)
	private BigDecimal price;

	@NotNull(message = "Stock is required")
	@Size(min = 3, message = "Description must be at least 3 characters long")
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

	@JsonIgnore
	@OneToMany(mappedBy = "product")
	private List<OrderItem> orderItems;
}
