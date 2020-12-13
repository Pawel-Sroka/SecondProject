package com.sda.serwice;

import com.sda.model.characters.Enemy;
import com.sda.model.characters.Hero;
import com.sda.model.characters.Raider;
import com.sda.model.inventory.Weapon;
import com.sda.repository.HeroRepository;

public class Game {
    private static char map[][];
    private static Positions heroPos;
    private static Positions finishPos;
    private static Hero hero;
    private static int enemyKilled = 0;

    public static void main(String[] args) {

        init();


    }
    private static void init(){
        map = FileService.mapLoad();
        heroPos = findChar('H');
        finishPos = findChar('F');

        HeroRepository heroRepository = new HeroRepository();
        hero = heroRepository.getHeroes().get("Karl");
        showHints();
    }

    private static Enemy getDefoultEnemy(){
        Raider enemy = new Raider("Andrzej",60,10);
        enemy.setWeapon(new Weapon("miecz",2,1,20));
        return enemy;
    }

    public static void showHints(){
        System.out.println("to move :");
        System.out.println("W - up");
        System.out.println("S - down");
        System.out.println("A - left");
        System.out.println("D - right");
        System.out.println("type: inventory - to see inventory");
        System.out.println("eat - to eat");
        System.out.println("weapon - to wear a weapon");
        System.out.println("help - to show this hints");
    }

    private static Positions findChar(char toFind){
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if (map[y][x]==toFind){
                    return new Positions(x,y);
                }
            }
        }
        return null;
    }

}
