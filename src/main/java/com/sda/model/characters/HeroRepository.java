package com.sda.model.characters;

import com.sda.model.exceptions.NoEmptySlotException;
import com.sda.model.inventory.ArmorPart;
import com.sda.model.inventory.BodyParts;
import com.sda.model.inventory.Food;
import com.sda.model.inventory.Weapon;
import com.sda.model.magic.Spell;

import java.util.HashMap;
import java.util.Map;

public class HeroRepository {
    private static Map<String,Hero> heroes = new HashMap<>();



    public HeroRepository() throws NoEmptySlotException {
        Sorcerer sorc1 = new Sorcerer("Merlin",Race.HUMAN,20);
        sorc1.setDamage(15);
        sorc1.addToInventory(new ArmorPart("tiara",0.3,1,5, BodyParts.HEAD));
        //sorc1.addToInventory(new Weapon("wand",1,1,12));
        sorc1.addSpell(new Spell("fireball",15,0,0));
        sorc1.addSpell(new Spell("drain Life",5,5,0));
        Warior warior1 = new Warior("Glork",Race.GHOUL, 10);
        warior1.setDamage(12);
        warior1.addToInventory(new ArmorPart("chain mail",5,1,10,BodyParts.TORSO));
        warior1.addToInventory(new Weapon("short sword",2,1,15));
        warior1.getWeapon();
        Hero warior2 = new Warior("Karl",Race.MUTANT, 10);
        warior2.setDamage(8);
        warior2.addToInventory(new ArmorPart("Rusty helmet",1,1,5,BodyParts.HEAD));
        warior2.addToInventory(new ArmorPart("Worn boot",1,1,2,BodyParts.RIGHT_LEG));
        warior2.addToInventory(new Weapon("Rusty sword",2,1,5));
        Hero peasant = new Hero("Glut",Race.HUMAN, 5);
        peasant.setDamage(5);
        peasant.addToInventory(new Food("Apple",1,2,10));
        Hero ghoul1 = new Hero("Rotten", Race.GHOUL, 6);
        ghoul1.setDamage(11);
    }
}
