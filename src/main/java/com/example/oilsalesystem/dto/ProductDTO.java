package com.example.oilsalesystem.dto;

import com.example.oilsalesystem.entity.Product;

public class ProductDTO {
    private Long id;
    private String name;
    private Double pricePerLitre;

    // Default constructor
    public ProductDTO() {
    }

    // Constructor to convert Product entity to ProductDTO
    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.pricePerLitre = product.getPricePerLitre();
    }

    // Getters and setters
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

    public Double getPricePerLitre() {
        return pricePerLitre;
    }

    public void setPricePerLitre(Double pricePerLitre) {
        this.pricePerLitre = pricePerLitre;
    }
}
