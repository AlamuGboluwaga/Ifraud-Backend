package com.sotofit.Ifraud.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "order_items")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Order id is required")
	@Column(name = "order_id", nullable = false)
	private Long orderId;

	@NotNull(message = "Quantity is required")
	@Column(name = "quantity", nullable = false)
	private Integer quantity;

	@NotNull(message = "Product id is required")
	@Column(name = "product_id", nullable = false)
	private Long ProductId;
}
