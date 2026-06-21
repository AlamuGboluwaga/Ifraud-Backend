package com.sotofit.Ifraud.entities;

import jakarta.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Orders {

	private String id;
	private String CustomerName;
	private String Products;
	private String status;
	private BigDecimal totalAmount;
}
