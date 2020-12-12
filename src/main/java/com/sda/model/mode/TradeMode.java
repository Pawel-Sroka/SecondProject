package com.sda.model.mode;

import com.sda.model.characters.Hero;
import com.sda.model.characters.Trader;
import com.sda.model.exceptions.NoEmptySlotException;
import com.sda.model.inventory.InventoryObject;
import com.sda.model.inventory.Price;

public class TradeMode {
    private Hero customer;
    private Trader trader;

    public TradeMode(Hero customer, Trader trader) {
        this.customer = customer;
        this.trader = trader;
    }

    public void showItems() {
        trader.getStock().values().forEach(System.out::println);

//        for (Price item : trader.getStock().values()) {
//            System.out.println(item);
//        }
    }

    public void buyItem(String itemName) throws NoEmptySlotException {
        Price toBuy = trader.getStock().get(itemName);
        if (toBuy != null) {
            if (customer.getMoney() >= trader.getStock().get(itemName).getPrice()) {
                customer.addToInventory(toBuy);
                customer.setMoney(customer.getMoney()-trader.getStock().get(itemName).getPrice());
                trader.getStock().remove(itemName);
            } else System.out.println("not enought money");
        }
    }
}
