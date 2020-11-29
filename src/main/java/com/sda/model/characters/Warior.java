package com.sda.model.characters;

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

    public void wearWeapon(int slot) {
        if (super.getInventory()[slot] instanceof Weapon) {
            Weapon toWear = (Weapon) super.getInventory()[slot];
            super.getInventory()[slot] = null;
            super.addToInventory(this.weapon);
            this.weapon = toWear;
        } else System.out.println("not a weapon");
    }
    public void wearArmor(int slot){
        if (super.getInventory()[slot] instanceof ArmorPart){
            ArmorPart toWear = (ArmorPart) super.getInventory()[slot];
            super.getInventory()[slot] = null;
            super.addToInventory(this.armor.wearPart(toWear));
        }else System.out.println("not a armor part");
    }

}


