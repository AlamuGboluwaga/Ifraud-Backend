package com.sotofit.Ifraud.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.*;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Customer name is required")
	@Column(name = "customer_name", nullable = false)
	private String customerName;

	@Email(message = "Invalid email format")
	@NotBlank(message = "Customer email is required")
	@Column(name = "customer_email", nullable = false)
	private String customerEmail;

	@NotBlank(message = "Product is required")
	@Column(name = "product", nullable = false)
	private String product;

	@NotBlank(message = "Status is required")
	@Column(name = "status", nullable = false)
	private String status;

	@NotNull(message = "Total price is required")
	@Column(name = "total_price", nullable = false)
	@PositiveOrZero(message = "Total price must be positive or zero")
	private BigDecimal totalPrice;

	@NotNull(message = "Created at is required")
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;
}
