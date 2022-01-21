package com.example.groww.util;

import com.example.groww.inventory.Inventory;
import com.example.groww.model.Bill;
import com.example.groww.model.Product;

import java.util.ArrayList;
import java.util.List;

public class InventoryUtil {
    Inventory inventory;

    public InventoryUtil(Inventory inventory) {
        this.inventory = inventory;
    }

    public void validateProductPresentInInventory(Product product) throws Exception {
        Integer qnt = this.inventory.getAvailalbeProductQuantity(product);
        if(qnt == null || qnt == 0){
            throw new Exception("Invalid product in inventory - " + product.getName());
        }
    }

    public List<Bill> getReturnChangeBills(Integer returnChange) throws Exception {
        List<Bill> returnChangeBills = new ArrayList<>();
        Integer remainingAmount = returnChange;
        List<Bill> availableBills = Bill.getAvailableBills();
        for(Bill bill: availableBills){
            Integer billValue = bill.getBillValue();
            if(remainingAmount/billValue > 0){
                Integer divisor = remainingAmount/billValue;
                remainingAmount = remainingAmount - billValue*divisor;

                for(int i=0;i<divisor;i++){
                    returnChangeBills.add(bill);
                }
            }
        }
        if(remainingAmount !=0){
            throw new Exception("Cannot procees with this transaction because not able to return the money");
        }
        return returnChangeBills;
    }
}
