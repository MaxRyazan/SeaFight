import java.util.Objects;

public class PlayerMap {

 public static  String[][] playerMap = new String[TestMain.ROW][TestMain.COL];

 public void initializePlayerMap() {
     for (int i = 0; i < playerMap.length; i++) {
         for (int j = 0; j < playerMap.length; j++) {
             playerMap[i][j] = " ";
         }
     }
 }

    public boolean isEmpty(int i, int j) {
        return Objects.equals(playerMap[i][j], " ");
    }

    public void setMissSymbol(int i, int j) {
        playerMap[i][j] = "-";
    }
    public void setTrueShotSymbol(int i, int j) {
        playerMap[i][j] = "X";
    }

    public String getSymbol(int i, int j){
        return playerMap[i][j];
    }

    public void setSymbol(int i, int j, String symbol){
         playerMap[i][j] = symbol;
    }

}
