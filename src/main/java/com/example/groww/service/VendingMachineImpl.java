package com.example.groww.service;

import com.example.groww.inventory.Inventory;
import com.example.groww.inventory.MapBasedInventory;
import com.example.groww.model.Bill;
import com.example.groww.model.Product;
import com.example.groww.model.State;
import com.example.groww.util.InventoryUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachineImpl implements VendingMachine {
    private InventoryUtil inventoryUtil;
    Inventory inventory;
    State state;

    public VendingMachineImpl() {
        this.inventory = new MapBasedInventory();
        this.state = new State();
        this.inventory.addProduct(new Product("Dairy Milk", 10), 5);
        this.inventory.addProduct(new Product("Lays", 20), 5);
        this.inventory.addProduct(new Product("Pepsi", 50), 5);
        this.inventory.addMoney(Bill.FIVERUPEE, 10);
        this.inventory.addMoney(Bill.TENRUPEE, 10);
        this.inventory.addMoney(Bill.TWENTYRUPEE, 10);
        this.inventory.addMoney(Bill.FIFTYRUPEE, 10);
        this.inventory.addMoney(Bill.HUNDEREDRUPEE, 10);
        this.inventoryUtil = new InventoryUtil(inventory);
    }

    @Override
    public Boolean addMoneyToInventory(Map<Bill, Integer> monies) {
        for (Map.Entry<Bill, Integer> entry : monies.entrySet()) {
            this.inventory.addMoney(entry.getKey(), entry.getValue());
        }
        return true;
    }

    @Override
    public Boolean addProductsToInventory(Map<Product, Integer> products) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            this.inventory.addProduct(entry.getKey(), entry.getValue());
        }
        return true;
    }

    @Override
    public Map<Product, Integer> getAvailableProducts() {
        return this.inventory.getAvailableProducts();
    }

    @Override
    public Integer getPriceAndSelectedProduct(Product product, Integer quantity) throws Exception {
        this.inventoryUtil.validateProductPresentInInventory(product);
        Integer singleItemPrice = product.getPrice();
        this.state.setSelectedProduct(product);
        this.state.setQuantity(quantity);
        return singleItemPrice * quantity;
    }

    @Override
    public List<Bill> transactForProduct(Integer amount) throws Exception {
        if(this.state == null) {
            throw new Exception("No Item selected, cannot make transaction");
        }
        Product selectedProduct = this.state.getSelectedProduct();
        Integer selectedQuantity = this.state.getQuantity();
        this.inventoryUtil.validateProductPresentInInventory(selectedProduct);

        Integer cost = selectedQuantity*selectedProduct.getPrice();
        if(amount < cost) {
            throw new Exception("The transaction could not be completed because of less amount provided");
        }
        List<Bill> returnChange = this.inventoryUtil.getReturnChangeBills(amount-cost);
        // Code to update Inventory Below
        for(Bill bill: returnChange){
            this.inventory.addMoney(bill, 1);
        }
        this.inventory.addProduct(selectedProduct, selectedQuantity*-1);
        //
        return returnChange;
    }
}
