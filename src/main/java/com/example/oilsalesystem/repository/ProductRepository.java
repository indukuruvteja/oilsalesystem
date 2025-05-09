package com.example.oilsalesystem.repository;

import com.example.oilsalesystem.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
