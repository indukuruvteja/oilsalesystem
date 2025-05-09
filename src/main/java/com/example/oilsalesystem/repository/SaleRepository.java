package com.example.oilsalesystem.repository;

import com.example.oilsalesystem.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
