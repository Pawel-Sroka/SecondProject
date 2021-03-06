package com.sda.serwice;

import com.sda.exceptions.GameOverException;
import com.sda.exceptions.InvalidTypeException;
import com.sda.exceptions.NoEmptySlotException;
import com.sda.mode.FightMode;
import com.sda.model.characters.Enemy;
import com.sda.model.characters.Hero;
import com.sda.model.characters.Raider;
import com.sda.model.characters.Warior;
import com.sda.model.inventory.Food;
import com.sda.model.inventory.InventoryObject;
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
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String BLACK_BOLD = "\033[1;30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String GREEN_BRIGHT = "\033[0;92m";

    public static void main(String[] args) throws InvalidTypeException {
            init();
            while (!heroPos.equals(finishPos)) {
                showMap();
                String sc = new Scanner(System.in).nextLine().toUpperCase();
                switch (sc) {
                    case "HELP":
                        showHints();
                        break;
                    case "W":
                    case "S":
                    case "A":
                    case "D":
                        move(sc);
                        break;
                    case "INVENTORY":
                        hero.showInventory();
                        break;
                    case "EAT":
                        eat();
                        break;
                    case "WEAPON":
                        if (hero instanceof Warior) {
                            ((Warior) hero).getWeapon();
                        } else System.out.println("you are not a warrior!");
                        break;
                    default:
                        System.out.println("Unknow command");
                }
                try {
                    if (oldField == '#') {
                        if (sc.equals("W")) {
                            move("S");
                        } else if (sc.equals("S")) {
                            move("W");
                        } else if (sc.equals("A")) {
                            move("D");
                        } else if (sc.equals("D")) {
                            move("A");
                        }
                        System.out.println("Rocks, cannot pass");
                    }
                    if (oldField == 'F') {
                        System.out.println("you got to last location! Congratulations!");
                    }
                    if (oldField == '~') {
                        hero.receiveDamage(5);
                        System.out.println("River hp-5");
                    }
                    if (oldField == '.') { // something is going wrong when Warior recive damage by this field
                        hero.receiveDamage(1);
                        System.out.println("Swamp hp-1");
                    }
                    if (oldField == 'E') {
                        FightMode fighting = new FightMode(hero, getDefoultEnemy());
                        fighting.fight();
                        enemyKilled += 1;
                        oldField = 'X';
                    }
                    if (oldField == '?') {
                        InventoryObject chestItem = null;
                        if (hero instanceof Warior) {
                            chestItem = new Weapon("Excalibur", 1, 1, 40);
                        } else {
                            chestItem = new Food("Bread", 0.5, 1, 10);
                        }
                        hero.addToInventory(chestItem);
                        oldField = ']';
                    }
                } catch (GameOverException | NoEmptySlotException e) {
                    System.out.println("Game over");
                    break;
                }
                System.out.println("Hero: " + hero.getName() + " a " + hero.getRace());
                if (hero instanceof Warior && ((Warior) hero).getWeapon() != null) {
                    int damage = hero.getDamage() + ((Warior) hero).getWeapon().getDamagePoints();
                    System.out.println("Hp: " + hero.getCurrentHealth() + " att: " + damage);
                } else System.out.println("Hp: " + hero.getCurrentHealth() + " att: " + hero.getDamage());
                System.out.println("Enemy killed: " + enemyKilled);
            }

        }

    private static void eat() throws InvalidTypeException {
        System.out.println("podaj numer slotu z jedzeniem: ");
        int slotNr = new Scanner(System.in).nextInt();
        hero.eatFood(slotNr);
    }

    private static void init() {
        map = FileService.mapLoad();
        heroPos = findChar('H');
        finishPos = findChar('F');
        HeroRepository heroRepository = new HeroRepository();
        do {
            heroRepository.showHeroes();
            System.out.println("write hero name: ");
            String name = new Scanner(System.in).nextLine();
            String cap = name.substring(0, 1).toUpperCase() + name.substring(1);
            hero = heroRepository.getHeroes().get(cap);
        } while (hero == null);
        showHints();
    }

    private static void move(String move) {
        map[heroPos.getY()][heroPos.getX()] = oldField;
        if (move.equals("W") && heroPos.getY() - 1 >= 0) {
            heroPos.setY(-1);
        }
        if (move.equals("S") && heroPos.getY() + 1 < map.length) {
            heroPos.setY(1);
        }
        if (move.equals("A") && heroPos.getX() - 1 >= 0) {
            heroPos.setX(-1);
        }
        if (move.equals("D") && heroPos.getX() + 1 < map[0].length) {
            heroPos.setX(1);
        }
        oldField = map[heroPos.getY()][heroPos.getX()];
        map[heroPos.getY()][heroPos.getX()] = 'H';
        // used to help set up field cooperation
        //System.out.println("go to x: " + heroPos.getX() +" y: "+ heroPos.getY());
    }

    private static Enemy getDefoultEnemy() {
        Raider enemy = new Raider("Andrzej", 60, 10);
        enemy.setWeapon(new Weapon("Miecz", 2, 1, 20));
        return enemy;
    }

    private static void showMap() {
        for (int i = 0; i < map.length; i++) {
            System.out.println();
            for (int j = 0; j < map[i].length; j++) {
                colourFont(map[i][j]);
            }
        }
    }

    public static void colourFont(char mapChar) {
        if (mapChar == '~') {
            System.out.print(ANSI_BLUE + mapChar + ANSI_RESET);
        } else if (mapChar == 'E') {
            System.out.print(ANSI_RED + mapChar + ANSI_RESET);
        } else if (mapChar == '?') {
            System.out.print(ANSI_YELLOW + mapChar + ANSI_RESET);
        } else if (mapChar == '_') {
            System.out.print(ANSI_GREEN + mapChar + ANSI_RESET);
        } else if (mapChar == '[') {
            System.out.print(ANSI_PURPLE + mapChar + ANSI_RESET);
        } else if (mapChar == 'F') {
            System.out.print(ANSI_CYAN + mapChar + ANSI_RESET);
        } else if (mapChar == '.') {
            System.out.print(GREEN_BRIGHT + mapChar + ANSI_RESET);
        } else if (mapChar == '#') {
            System.out.print(BLACK_BOLD + mapChar + ANSI_RESET);
        } else System.out.print(mapChar);
    }

    public static void showHints() {
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

    private static Positions findChar(char toFind) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == toFind) {
                    return new Positions(j, i);
                }
            }
        }
        return null;
    }
}
