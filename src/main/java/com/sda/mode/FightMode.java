package com.sda.mode;

import com.sda.model.characters.*;
import com.sda.exceptions.GameOverException;
import com.sda.exceptions.NoEmptySlotException;
import com.sda.model.inventory.Weapon;

import java.util.Random;

public class FightMode {
    private Hero hero;
    private Enemy enemy;

    public FightMode(Hero hero, Enemy enemy) {
        this.hero = hero;
        this.enemy = enemy;
    }

    public void fight() throws GameOverException, NoEmptySlotException {

        int heroDamage = hero.getDamage();

        if (hero instanceof Warior) {
            heroDamage = ((Warior) hero).getWeapon().getDamagePoints();
        }
        int enemyDamage = enemy.getDamage();
        if (enemy instanceof Raider) {
            enemyDamage = ((Raider) enemy).getWeapon().getDamagePoints();
        }
        Weapon drop = null;
        if (enemy instanceof Raider) {
            drop = ((Raider) enemy).getWeapon();
        }
        do {
            enemy.receiveDamage(heroDamage);
            System.out.println(" Enemy got: "+heroDamage+" dmg");
            if (enemy.getCurrentHealth() <= 0) {
                System.out.println("Enemy killed");
                if (drop != null) {
                    hero.addToInventory(drop);
                }
                break;
            }

            if (enemy instanceof Monster) {
                enemyDamage = enemyDamage + ((new Random().nextInt(21)+1) / 100) * enemyDamage;
            }
            hero.receiveDamage(enemyDamage);
            System.out.println(" Hero got: "+enemyDamage+" dmg");
        }
        while (hero.getCurrentHealth() > 0 || enemy.getCurrentHealth() > 0);
        if (hero.getCurrentHealth() <= 0) {
            throw new GameOverException();
        }


    }
}
