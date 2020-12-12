package com.sda.model.characters;

import com.sda.model.exceptions.GameOverException;
import com.sda.model.exceptions.InvalidTypeException;
import com.sda.model.exceptions.NoEmptySlotException;
import com.sda.model.inventory.Food;
import com.sda.model.inventory.InventoryObject;

import java.util.Arrays;
import java.util.Objects;

public class Hero implements Vunerable {
    public static final double MAX_WEIGHT_LIMIT = 100;
    public final int maxHealth;
    private int damage = 10;
    private String name;
    private Race race;
    private int currentHealth;
    private int money;
    private boolean overloaded;
    private InventoryObject inventory[] = new InventoryObject[10];

    public Hero(String name, Race race, int money) {
        this.name = name;
        this.race = race;
        this.currentHealth = maxHealth = race.getRaceHitPoints();
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public boolean isOverloaded() {
        return overloaded;
    }

    public void setOverloaded(boolean overloaded) {
        this.overloaded = overloaded;
    }

    public void showInventory() {
        Arrays.stream(inventory)
                .filter(x-> x != null)
                .forEach(a-> System.out.println(a));

//        for (InventoryObject i : inventory) {
//
//            if (i != null) {
//                System.out.println(i);
//            }
//        }
    }

    @Override
    public void recieveDamage(int points) throws GameOverException {
        this.currentHealth -= points;

        if (this.currentHealth <= 0) {
            throw new GameOverException();
        }

    }


    public void eatFood(int slot) throws InvalidTypeException {
        if (inventory[slot] instanceof Food) {
            Food toEat = (Food) inventory[slot];
            int sum = this.currentHealth + toEat.getHealthPointsRegeneration();
            this.currentHealth += Math.min(sum, maxHealth);
            if (toEat.getCount() > 1) {
                toEat.setCount(toEat.getCount() - 1);
            } else {
                inventory[slot] = null;
            }
        } else {

            throw new InvalidTypeException("it's not a food");
        }


    }

    public void addToInventory(InventoryObject toAdd) throws NoEmptySlotException {
        boolean added = false;
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null && inventory[i].equals(toAdd)) {
                inventory[i].setCount(inventory[i].getCount() + 1);
                added = true;
                break;
            } else if (inventory[i] == null) {
                inventory[i] = toAdd;
                added = true;
                break;
            }
        }
        if (!added) {
            throw new NoEmptySlotException();
        } else {
            updateOverload();
        }
    }

    private void updateOverload() {
        double sum = Arrays.stream(inventory)
                .filter(Objects::nonNull)
                .map(i->i.getCount()*i.getWeight())
                .reduce(0d,(a, b) ->a+b);
                //       double sum = 0;
//        for (InventoryObject i : inventory) {
//            if (i != null) {
//                sum += i.getWeight() * i.getCount();
//            }
//        }
        this.overloaded = sum > MAX_WEIGHT_LIMIT;
    }

    public InventoryObject[] getInventory() {
        return inventory;
    }
}

