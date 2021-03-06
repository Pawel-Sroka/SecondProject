package com.sda.model.inventory;

import java.util.HashMap;
import java.util.Map;

public class PricedItem extends InventoryObject{
    private int price;
    private InventoryObject item;

    public PricedItem(String name, double weight, int count, int price, InventoryObject item) {
        super(name, weight, count);
        this.price = price;
        this.item = item;
    }

    @Override
    public String toString() {
        return "price= " + price +
                ", item=" + item ;
    }

    public int getPrice() {
        return price;
    }

    public InventoryObject getInventoryObject() {
        return item;
    }
}
