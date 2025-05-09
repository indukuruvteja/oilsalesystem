package com.example.oilsalesystem.service;

import com.example.oilsalesystem.dto.ProductDTO;

public interface ProductService {

    // Method to get a product by its ID
    ProductDTO getProductById(Long id);

    // Method to add a new product
    ProductDTO addProduct(ProductDTO productDTO);

    // Method to update an existing product
    ProductDTO updateProduct(Long id, ProductDTO productDTO);

    // Method to delete a product by its ID
    void deleteProduct(Long id);
}
