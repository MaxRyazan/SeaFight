package ru.maxruazan.SeaFight;

import java.util.Objects;
import java.util.Scanner;

public class Map {

 public String[][] map = new String[TestMain.ROW][TestMain.COL];

    public static int enterMapSize() {
        while ( true ) {
            System.out.println("Введите размерность поля:");
            int size = new Scanner(System.in).nextInt();
            if (size > 5) {
                return size;
            }
            else {
                System.out.println("Карта должна быть больше 5 клеток.");
            }
        }
    }

    public void initializeMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = " ";
            }
        }
    }

    public String[][] getMap() {
        return map;
    }


    public boolean isEmpty(int i, int j) {
        return Objects.equals(map[i][j], " ");
    }
    public String getSymbol(int i, int j){
        return map[i][j];
    }

    public void setSymbol(int i, int j, String symbol){
         map[i][j] = symbol;
    }

}
