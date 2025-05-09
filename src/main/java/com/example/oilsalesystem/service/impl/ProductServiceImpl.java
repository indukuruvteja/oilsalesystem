package com.example.oilsalesystem.service.impl;

import com.example.oilsalesystem.dto.ProductDTO;
import com.example.oilsalesystem.entity.Product;
import com.example.oilsalesystem.exception.ResourceNotFoundException;
import com.example.oilsalesystem.repository.ProductRepository;
import com.example.oilsalesystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Method to get product by ID
    @Override
    public ProductDTO getProductById(Long id) {
        // Fetch the product by ID from the repository
        return productRepository.findById(id)
                .map(product -> new ProductDTO(product))  // Map entity to DTO
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + id));
    }

    // Method to add a new product
    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        // Convert DTO to Entity
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPricePerLitre(productDTO.getPricePerLitre());

        // Save the product to the repository
        Product savedProduct = productRepository.save(product);

        // Return saved product as DTO
        return new ProductDTO(savedProduct);
    }

    // Method to update an existing product
    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        // Fetch the existing product to update
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + id));

        // Update product fields
        product.setName(productDTO.getName());
        product.setPricePerLitre(productDTO.getPricePerLitre());

        // Save the updated product
        Product updatedProduct = productRepository.save(product);

        // Return updated product as DTO
        return new ProductDTO(updatedProduct);
    }

    // Method to delete a product by its ID
    @Override
    public void deleteProduct(Long id) {
        // Check if product exists
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + id));

        // Delete the product
        productRepository.delete(product);
    }
}
