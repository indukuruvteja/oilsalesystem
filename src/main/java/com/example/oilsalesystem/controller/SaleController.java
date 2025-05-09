package com.example.oilsalesystem.controller;

import com.example.oilsalesystem.dto.SaleDTO;
import com.example.oilsalesystem.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping("/{id}")
    public SaleDTO getSale(@PathVariable Long id) {
        return saleService.getSaleById(id);
    }

    @PostMapping
    public SaleDTO createSale(@RequestBody SaleDTO saleDTO) {
        return saleService.addSale(saleDTO);
    }

    @PutMapping("/{id}")
    public SaleDTO updateSale(@PathVariable Long id, @RequestBody SaleDTO saleDTO) {
        return saleService.updateSale(id, saleDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteSale(@PathVariable Long id) {
        saleService.deleteSale(id);
    }
}
