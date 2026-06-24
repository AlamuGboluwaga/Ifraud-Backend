package com.sotofit.Ifraud.repositories;

import com.sotofit.Ifraud.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
