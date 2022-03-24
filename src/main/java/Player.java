
import java.util.*;

public class Player {
    boolean isComputerPlayer;
    String country;
    String name;
    Map playerMap;

    public Player(boolean isComputerPlayer,  String country,  String name, Map playerMap) {
        this.isComputerPlayer = isComputerPlayer;
        this.country = country;
        this.name = name;
        this.playerMap = new Map();
        playerMap.initializeMap();
    }

    public Player() {
    }

    Player setParameters() {
        if (isComputerPlayer) {
            name = "выборка из какого то енама";
            country = "выборка из какого то енама";
            return new Player(true, name, country, playerMap);
        } else {
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
        return new Player(false, name, country, playerMap);
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
                    if(Objects.equals(playerMap.getSymbol(compRowShot,compColShot), "0")) {
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
                        if (Objects.equals(playerMap.getSymbol(userRowShot, userColShot), "0")) {
                           playerMap.setSymbol(userRowShot,userColShot, "!");
                            break;
                        }
                    }
                }
                else System.out.println("Вы стреляете за карту, повторите ввод координат");
            }
        }
    }


    @Override
    public String toString() {
        return "Player{" +
                "Играет компьютер? - " + isComputerPlayer +
                ", country='" + country + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}