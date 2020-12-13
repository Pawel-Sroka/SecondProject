package com.sda.serwice;

public class Game {
    private static char map[][];
    public static void main(String[] args) {
        init();
    }
    private static void init(){
        map = FileService.mapLoad();
    }
}
