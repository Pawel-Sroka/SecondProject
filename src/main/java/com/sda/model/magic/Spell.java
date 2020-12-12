package com.sda.model.magic;

import java.util.Objects;

public class Spell implements Comparable {
    private String spellName;
    private int spellDamage;
    private int spellHealPoints;
    private int spellDamageResistant;

    public Spell(String spellName, int spellDamage, int spellHealPoints, int spellDamageResistant) {
        this.spellName = spellName;
        this.spellDamage = spellDamage;
        this.spellHealPoints = spellHealPoints;
        this.spellDamageResistant = spellDamageResistant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spell spell = (Spell) o;
        return spellDamage == spell.spellDamage &&
                spellHealPoints == spell.spellHealPoints &&
                spellDamageResistant == spell.spellDamageResistant &&
                Objects.equals(spellName, spell.spellName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spellName, spellDamage, spellHealPoints, spellDamageResistant);
    }

    @Override
    public String toString() {
        return "Spell{" +
                "spellName='" + spellName + '\'' +
                ", spellDamage=" + spellDamage +
                ", spellHealPoints=" + spellHealPoints +
                ", spellDamageResistant=" + spellDamageResistant +
                '}';
    }

    public String getSpellName() {
        return spellName;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    public int getSpellDamage() {
        return spellDamage;
    }

    public void setSpellDamage(int spellDamage) {
        this.spellDamage = spellDamage;
    }

    public int getSpellHealPoints() {
        return spellHealPoints;
    }

    public void setSpellHealPoints(int spellHealPoints) {
        this.spellHealPoints = spellHealPoints;
    }

    public int getSpellDamageResistant() {
        return spellDamageResistant;
    }

    public void setSpellDamageResistant(int spellDamageResistant) {
        this.spellDamageResistant = spellDamageResistant;
    }

    @Override
    public int compareTo(Object o) {
        Spell spell = (Spell) o;
        return this.spellName.compareTo(spell.spellName);
    }
}
