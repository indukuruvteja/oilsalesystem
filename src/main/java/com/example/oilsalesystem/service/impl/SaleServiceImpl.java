package com.example.oilsalesystem.service.impl;

import com.example.oilsalesystem.dto.SaleDTO;
import com.example.oilsalesystem.entity.Sale;
import com.example.oilsalesystem.exception.ResourceNotFoundException;
import com.example.oilsalesystem.repository.SaleRepository;
import com.example.oilsalesystem.repository.ProductRepository;  // Assuming you have this to get the product
import com.example.oilsalesystem.entity.Product;  // Assuming you have a Product entity
import com.example.oilsalesystem.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProductRepository productRepository;  // Assuming you're using a Product repository

    // Get sale by ID
    @Override
    public SaleDTO getSaleById(Long id) {
        Sale sale = saleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sale not found with ID: " + id));
        return new SaleDTO(sale);  // Return SaleDTO
    }

    // Add a new sale
    @Override
    public SaleDTO addSale(SaleDTO saleDTO) {
        // Fetch Product by ID (assuming productId is provided in saleDTO)
        Product product = productRepository.findById(saleDTO.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + saleDTO.getProductId()));

        Sale sale = new Sale();
        sale.setProduct(product);  // Set the Product entity, not just the productId
        sale.setQuantityInLitres(saleDTO.getQuantityInLitres());
        sale.setTotalPrice(saleDTO.getTotalPrice());

        Sale savedSale = saleRepository.save(sale);
        return new SaleDTO(savedSale);  // Return SaleDTO
    }

    // Update an existing sale
    @Override
    public SaleDTO updateSale(Long id, SaleDTO saleDTO) {
        // Fetch existing Sale
        Sale sale = saleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sale not found with ID: " + id));

        // Fetch Product by ID
        Product product = productRepository.findById(saleDTO.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + saleDTO.getProductId()));

        sale.setProduct(product);  // Set the Product entity
        sale.setQuantityInLitres(saleDTO.getQuantityInLitres());
        sale.setTotalPrice(saleDTO.getTotalPrice());

        Sale updatedSale = saleRepository.save(sale);
        return new SaleDTO(updatedSale);  // Return updated SaleDTO
    }

    // Delete sale by ID
    @Override
    public void deleteSale(Long id) {
        Sale sale = saleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sale not found with ID: " + id));
        saleRepository.delete(sale);
    }
}
