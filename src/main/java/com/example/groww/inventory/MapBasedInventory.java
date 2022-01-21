package com.example.groww.inventory;

import com.example.groww.model.Bill;
import com.example.groww.model.Product;

import java.util.HashMap;
import java.util.Map;

public class MapBasedInventory implements Inventory {
    private Map<Product, Integer> productQuantityMap;
    private Map<Bill, Integer> billQuantityMap;

    public MapBasedInventory() {
        this.productQuantityMap = new HashMap<>();
        this.billQuantityMap = new HashMap<>();
    }


    @Override
    public Boolean addProduct(Product product, Integer quantity) {
        if(productQuantityMap.containsKey(product)){
            Integer currentQuantity = productQuantityMap.get(product);
            Integer newQuantity = currentQuantity + quantity;
            productQuantityMap.put(product, newQuantity);
        } else {
            productQuantityMap.put(product, quantity);
        }
        return true;
    }

    @Override
    public Boolean addMoney(Bill bill, Integer quantity) {
        if(billQuantityMap.containsKey(bill)){
            Integer currentQuantity = billQuantityMap.get(bill);
            billQuantityMap.put(bill, currentQuantity+quantity);
        } else billQuantityMap.put(bill, quantity);
        return true;
    }

    @Override
    public Map<Product, Integer> getAvailableProducts() {
        return this.productQuantityMap;
    }

    @Override
    public Integer getAvailalbeProductQuantity(Product product) {
        return this.productQuantityMap.get(product);
    }
}
