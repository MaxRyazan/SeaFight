
import java.util.*;

public class Player {
  private   boolean isComputerPlayer;
  private   String country;
  private   String name;
  private final Map playerMap;

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


    public Player() {
        this.playerMap = new Map();
        playerMap.initializeMap();
    }

    Player setParameters() {
       System.out.println("Этот игрок компьютер? Введите  + если ДА");
       String identify = new Scanner(System.in).nextLine();
       if(identify.equals("+")) {
            isComputerPlayer = true;
            name = setDefaultName() ;
            country = setDefaultCountry();
        } else {
           isComputerPlayer = false;
            while (true) {
                System.out.print("Введите имя игрока : ");
                name = new Scanner(System.in).nextLine();
                System.out.print("Введите страну игрока : ");
                country = new Scanner(System.in).nextLine();
                if(!(name.isBlank() && country.isBlank())) {
                    break;
                }
            }
        }
        return new Player(isComputerPlayer, name, country);
    }

    void shot(Player player) {

        if (player.isComputerPlayer) {
            while (true) {
                Random random = new Random();
                int compRowShot = random.nextInt(TestMain.ROW);
                int compColShot = random.nextInt(TestMain.COL);

                if(Objects.equals(playerMap.getSymbol(compRowShot,compColShot), " ")) {
                    playerMap.setSymbol(compRowShot, compColShot, "-");
                    break;
                }else {
                    if(Objects.equals(playerMap.getSymbol(compRowShot,compColShot), "X")) {
                        playerMap.setSymbol(compRowShot, compColShot, "!");
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
                    if (Objects.equals(playerMap.getSymbol(userRowShot,userColShot), " ")) {
                        playerMap.setSymbol(userRowShot, userColShot,  "-");
                        break;
                    } else {
                        if (Objects.equals(playerMap.getSymbol(userRowShot, userColShot), "X")) {
                           playerMap.setSymbol(userRowShot,userColShot, "!");
                            break;
                        }
                    }
                }
                else System.out.println("Вы стреляете за карту, повторите ввод координат");
            }
        }
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

    @Override
    public String toString() {
        return
               "name='" + name + '\'' +
                ", country='" + country + '\'';
    }
}