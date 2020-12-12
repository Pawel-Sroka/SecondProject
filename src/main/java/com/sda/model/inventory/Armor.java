package com.sda.model.inventory;

import java.util.HashMap;
import java.util.Map;

public class Armor extends ArmorPart{

//    private ArmorPart head;
//    private ArmorPart torso;
//    private ArmorPart leftArm;
//    private ArmorPart rightArm;
//    private ArmorPart leftLeg;
//    private ArmorPart rigthLeg;
    private Map<BodyParts,ArmorPart> parts = new HashMap<>();


    public Armor(String name, double weight, int count, int damageResist, BodyParts bodyParts) {
        super(name, weight, count, damageResist, bodyParts);
    }

//    public ArmorPart wearPart(ArmorPart toWear){
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
//                toReturn = this.rigthLeg;
//                this.rigthLeg = toWear;
//                break;
//
//        }
//        return toReturn;
//    }


    public int damageResistanceSummary(){
        int resistSummary=0;
        for (BodyParts i : parts.keySet()){
            resistSummary+=parts.get(i).getDamageResist();
        }return resistSummary;
        //old body:
//        return head.getDamageResist()
//                + torso.getDamageResist()
//                + leftLeg.getDamageResist()
//                + leftArm.getDamageResist()
//                + rightArm.getDamageResist()
//                + rigthLeg.getDamageResist();
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
//    public ArmorPart getRigthLeg() {
//        return rigthLeg;
//    }
//
//    public void setRigthLeg(ArmorPart rigthLeg) {
//        this.rigthLeg = rigthLeg;
//    }
}
