package com.sda.model.mode;

import com.sda.model.inventory.PricedItem;

import java.util.HashMap;
import java.util.Map;

public class Trader {
    String name;
    private Map<String, PricedItem> stock = new HashMap<>();

    public Trader(String name, Map<String, PricedItem> stock) {
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

    public Map<String, PricedItem> getStock() {
        return stock;
    }
}
