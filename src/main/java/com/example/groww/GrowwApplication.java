package com.example.groww;

import com.example.groww.model.Product;
import com.example.groww.service.VendingMachine;
import com.example.groww.service.VendingMachineImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class GrowwApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrowwApplication.class, args);
//		System.out.println("working");
		try{
			VendingMachine machine = new VendingMachineImpl();
			Map<Product, Integer> available = machine.getAvailableProducts();
			printMap(available);
			System.out.print(machine.getPriceAndSelectedProduct(new Product("Pepsi", 50), 4));

		} catch (Exception e){

		}

	}

	public static void printMap(Map<Product, Integer> mp){
		for(Map.Entry<Product, Integer> entry: mp.entrySet() ){
			System.out.print(entry.getKey().getName());
			System.out.println(" " + entry.getValue());
		}
	}

}
/*
VENDING MACHINE

Products - Dairy Milk , Lays , Pepsi
Price - 10 , 20 , 50
Denomination allowed - 5 , 10 , 20, 50, 100

i) Method to add Products and Denomintation quantities
ii) Display the product with Prices and quantities available
iii) Ask the user to select product with quantities , show him the cost
iv) Do a transaction if everything is valid and try to return change with
    minimum quantity of notes
 */


/*
Product
Inventory



 */