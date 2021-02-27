package com.sda.model.inventory;

import java.util.HashMap;
import java.util.Map;

public class Armor extends ArmorPart {

    private Map<BodyParts, ArmorPart> parts = new HashMap<>();


    public Armor(String name, double weight, int count, int damageResist, BodyParts bodyParts) {
        super(name, weight, count, damageResist, bodyParts);
    }

    public ArmorPart wearPart(ArmorPart toWear) {
        if (toWear != null) {
            ArmorPart toReturn = parts.get(toWear.getBodyParts());
            parts.put(toWear.getBodyParts(),toWear);
            return toReturn;
        }return null;
    }


    public int damageResistanceSummary() {
        int resistSummary = 0;

        for (ArmorPart p : parts.values()){
            resistSummary+=p.getDamageResist();
        }
        return resistSummary;
    }

    public Map<BodyParts, ArmorPart> getParts() {
        return parts;
    }

    public void setParts(Map<BodyParts, ArmorPart> parts) {
        this.parts = parts;
    }

}
