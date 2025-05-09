package com.example.oilsalesystem.repository;

import com.example.oilsalesystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
