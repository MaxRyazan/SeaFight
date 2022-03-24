import java.util.*;

public class Gameplay {
    List<Player> playerList = new ArrayList<>();

    void createPlayers() {
        Player playerOne = new Player().setParameters();
        Player  playerTwo = new Player().setParameters();
        playerList.add(playerOne);
        playerList.add(playerTwo);
        for(Player value  : playerList) {
            System.out.println(value);
        }
    }





}
