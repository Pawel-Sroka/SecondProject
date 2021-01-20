package com.sda.model.inventory;

public class Weapon extends InventoryObject {
    private int damagePoints;

    public Weapon(String name, double weight, int count, int damagePoints) {
        super(name, weight, count);
        this.damagePoints = damagePoints;
    }

    public int getDamagePoints() {
        return damagePoints;
    }

    public void setDamagePoints(int damagePoints) {
        this.damagePoints = damagePoints;
    }

    @Override
    public String toString() {
        return "Weapon: \"" + getName() +"\", damage: " + damagePoints +", weight: "+ getWeight() + ", amount of: "+ getCount();
    }
}
