package com.sda.serwice;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class FileService {

    public static char[][] mapLoad() {
        char map[][] = new char[12][];
        try {
            final List<String> lines =
                    Files.readAllLines(Paths.get(
                            FileService.class
                                    .getClassLoader()
                                    .getResource("mapV2.txt")
                                    .toURI()));
            for (int x=0;x< lines.size();x++){
                map[x] = lines.get(x).toCharArray();
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static char[][] dungLoad(){
        char dungmap[][] = new char[10][];
        try {
            final List<String> lines =
                    Files.readAllLines(Paths.get(
                            FileService.class
                                    .getClassLoader()
                                    .getResource("dungmap.txt")
                                    .toURI()));
            for (int x=0;x< lines.size();x++){
                dungmap[x] = lines.get(x).toCharArray();
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return dungmap;
    }



    public void saveMap() {
    }

}
