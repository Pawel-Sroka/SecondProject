package com.sda.serwice;

import com.sda.exceptions.GameOverException;
import com.sda.model.characters.Enemy;
import com.sda.model.characters.Hero;
import com.sda.model.characters.Raider;
import com.sda.model.inventory.Weapon;
import com.sda.repository.HeroRepository;

import java.util.Scanner;

public class Game {
    private static char map[][];
    private static Positions heroPos;
    private static Positions finishPos;
    private static Hero hero;
    private static int enemyKilled = 0;
    private static char oldField = '_';

    public static void main(String[] args)  {

        init();
        while (!heroPos.equals(finishPos)){

            showMap();
            String sc = new Scanner(System.in).nextLine();
            switch (sc.toUpperCase()){
                case "HELP" :
                    showHints();
                    break;
                case "W" :
                case "S" :
                case "A" :
                case "D" :
                    move(sc.toUpperCase());
                    break;

                default:
                    System.out.println("unknow command");
            }
            try {
                if (oldField == '~'){
                    hero.recieveDamage(5);
                    System.out.println("rzeka hp-5");
                }
                if (oldField == '.'){
                    hero.recieveDamage(1);
                    System.out.println("bagno hp-1");
                }
            }catch (GameOverException e){
                System.out.println("game over");
            }

            System.out.println("hero: " + hero.getName() + " a " + hero.getRace());
            System.out.println("hp: " + hero.getCurrentHealth() + " att: "+ hero.getDamage());
        }
    }

    private static void init(){

        map = FileService.mapLoad();
        heroPos = findChar('H');
        finishPos = findChar('F');

        HeroRepository heroRepository = new HeroRepository();
        heroRepository.showHeroes();
        System.out.println("write hero name: ");
        String name = new Scanner(System.in).nextLine();
        hero = heroRepository.getHeroes().get(name);

        showHints();

    }
    private static void move(String move){

        map[heroPos.getY()][heroPos.getX()] = oldField;

        if (move.equals("W")&&heroPos.getY()-1>=0){
            heroPos.setY(-1);
        }
        if (move.equals("S")&&heroPos.getY()+1<map.length ){
            heroPos.setY(1);
        }
        if (move.equals("A")&&heroPos.getX()-1>=0){
            heroPos.setX(-1);
        }
        if (move.equals("D")&&heroPos.getX()+1<map[0].length){
            heroPos.setX(1);
        }

        oldField = map[heroPos.getY()][heroPos.getX()];
        map[heroPos.getY()][heroPos.getX()]='H';
        // used to help set up field cooperation
        //System.out.println("go to x: " + heroPos.getX() +" y: "+ heroPos.getY());
    }

    private static Enemy getDefoultEnemy(){
        Raider enemy = new Raider("Andrzej",60,10);
        enemy.setWeapon(new Weapon("miecz",2,1,20));
        return enemy;
    }

    private static void showMap(){
        for (int i = 0; i < map.length; i++) {
            System.out.println();
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
                }
            }
        }


    public static void showHints(){
        Scanner sc = new Scanner(System.in);
        System.out.println("to move :");
        System.out.println("W - up");
        System.out.println("S - down");
        System.out.println("A - left");
        System.out.println("D - right");
        System.out.println("type:\n inventory - to see inventory");
        System.out.println("eat - to eat");
        System.out.println("weapon - to wear a weapon");
        System.out.println("help - to show this hints");
        System.out.println("press enter to continue");
        sc.nextLine();
    }

    private static Positions findChar(char toFind){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j]==toFind){
                    return new Positions(j,i);
                }
            }
        }
        return null;
    }

}
