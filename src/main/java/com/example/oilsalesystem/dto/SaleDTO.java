package com.example.oilsalesystem.dto;

import com.example.oilsalesystem.entity.Sale;

public class SaleDTO {
    private Long id;
    private Long productId;
    private Long customerId;
    private Double quantityInLitres;
    private Double totalPrice;

    public SaleDTO() {}

    // Constructor to map Sale entity to SaleDTO
    public SaleDTO(Sale sale) {
        this.id = sale.getId();
        this.productId = sale.getProduct().getId();
        this.customerId = sale.getCustomer().getId();
        this.quantityInLitres = sale.getQuantityInLitres();
        this.totalPrice = sale.getTotalPrice();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Double getQuantityInLitres() {
        return quantityInLitres;
    }

    public void setQuantityInLitres(Double quantityInLitres) {
        this.quantityInLitres = quantityInLitres;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
