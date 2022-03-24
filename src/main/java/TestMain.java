import java.util.Scanner;

public class TestMain {

    public static final int ROW = new Scanner(System.in).nextInt();
    public static final int COL = new Scanner(System.in).nextInt();


    public static void main(String[] args) {
Game game = new Game(new Map(), new Gameplay(), new Printer(), new WinCheck());
game.play();

    }
}
