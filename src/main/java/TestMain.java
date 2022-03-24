import java.util.Scanner;

public class TestMain {

    public static final int ROW = new Scanner(System.in).nextInt();
    public static final int COL = new Scanner(System.in).nextInt();
static Printer printer;
static CompMap compMap;
static PlayerMap playerMap;
static Player player;

    public static void main(String[] args) {

printer = new Printer();
compMap = new CompMap();
playerMap= new PlayerMap();
player = new Player();


compMap.initializeCompMap();
playerMap.initializePlayerMap();
printer.refreshMaps(playerMap, compMap);
player.createPlayers();
player.shot( Player.playerList.get(0));
printer.refreshMaps(playerMap, compMap);
player.shot( Player.playerList.get(1));
printer.refreshMaps(playerMap, compMap);
    }
}
