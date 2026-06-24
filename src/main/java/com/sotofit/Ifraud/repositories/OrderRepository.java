package com.sotofit.Ifraud.repositories;

import com.sotofit.Ifraud.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
