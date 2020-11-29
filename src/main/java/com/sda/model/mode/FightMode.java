package com.sda.model.mode;

import com.sda.model.characters.*;
import com.sda.model.inventory.Weapon;

import java.util.Random;

public class FightMode {
    private Hero hero;
    private Enemy enemy;

    public FightMode(Hero hero, Enemy enemy) {
        this.hero = hero;
        this.enemy = enemy;
    }
    public void fight() {

        int heroDamage = 11;
        int heroDef = 0;
        if (hero instanceof Warior) {
            heroDamage = ((Warior) hero).getWeapon().getDamagePoints();
            heroDef = ((Warior) hero).getArmor().getDamageResist();
        }

        int enemyDamage = enemy.getDamage();
        if (enemy instanceof Raider) {
            enemyDamage = ((Raider) enemy).getWeapon().getDamagePoints();
        }
        Weapon drop = ((Raider) enemy).getWeapon();
        do {
            enemy.recieveDamage(heroDamage);
            if (enemy.getCurrentHealth() <= 0) {
                System.out.println("enemy killed");
                if (drop != null) {
                    hero.addToInventory(drop);
                }
                break;
            }
            if (enemy instanceof Monster) {
                enemyDamage = enemyDamage + new Random().nextInt(21) / 100 * enemyDamage;
            }
            hero.recieveDamage(enemyDamage - heroDef);
        }
        while (hero.getCurrentHealth() > 0);
        if (hero.getCurrentHealth() <= 0) {
            System.out.println("end game U R dead");
        }


    }
}
