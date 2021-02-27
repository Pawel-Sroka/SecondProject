package com.sda.model.inventory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {
    private Food food;

    @BeforeEach
    void setup(){
        food = new Food("Bread",0.6d,1,10);
    }
    @Test
    @DisplayName("check creation of object")
    void foodCreateTest(){
       /* String result = food.getName();
        assertEquals("Bread", result);*/
        assertAll(
                ()-> assertEquals("Bread",food.getName()),
                ()-> assertEquals(0.6d,food.getWeight()),
                ()-> assertEquals(1,food.getCount()),
                ()-> assertEquals(10,food.getHealthPointsRegeneration())
        );
    }

}