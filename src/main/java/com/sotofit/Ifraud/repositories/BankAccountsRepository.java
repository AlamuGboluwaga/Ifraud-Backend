package com.sotofit.Ifraud.repositories;

import com.sotofit.Ifraud.entities.BankAccounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody

public interface BankAccountsRepository extends JpaRepository<BankAccounts, Long> {}
