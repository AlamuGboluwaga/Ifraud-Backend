package com.sotofit.Ifraud.repositories;

import com.sotofit.Ifraud.entities.CustomerOnboarding;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOnBoardingRepository extends JpaRepository<CustomerOnboarding, UUID> {

    Optional<CustomerOnboarding> findByAccountNumber(String accountNumber);
}
