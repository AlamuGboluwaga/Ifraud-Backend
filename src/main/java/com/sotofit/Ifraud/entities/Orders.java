package com.sotofit.Ifraud.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.*;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Orders {

	private String id;
	private String CustomerName;
	private String Products;
	private String status;
	private BigDecimal totalAmount;
}
