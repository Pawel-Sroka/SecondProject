package com.sda.repository;

import com.sda.exceptions.InvalidTypeException;
import com.sda.exceptions.NoEmptySlotException;
import com.sda.model.characters.Hero;
import com.sda.model.characters.Race;
import com.sda.model.characters.Sorcerer;
import com.sda.model.characters.Warior;
import com.sda.model.inventory.ArmorPart;
import com.sda.model.inventory.BodyParts;
import com.sda.model.inventory.Food;
import com.sda.model.inventory.Weapon;
import com.sda.model.magic.Spell;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HeroRepository {
    private Map<String, Hero> heroes = new HashMap<>();

    public HeroRepository() {
        try {
            preparedData();
        } catch (NoEmptySlotException | InvalidTypeException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Hero> getHeroes() {
        return heroes;
    }

    private void preparedData() throws NoEmptySlotException, InvalidTypeException {
        Sorcerer sorc1 = new Sorcerer("Merlin", Race.HUMAN);
        sorc1.setDamage(15);
        sorc1.addToInventory(new ArmorPart("Tiara", 0.3, 1, 5, BodyParts.HEAD));
        sorc1.addSpell(new Spell("Fireball", 15, 0, 0));
        sorc1.addSpell(new Spell("Drain Life", 5, 5, 0));
        heroes.put("Czarodziej", sorc1);

        Warior warior1 = new Warior("Glork", Race.GHOUL);
        warior1.setDamage(20);
        warior1.addToInventory(new ArmorPart("Chain mail", 5, 1, 10, BodyParts.TORSO));
        warior1.addToInventory(new Weapon("Short sword", 2, 1, 15));
        warior1.wearWeapon(1);
        heroes.put("Warrior", warior1);

       /* Warior warior2 = new Warior("Karl", Race.MUTANT);
        warior2.setDamage(8);
        warior2.addToInventory(new ArmorPart("Rusty helmet", 1, 1, 5, BodyParts.HEAD));
        warior2.addToInventory(new ArmorPart("Worn boot", 1, 1, 2, BodyParts.RIGHT_LEG));
        warior2.addToInventory(new Weapon("Rusty sword", 2, 1, 5));
        warior2.wearWeapon(2);
        heroes.put("Mutant warrior", warior2);*/

        Hero peasant = new Hero("Glut", Race.HUMAN);
        peasant.setDamage(15);
        peasant.addToInventory(new Food("Apple", 1, 2, 10));
        heroes.put("Wsiok", peasant);

        /*Hero ghoul1 = new Hero("Rotten", Race.GHOUL);
        ghoul1.setDamage(11);
        heroes.put("Rotten Ghoul", ghoul1);

        Hero countryMan = new Hero("Andrzej", Race.HUMAN);
        countryMan.setDamage(11);
        heroes.put("Typical peasant", countryMan);

        Hero countryWoman = new Hero("Grażyna", Race.HUMAN);
        countryWoman.setDamage(7);
        countryWoman.addToInventory(new Food("Apple", 0.1, 1, 10));
        heroes.put("Peasant woman", countryWoman);

        Warior warrior = new Warior("Geralt", Race.HUMAN);
        warrior.setDamage(30);
        warrior.addToInventory(new Weapon("Sword", 1, 1, 70));
        warrior.wearWeapon(0);
        warrior.addToInventory(new ArmorPart("Torso Armor", 1, 1, 50, BodyParts.TORSO));
        heroes.put("Geralt", warrior);

        Warior warrior2 = new Warior("Darkness Prince", Race.GHOUL);
        warrior2.setDamage(40);
        warrior2.addToInventory(new Weapon("Sword", 1, 1, 70));
        warrior2.wearWeapon(0);
        warrior2.addToInventory(new ArmorPart("Right Arm Armor", 0.5, 1, 20, BodyParts.RIGHT_ARM));
        //warrior2.wearArmor(0);
        heroes.put("Darkness Prince", warrior2);

        Sorcerer sorcerer = new Sorcerer("Gandalf", Race.MUTANT);
        sorcerer.addSpell(new Spell("Blabla", 10, 10, 10));
        heroes.put("Gandalf", sorcerer);*/
    }

    public void showHeroes(){
        sortByName("a");
        for (String i:heroes.keySet()){
            System.out.println(i);
        }
    }
    public List<Hero> sortByName(String name) {
        return heroes.values().stream()
                .filter(n -> n.getName().contains(name))
                .collect(Collectors.toList());

    }

    public List<Hero> sortByRace(Race race) {
        return heroes.values().stream()
                .filter(a -> a.getRace().equals(race))
                .collect(Collectors.toList());
    }

    public List<Hero> sortByHealth(int health) {
        return heroes.values().stream()
                .filter(a -> a.getCurrentHealth() >= health)
                .collect(Collectors.toList());
    }

    public List<Hero> sortByWeapon(Weapon weapon) {
//        return heroes.values().stream()
//                .filter(a->a instanceof Warior)
//                .filter(w-> ((Warior) w).getWeapon().equals(weapon))
//                .collect(Collectors.toList());
        //mozna tez tak:
        return heroes.values().stream()
                .filter(a -> a instanceof Warior)
                .map(r -> (Warior) r)
                .filter(w -> w.getWeapon().equals(weapon))
                .collect(Collectors.toList());
    }

    public List<Hero> sortByload(int min, int max) {
        return heroes.values().stream()
                .filter(h -> {
                    double sum = h.updateOverload();
                    return sum <= max && sum >= min;
                })
                .collect(Collectors.toList());
    }

}
