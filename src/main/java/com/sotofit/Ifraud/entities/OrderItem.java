package com.sotofit.Ifraud.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.math.BigDecimal;

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

	@NotNull(message = "Quantity is required")
	@Column(name = "quantity", nullable = false)
	private Integer quantity;

	@NotNull(message = "Product id is required")
	@Column(name = "price_at_purchase", nullable = false)
	private BigDecimal priceAtPurchase;

    //TODO ERELATIOMS

    @ManyToOne()
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;


    @ManyToOne()
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
