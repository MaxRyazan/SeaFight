import java.util.Objects;

public class CompMap  {

    public static  String[][] compMap = new String[TestMain.ROW][TestMain.COL];

    public void initializeCompMap() {
        for (int i = 0; i < compMap.length; i++) {
            for (int j = 0; j < compMap.length; j++) {
                compMap[i][j] = " ";
            }
        }
    }
    public  boolean isEmpty(int i, int j) {
        return Objects.equals(compMap[i][j], " ");
    }

    public void setMissSymbol(int i, int j) {
        compMap[i][j] = "-";
    }
    public void setTrueShotSymbol(int i, int j) {
        compMap[i][j] = "X";
    }

    public String getSymbol(int i, int j){
        return compMap[i][j];
    }
    public void setSymbol(int i, int j, String symbol){
         compMap[i][j] = symbol;
    }
}
