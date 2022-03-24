import java.util.Objects;

public class Map {

 public String[][] map = new String[TestMain.ROW][TestMain.COL];

 public void initializeMap() {
     for (int i = 0; i < map.length; i++) {
         for (int j = 0; j < map.length; j++) {
             map[i][j] = " ";
         }
     }
 }

    public boolean isEmpty(int i, int j) {
        return Objects.equals(map[i][j], " ");
    }

    public void setMissSymbol(int i, int j) {
        map[i][j] = "-";
    }
    public void setTrueShotSymbol(int i, int j) {
        map[i][j] = "X";
    }

    public String getSymbol(int i, int j){
        return map[i][j];
    }

    public void setSymbol(int i, int j, String symbol){
         map[i][j] = symbol;
    }

}
