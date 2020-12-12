package com.sda.model.characters;

import com.sda.model.inventory.InventoryObject;
import com.sda.model.inventory.Price;

import java.util.HashMap;
import java.util.Map;

public class Trader {
    String name;
    private Map<String, Price> stock = new HashMap<>();

    public Trader(String name, Map<String, Price> stock) {
        this.name = name;
        this.stock = stock;
    }

//    public void showItems(){
//        for (String i : stock.keySet()){
//            System.out.println(i + "price: "+ stock.get(i));
//        }
//    }

    public String getName() {
        return name;
    }

    public Map<String, Price> getStock() {
        return stock;
    }
}
