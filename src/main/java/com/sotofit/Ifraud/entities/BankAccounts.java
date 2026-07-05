package com.sotofit.Ifraud.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "bank_accounts")
public class BankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private UUID Id;

	@NotNull
	@Column(name = "amount", nullable = false)
	private BigDecimal amount;
@NotNull
@Column(name = "balance", nullable = false)
	private BigDecimal balance;
	private String accountHolder;
	private Long version;
}
