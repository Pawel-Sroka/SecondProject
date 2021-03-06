package com.sda.model.characters;

import com.sda.exceptions.GameOverException;
import com.sda.exceptions.InvalidTypeException;
import com.sda.exceptions.NoEmptySlotException;
import com.sda.model.inventory.Armor;
import com.sda.model.inventory.ArmorPart;
import com.sda.model.inventory.Weapon;

public class Warior extends Hero {
    private Weapon weapon;
    private Armor armor;

    public Warior(String name, Race race) {
        super(name, race);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public void wearWeapon(int slot) throws InvalidTypeException, NoEmptySlotException {
        if (super.getInventory()[slot] instanceof Weapon) {
            Weapon toWear = (Weapon) super.getInventory()[slot];
            super.getInventory()[slot] = null;
            super.addToInventory(this.weapon);
            this.weapon = toWear;
        } else {
            throw new InvalidTypeException("It's not a weapon");
        }
    }

    public void wearArmor(int slot) throws InvalidTypeException, NoEmptySlotException {
        if (super.getInventory()[slot] instanceof ArmorPart) {
            ArmorPart toWear = (ArmorPart) super.getInventory()[slot];
            super.getInventory()[slot] = null;
            super.addToInventory(this.armor.wearPart(toWear)); // tu coś nie działa
        } else {
            throw new InvalidTypeException("it's not a armor");
        }

    }

    @Override
    public void receiveDamage(int points) throws GameOverException { // something is going wrong when Warior recive damage by swamp field
        int damageResistance = this.armor.damageResistanceSummary();
        if (damageResistance < points) {
            super.receiveDamage(points - damageResistance);
        } else {
            System.out.println("No damage ");
        }
    }
}


