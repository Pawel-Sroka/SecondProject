package com.sda.model.characters;

import com.sda.exceptions.GameOverException;
import com.sda.model.magic.Spell;

import java.util.Set;
import java.util.TreeSet;

public class Sorcerer extends Hero {
    private int magicResistant;
    private Set<Spell> spell = new TreeSet<>();

    public Sorcerer(String name, Race race) {
        super(name, race);
        setDamage(getDamage()*2) ;
    }


    public void listOfSpells() {
        spell.forEach(System.out::println);
//        for (Spell i : spell) {
//            System.out.println(i.toString());
//        }
    }

    public void addSpell(Spell toAdd) {
        if (spell.add(toAdd)) {
            spell.add(toAdd);
            this.magicResistant += toAdd.getSpellDamageResistant();
            setDamage(getDamage()+toAdd.getSpellDamage());
            setCurrentHealth(getCurrentHealth()+toAdd.getSpellHealPoints());
        } else System.out.println("Already got this spell!");
    }

    @Override
    public void receiveDamage(int points) throws GameOverException {
        int damageResist = this.magicResistant;
        if (damageResist < points) {
            super.receiveDamage(points - damageResist);
        } else System.out.println("No damage");
    }

    public int getMagicResistant() {
        return magicResistant;
    }

    public void setMagicResistant(int magicResistant) {
        this.magicResistant = magicResistant;
    }

    public Set<Spell> getSpell() {
        return spell;
    }

    public void setSpell(Set<Spell> spell) {
        this.spell = spell;
    }
}
