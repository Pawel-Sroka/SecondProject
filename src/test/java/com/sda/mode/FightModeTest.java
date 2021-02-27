package com.sda.mode;

import com.sda.exceptions.GameOverException;
import com.sda.model.characters.Enemy;
import com.sda.model.characters.Monster;
import com.sda.model.characters.Race;
import com.sda.model.characters.Warior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class FightModeTest {

    //private Hero hero;
    //private Enemy enemy;
    private FightMode fightMode;


    @BeforeEach
    void setUp() {
        Warior warior1 = new Warior("Glork", Race.GHOUL);
        warior1.setDamage(20);
        Enemy enemy = new Monster("monster1", 80, 15);
        fightMode = new FightMode(warior1,enemy);
        
    }

    @Test
    void fightTest() {
        /*assertAll(
                assertThrows(GameOverException,fightMode)

        );*/
    }
}