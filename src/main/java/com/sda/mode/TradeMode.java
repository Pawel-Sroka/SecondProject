package com.sda.mode;

import com.sda.model.characters.Hero;
import com.sda.exceptions.NoEmptySlotException;
import com.sda.model.inventory.PricedItem;
import com.sda.model.inventory.Weapon;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<PricedItem> sortByPrice(int min, int max) {
        return trader.getStock().values().stream()
                .filter(p -> p.getPrice() >= min && p.getPrice() <= max)
                .collect(Collectors.toList());
    }
    public int showCostOfAll(){
        return trader.getStock().values().stream()
                .map(PricedItem::getPrice)
                //.map(a-> a.getPrice())
                .reduce(0, Integer::sum);
                //.reduce(0,(a,b)-> a+b);
    }
    public List<PricedItem> showWeaponByDmg(int min, int max){
        return trader.getStock().values().stream()
                .filter(i-> i.getInventoryObject() instanceof Weapon)
                .filter(i -> ((Weapon) i.getInventoryObject()).getDamagePoints()>=min&& ((Weapon) i.getInventoryObject()).getDamagePoints()<=max)
                .collect(Collectors.toList());
    }


    public void buyItem(String itemName) throws NoEmptySlotException {
        PricedItem toBuy = trader.getStock().get(itemName);
        if (toBuy != null) {
            if (customer.getMoney() >= trader.getStock().get(itemName).getPrice()) {
                customer.addToInventory(toBuy);
                customer.setMoney(customer.getMoney() - trader.getStock().get(itemName).getPrice());
                trader.getStock().remove(itemName);
            } else System.out.println("Not enough money");
        }
    }
}
