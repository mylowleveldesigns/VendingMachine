package com.example.groww.inventory;

import com.example.groww.model.Bill;
import com.example.groww.model.Product;

import java.util.Map;

public interface Inventory {
    Boolean addProduct(Product product, Integer quantity );
    Boolean addMoney(Bill bill, Integer quantity);
    Map<Product, Integer> getAvailableProducts();
    Integer getAvailalbeProductQuantity(Product product);
}
