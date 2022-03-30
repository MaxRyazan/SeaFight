package SeaFight;

public class Game {

    private Map map;
    private Gameplay gameplay;
    private Printer printer;
    private WinCheck winCheck;
    private Ships ships;


    public Game(final Map map, final Gameplay gameplay, final Printer printer, final WinCheck winCheck, final Ships ships) {
        this.map = map;
        this.gameplay = gameplay;
        this.printer = printer;
        this.winCheck = winCheck;
        this.ships = ships;
    }

    void play() {
        gameplay.fillListOfPlayers();
        for(Player thisPlayer :gameplay.playerList) {
            gameplay.checkMapSizeAndCreateShips(thisPlayer);
            gameplay.shipsLocalization(thisPlayer);
        }

        while (true) {
            printer.refreshMaps(gameplay.player1.getPlayerMap(), gameplay.player2.getPlayerMap());
            gameplay.player1.shot(gameplay.player1);
            if(winCheck.check(gameplay)) {
                break;
            }
            printer.refreshMaps(gameplay.player1.getPlayerMap(), gameplay.player2.getPlayerMap());
            gameplay.player2.shot(gameplay.player2);
            if(winCheck.check(gameplay)) {
                break;
            }
            printer.refreshMaps(gameplay.player1.getPlayerMap(), gameplay.player2.getPlayerMap());



        }
    }

}
