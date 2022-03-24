import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gameplay {

List<Player> playerList = new ArrayList<>();

 Player player1 = create().setParameters();
 Player player2 = create().setParameters();

Player create() {
 return new Player();
}

void listFill() {
 playerList.add(player1);
 playerList.add(player2);
}


 public Player getPlayer1() {
  return player1;
 }

 public Player getPlayer2() {
  return player2;
 }

}
