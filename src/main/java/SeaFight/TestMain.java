package SeaFight;

public class TestMain {

    public static final int ROW = Map.enterMapSize();
    public static final int COL = ROW;



    public static void main(String[] args) {

Game game = new Game(new Map(), new Gameplay(), new Printer(), new WinCheck(), new Ships());
game.play();
    }
}
