package ru.maxruazan.SeaFight;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Player {
  private   boolean isComputerPlayer;
  private   String country;
  private   String name;
  private final Map playerMap;

  int capacity = checkMapSizeAndNumberOfShips();


List<String> allCoordinates = createShipCoordinate();

    public List<String> getAllCoordinates() {
        return allCoordinates;
    }

    List<String> defaultNames = new ArrayList<>();
    List<String> defaultCountries = new ArrayList<>();




    public Map getPlayerMap() {
        return playerMap;
    }


    public Player(boolean isComputerPlayer, String country, String name) {
        this.isComputerPlayer = isComputerPlayer;
        this.country = country;
        this.name = name;
        this.playerMap = new Map();
        playerMap.initializeMap();
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public Player() {
        this.playerMap = new Map();
        playerMap.initializeMap();
    }

   public Player setParameters() {
        System.out.println("Этот игрок компьютер? Введите  + если ДА");
        String identify = new Scanner(System.in).nextLine();
        if (identify.equals("+")) {
            isComputerPlayer = true;
            return  new Player(true, setDefaultName(),  setDefaultCountry());
        } else {
            isComputerPlayer = false;
            do {
                System.out.print("Введите имя игрока : ");
                name = new Scanner(System.in).nextLine();
                System.out.print("Введите страну игрока : ");
                country = new Scanner(System.in).nextLine();
            } while (!name.isBlank() || !country.isBlank());
        }
       return new Player(false, name, country);
   }

    void shot(Player player) {

        if (player.isComputerPlayer) {
            while (true) {
                Random random = new Random();
                int compRowShot = random.nextInt(TestMain.ROW);
                int compColShot = random.nextInt(TestMain.COL);

                if(checkGameCell(compRowShot, compColShot, " ")) {
                    playerMap.setSymbol(compRowShot, compColShot, "-");
                    break;
                }else {
                    if(checkGameCell(compRowShot, compColShot, "X")) {
                        playerMap.setSymbol(compRowShot, compColShot, "*");
                        break;
                    }
                }
            }
        }


        if (!player.isComputerPlayer) {
            while (true) {
                System.out.println("Введите поочереди координаты строки и столбца для выстрела");
                int userRowShot = new Scanner(System.in).nextInt();
                int userColShot = new Scanner(System.in).nextInt();
                if ((userRowShot < TestMain.ROW) && (userColShot < TestMain.COL)) {
                    if (checkGameCell(userRowShot, userColShot, " ")) {
                        playerMap.setSymbol(userRowShot, userColShot,  "-");
                        break;
                    } else {
                        if (checkGameCell(userRowShot, userColShot, "X")) {
                           playerMap.setSymbol(userRowShot,userColShot, "!");
                            break;
                        }
                    }
                }
                else System.out.println("Вы стреляете за карту, повторите ввод координат");
            }
        }
    }


    public boolean checkGameCell(int row, int col, String symbol) {
        return Objects.equals(playerMap.getSymbol(row, col), symbol);
    }

    String setDefaultName() {
        defaultNames.add("JASON");
        defaultNames.add("DICK");
        defaultNames.add("MONICA");
        defaultNames.add("BILL");
        defaultNames.add("EDDY");
        defaultNames.add("BIG_DADDY");
        Random random = new Random();
        return  defaultNames.get(random.nextInt(6));
    }

    String setDefaultCountry() {
        defaultCountries.add("USA");
        defaultCountries.add("RUSSIA");
        defaultCountries.add("CANADA");
        defaultCountries.add("CHINA");
        defaultCountries.add("PARAGVAI");
        defaultCountries.add("YGANDA");
        Random random = new Random();
        return  defaultCountries.get(random.nextInt(6));
    }

    public  int  checkMapSizeAndNumberOfShips() {
        if (TestMain.COL == 6) {
            return   16;
            }
        if (TestMain.COL >= 7 && TestMain.COL < 11) {
            return   26;
        }
        if (TestMain.COL >= 11) {
            return   37;
        }
        return 0;
    }


    public List<String> createShipCoordinate() {
        List<String> listOfAllCoordinates = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < capacity; i++) {
            while (true) {
                String row = Integer.toString(random.nextInt(TestMain.ROW));
                String col = Integer.toString(random.nextInt(TestMain.ROW));
                String temp = row + " " + col;
                if (isUniq(temp, listOfAllCoordinates)) {
                    listOfAllCoordinates.add(temp);
                    break;
                }
            }
        }
        return listOfAllCoordinates;
    }

    boolean isUniq(String temp, List<String> listOfAllCoordinates) {
        for (String listOfAllCoordinate : listOfAllCoordinates) {
            if (temp.equals(listOfAllCoordinate)) {
                return false;
            }
        }
        return true;
    }


    @Override
    public String toString() {
        return
               "name='" + name + '\'' +
                ", country='" + country + '\'';
    }
}