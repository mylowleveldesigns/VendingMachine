package com.example.groww.service;

import com.example.groww.model.Bill;
import com.example.groww.model.Product;

import java.util.List;
import java.util.Map;

public interface VendingMachine {
    Boolean addMoneyToInventory(Map<Bill, Integer> monies);
    Boolean addProductsToInventory(Map<Product, Integer> products );
    Map<Product, Integer> getAvailableProducts();
    Integer getPriceAndSelectedProduct(Product product, Integer quantity) throws Exception;
    List<Bill> transactForProduct(Integer amount) throws Exception;
}
