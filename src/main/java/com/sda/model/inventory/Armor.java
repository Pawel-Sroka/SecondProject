package com.sda.model.inventory;

import java.util.HashMap;
import java.util.Map;

public class Armor extends ArmorPart {

    //    private ArmorPart head;
//    private ArmorPart torso;
//    private ArmorPart leftArm;
//    private ArmorPart rightArm;
//    private ArmorPart leftLeg;
//    private ArmorPart rightLeg;
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
//        ArmorPart toReturn = null;
//        switch (toWear.getBodyParts()){
//            case HEAD:
//                toReturn = this.head;
//                this.head = toWear;
//                break;
//            case TORSO:
//                toReturn = this.torso;
//                this.torso = toWear;
//                break;
//            case LEFT_ARM:
//                toReturn = this.leftArm;
//                this.leftArm = toWear;
//                break;
//            case RIGHT_ARM:
//                toReturn = this.rightArm;
//                this.rightArm = toWear;
//                break;
//            case LEFT_LEG:
//                toReturn = this.leftLeg;
//                this.leftLeg = toWear;
//                break;
//            case RIGHT_LEG:
//                toReturn = this.rightLeg;
//                this.rightLeg = toWear;
//                break;
//
//        }
//        return toReturn;
    }


    public int damageResistanceSummary() {
        int resistSummary = 0;
        //przechodzimy po kluczach
//        for (BodyParts i : parts.keySet()) {
//            resistSummary += parts.get(i).getDamageResist();
//        }
        //lub przechodzimy po wartościach:
        for (ArmorPart p : parts.values()){
            resistSummary+=p.getDamageResist();
        }
        return resistSummary;
        //old body:
//        return head.getDamageResist()
//                + torso.getDamageResist()
//                + leftLeg.getDamageResist()
//                + leftArm.getDamageResist()
//                + rightArm.getDamageResist()
//                + rightLeg.getDamageResist();
    }

    public Map<BodyParts, ArmorPart> getParts() {
        return parts;
    }

    public void setParts(Map<BodyParts, ArmorPart> parts) {
        this.parts = parts;
    }
// old set/get:
//    public ArmorPart getHead() {
//        return head;
//    }
//
//    public void setHead(ArmorPart head) {
//        this.head = head;
//    }
//
//    public ArmorPart getTorso() {
//        return torso;
//    }
//
//    public void setTorso(ArmorPart torso) {
//        this.torso = torso;
//    }
//
//    public ArmorPart getLeftArm() {
//        return leftArm;
//    }
//
//    public void setLeftArm(ArmorPart leftArm) {
//        this.leftArm = leftArm;
//    }
//
//    public ArmorPart getRightArm() {
//        return rightArm;
//    }
//
//    public void setRightArm(ArmorPart rightArm) {
//        this.rightArm = rightArm;
//    }
//
//    public ArmorPart getLeftLeg() {
//        return leftLeg;
//    }
//
//    public void setLeftLeg(ArmorPart leftLeg) {
//        this.leftLeg = leftLeg;
//    }
//
//    public ArmorPart getRightLeg() {
//        return rightLeg;
//    }
//
//    public void setRightLeg(ArmorPart rightLeg) {
//        this.rightLeg = rightLeg;
//    }
}
