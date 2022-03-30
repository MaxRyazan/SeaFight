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

 public void checkMapSizeAndCreateShips(Player player) {

  System.out.println("Хотите рандомно расположить корабли? +/-");
  if (new Scanner(System.in).nextLine().equals("+")) {
   ships.isRandom = true;
  }
  if (TestMain.COL <= 5) {
   System.out.println("Карта должна быть больше 5 клеток.");
  } else {
   if (TestMain.COL == 6) {
    System.out.println("Карта маленькая, вам доступно: \n0 линкоров\n2 фрегата\n3 корвета\n4 шлюпа");
    player.lineShip = new ArrayList<>(0);
    player.frigate = ships.createShipCoordinate(6, player.frigate);
    player.corvette = ships.createShipCoordinate(6, player.corvette);
    player.sloops = ships.createShipCoordinate(4, player.sloops);
   } else if (TestMain.COL >= 7 && TestMain.COL < 11) {
    System.out.println("Карта cреднего размера, вам доступно: \n1 линкор\n3 фрегата\n4 корвета\n5 шлюпа");
    player.lineShip = ships.createShipCoordinate(4, player.lineShip);
    player.frigate = ships.createShipCoordinate(9, player.frigate);
    player.corvette = ships.createShipCoordinate(8, player.corvette);
    player.sloops = ships.createShipCoordinate(5, player.sloops);
   } else if (TestMain.COL >= 11) {
    System.out.println("Карта большого размера, вам доступно: \n2 линкор\n4 фрегата\n5 корвета\n7 шлюпов");
    player.lineShip = ships.createShipCoordinate(8, player.lineShip);
    player.frigate = ships.createShipCoordinate(12, player.frigate);
    player.corvette = ships.createShipCoordinate(15, player.corvette);
    player.sloops = ships.createShipCoordinate(7, player.sloops);
   }

  }
 }


 void shipsLocalization(Player player) {

 for(String value : player.lineShip) {
  printShipsOnMap(value, player);

 }

  for(String value : player.frigate) {
   printShipsOnMap(value, player);

  }

  for(String value : player.corvette) {
   printShipsOnMap(value, player);

  }

  for(String value : player.sloops) {

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
