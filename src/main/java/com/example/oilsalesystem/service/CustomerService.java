package com.example.oilsalesystem.service;

import com.example.oilsalesystem.dto.CustomerDTO;
import com.example.oilsalesystem.entity.Customer;
import java.util.List;

public interface CustomerService {
    CustomerDTO getCustomerById(Long id);
    CustomerDTO addCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);
    void deleteCustomer(Long id);
}
