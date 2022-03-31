package SeaFight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gameplay {
    Ships ships = new Ships();
    List<Player> playerList = new ArrayList<>();
    Player player1 = new Player().setParameters();
    Player player2 = new Player().setParameters();


    void fillListOfPlayers() {
        playerList.add(player1);
        playerList.add(player2);
    }




    void shipsLocalization(Player player) {
        for (String value : player.allCoordinates) {
            printShipsOnMap(value, player);

        }
    }

    void printShipsOnMap(String value, Player player) {
        String[] temp = value.split(" ");
        if (player.getPlayerMap().isEmpty(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]))) {
            player.getPlayerMap().setSymbol(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), "X");
        }
    }


}
