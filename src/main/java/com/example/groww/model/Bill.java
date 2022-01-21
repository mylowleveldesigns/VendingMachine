package com.example.groww.model;

import java.util.ArrayList;
import java.util.List;

public enum Bill {
    FIVERUPEE(5), TENRUPEE(10), TWENTYRUPEE(20), FIFTYRUPEE(50), HUNDEREDRUPEE(100);
    int billValue;

    Bill(int billValue) {
        this.billValue = billValue;
    }

    public int getBillValue() {
        return billValue;
    }

    public static List<Bill> getAvailableBills(){
        List<Bill> bills = new ArrayList<>();
        bills.add(HUNDEREDRUPEE);
        bills.add(FIFTYRUPEE);
        bills.add(TWENTYRUPEE);
        bills.add(TENRUPEE);
        bills.add(FIVERUPEE);
        return bills;
    }
}
