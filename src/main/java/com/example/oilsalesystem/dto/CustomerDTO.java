package com.example.oilsalesystem.dto;

import com.example.oilsalesystem.entity.Customer;

public class CustomerDTO {

    private Long id;
    private String name;
    private String contact;

    // Constructor that maps entity to DTO
    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.contact = customer.getPhoneNumber(); // use correct getter
    }

    public CustomerDTO() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
