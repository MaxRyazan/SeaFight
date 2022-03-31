package ru.maxruazan.SeaFight;

public class TestMain {

    public static final int ROW = Map.enterMapSize();
    public static final int COL = ROW;



    public static void main(String[] args) {

Game game = new Game(new Gameplay(), new Printer(), new WinCheck());
game.play();
    }
}
