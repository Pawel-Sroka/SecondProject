package com.sda.model.inventory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmorPartTest {

    private ArmorPart helmet;
    private ArmorPart torso;
    private ArmorPart leftArm;
    private ArmorPart rightArm;
    private ArmorPart leftLeg;
    private ArmorPart rightLeg;

    @BeforeEach
    void setUp() {
        helmet = new ArmorPart("Brass helmet", 0.4d, 1, 4, BodyParts.HEAD);
        torso = new ArmorPart("Chain mail", 4.2d, 1, 15, BodyParts.TORSO);
        leftArm = new ArmorPart("Leather bracer", 0.2d, 1, 2, BodyParts.LEFT_ARM);
        rightArm = new ArmorPart("Chain mail armlet", 0.4d, 1, 5, BodyParts.RIGHT_ARM);
        leftLeg = new ArmorPart("leather greave", 0.4d, 1, 4, BodyParts.LEFT_LEG);
        rightLeg = new ArmorPart("worn leather boots", 0.2d, 1, 2, BodyParts.RIGHT_LEG);
    }

    @Test
    @DisplayName("get name test")
    void getNameTest() {
        assertAll(
                () -> assertEquals("Brass helmet", helmet.getName()),
                () -> assertEquals("Chain mail", torso.getName()),
                () -> assertEquals("Leather bracer", leftArm.getName()),
                () -> assertEquals("Chain mail armlet", rightArm.getName()),
                () -> assertEquals("leather greave", leftLeg.getName()),
                () -> assertEquals("worn leather boots", rightLeg.getName())
        );
    }

    @Test
    @DisplayName("get weight test")
    void getWeightTest() {
        assertAll(
                () -> assertEquals(0.4, helmet.getWeight()),
                () -> assertEquals(4.2, torso.getWeight()),
                () -> assertEquals(0.2, leftArm.getWeight()),
                () -> assertEquals(0.4, rightArm.getWeight()),
                () -> assertEquals(0.4, leftLeg.getWeight()),
                () -> assertEquals(0.2, rightLeg.getWeight())
        );
    }

    @Test
    @DisplayName("get count test")
    void getCountTest() {
        assertAll(
                () -> assertEquals(1, helmet.getCount()),
                () -> assertEquals(1, torso.getCount()),
                () -> assertEquals(1, leftArm.getCount()),
                () -> assertEquals(1, rightArm.getCount()),
                () -> assertEquals(1, leftLeg.getCount()),
                () -> assertEquals(1, rightLeg.getCount())
        );
    }

    @Test
    @DisplayName("get damage resistance test")
    void getDamageResistTest() {
        assertAll(
                () -> assertEquals(4, helmet.getDamageResist()),
                () -> assertEquals(15, torso.getDamageResist()),
                () -> assertEquals(2, leftArm.getDamageResist()),
                () -> assertEquals(5, rightArm.getDamageResist()),
                () -> assertEquals(4, leftLeg.getDamageResist()),
                () -> assertEquals(2, rightLeg.getDamageResist())
        );
    }

    @Test
    @DisplayName("get Body Parts Test")
    void getBodyPartsTest() {
        assertAll(
                () -> assertEquals(BodyParts.HEAD, helmet.getBodyParts()),
                () -> assertEquals(BodyParts.TORSO, torso.getBodyParts()),
                () -> assertEquals(BodyParts.LEFT_ARM, leftArm.getBodyParts()),
                () -> assertEquals(BodyParts.RIGHT_ARM, rightArm.getBodyParts()),
                () -> assertEquals(BodyParts.LEFT_LEG, leftLeg.getBodyParts()),
                () -> assertEquals(BodyParts.RIGHT_LEG, rightLeg.getBodyParts())
        );
    }
}