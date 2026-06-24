package com.sotofit.Ifraud.repositories;

import com.sotofit.Ifraud.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface OrderItemRepository extends JpaRepository<OrderItem,Long> {}
