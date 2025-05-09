package com.example.oilsalesystem.service;

import com.example.oilsalesystem.dto.SaleDTO;
import java.util.List;

public interface SaleService {
    SaleDTO getSaleById(Long id);
    SaleDTO addSale(SaleDTO saleDTO);
    SaleDTO updateSale(Long id, SaleDTO saleDTO);
    void deleteSale(Long id);
}
