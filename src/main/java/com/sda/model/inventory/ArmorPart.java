package com.sda.model.inventory;

public class ArmorPart extends InventoryObject{
    private int damageResist;
    private String bodyParts;

    public ArmorPart(String name, double weight, int count, int damageResist, String bodyParts) {
        super(name, weight, count);
        this.damageResist = damageResist;
        this.bodyParts = bodyParts;
    }

    public int getDamageResist() {
        return damageResist;
    }

    public void setDamageResist(int damageResist) {
        this.damageResist = damageResist;
    }

    public String getBodyParts() {
        return bodyParts;
    }

    public void setBodyParts(String bodyParts) {
        this.bodyParts = bodyParts;
    }
}
