package com.example.oilsalesystem.service.impl;

import com.example.oilsalesystem.dto.CustomerDTO;
import com.example.oilsalesystem.entity.Customer;
import com.example.oilsalesystem.exception.ResourceNotFoundException;
import com.example.oilsalesystem.repository.CustomerRepository;
import com.example.oilsalesystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Get a customer by ID
    @Override
    public CustomerDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with ID: " + id));
        return new CustomerDTO(customer);  // ✅ Fix: use object 'customer', not 'Customer'
    }

    // Add a new customer
    @Override
    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setPhoneNumber(customerDTO.getContact());  // ✅ Fix: method name was wrong
        Customer savedCustomer = customerRepository.save(customer);
        return new CustomerDTO(savedCustomer);
    }

    // Update existing customer
    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with ID: " + id));
        customer.setName(customerDTO.getName());
        customer.setPhoneNumber(customerDTO.getContact());  // ✅ Fix: method name
        Customer updatedCustomer = customerRepository.save(customer);
        return new CustomerDTO(updatedCustomer);
    }

    // Delete customer by ID
    @Override
    public void deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with ID: " + id));
        customerRepository.delete(customer);
    }
}
