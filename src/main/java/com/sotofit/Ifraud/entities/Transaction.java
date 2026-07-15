package com.sotofit.Ifraud.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {

	@Id
	@Column(name = "id")
	private UUID Id;

	private String reference;
	private String fromAccount;
	private String toAccount;
	private BigDecimal amount;
	private LocalDateTime transactionDate;

    @Enumerated(EnumType.STRING)
    private TransactionStatus staus;
}

