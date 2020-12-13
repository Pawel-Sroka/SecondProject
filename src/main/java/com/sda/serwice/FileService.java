package com.sda.serwice;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class FileService {

    public static char[][] mapLoad() {
        char map[][] = new char[10][];
        try {
            final List<String> lines =
                    Files.readAllLines(Paths.get(
                            FileService.class
                                    .getClassLoader()
                                    .getResource("map.txt")
                                    .toURI()));
            for (int x=0;x< lines.size();x++){
                map[x] = lines.get(x).toCharArray();
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return map;
    }




    public void saveMap() {
    }

}
