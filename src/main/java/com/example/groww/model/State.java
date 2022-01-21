package com.example.groww.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class State {
    Product selectedProduct;
    Integer quantity;
    String message;
}
