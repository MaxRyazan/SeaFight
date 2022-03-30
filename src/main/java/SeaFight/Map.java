package SeaFight;

import java.util.Objects;
import java.util.Scanner;

public class Map {

 public String[][] map = new String[TestMain.ROW][TestMain.COL];

    public static int enterMapSize() {
        System.out.println("Введите размерность поля:");
        return new Scanner(System.in).nextInt();
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

    public void setMissSymbol(int i, int j) {
        map[i][j] = "-";
    }
    public void setTrueShotSymbol(int i, int j) {
        map[i][j] = "!";
    }

    public String getSymbol(int i, int j){
        return map[i][j];
    }

    public void setSymbol(int i, int j, String symbol){
         map[i][j] = symbol;
    }

}
