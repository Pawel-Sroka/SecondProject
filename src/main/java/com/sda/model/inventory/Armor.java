package com.sda.model.inventory;

public class Armor extends ArmorPart{

    private ArmorPart leftArm;
    private ArmorPart head;
    private ArmorPart rightArm;
    private ArmorPart torso;
    private ArmorPart leftLeg;
    private ArmorPart rightLeg;

    public Armor(String name, double weight, int count, int damageResist, String bodyParts) {
        super(name, weight, count, damageResist, bodyParts);
    }
    public ArmorPart wearPart(ArmorPart toWear){
        ArmorPart toReturn = null;
        switch (toWear.getBodyParts()){
            case "head":
                toReturn = this.head;
                this.head = toWear;
                break;
            case "leftArm":
                toReturn = this.leftArm;
                this.leftArm = toWear;
                break;
            case "rightArm":
                toReturn = this.rightArm;
                this.rightArm = toWear;
                break;
            //.....
        }
        return toReturn;
    }

    public ArmorPart getLeftHand() {
        return leftArm;
    }

    public void setLeftHand(ArmorPart leftHand) {
        this.leftArm = leftHand;
    }

    public ArmorPart getHead() {
        return head;
    }

    public void setHead(ArmorPart head) {
        this.head = head;
    }

    public ArmorPart getRightArm() {
        return rightArm;
    }

    public void setRightArm(ArmorPart rightArm) {
        this.rightArm = rightArm;
    }

    public ArmorPart getTorso() {
        return torso;
    }

    public void setTorso(ArmorPart torso) {
        this.torso = torso;
    }

    public ArmorPart getLeftLeg() {
        return leftLeg;
    }

    public void setLeftLeg(ArmorPart leftLeg) {
        this.leftLeg = leftLeg;
    }

    public ArmorPart getRightLeg() {
        return rightLeg;
    }

    public void setRightLeg(ArmorPart rightLeg) {
        this.rightLeg = rightLeg;
    }
}
