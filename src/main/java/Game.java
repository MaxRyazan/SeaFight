public class Game {

    private Map map;
    private Gameplay gameplay;
    private Printer printer;
    private WinCheck winCheck;


    public Game(final Map map, final Gameplay gameplay, final Printer printer, final WinCheck winCheck) {
        this.map = map;
        this.gameplay = gameplay;
        this.printer = printer;
        this.winCheck = winCheck;

    }

    void play() {

        gameplay.create();
        gameplay.listFill();
        while (true) {
            printer.refreshMaps(gameplay.player1.getPlayerMap(), gameplay.player2.getPlayerMap());
            gameplay.player1.shot(gameplay.player1);
            printer.refreshMaps(gameplay.player1.getPlayerMap(), gameplay.player2.getPlayerMap());
            winCheck.check(gameplay);
            gameplay.player2.shot(gameplay.player2);
            printer.refreshMaps(gameplay.player1.getPlayerMap(), gameplay.player2.getPlayerMap());
            winCheck.check(gameplay);




            if (winCheck.check(gameplay)) {
                break;
            }
        }
    }
}
