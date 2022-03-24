
import java.util.*;

public class Player {
    boolean isComputerPlayer;
    String country;
    String name;
 static    List<Player> playerList = new ArrayList<>();

    public Player(final boolean isComputerPlayer, final String country, final String name) {
        this.isComputerPlayer = isComputerPlayer;
        this.country = country;
        this.name = name;
    }

    public Player(final boolean isComputerPlayer) {
        this.isComputerPlayer = isComputerPlayer;
    }

    public Player() {
    }


    Player setParameters() {
        if (isComputerPlayer) {
            name = "выборка из какого то енама";
            country = "выборка из какого то енама";
            return new Player(true, name, country);
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
        return new Player(false, name, country);
    }

    void shot(Player player) {

        if (player.isComputerPlayer) {
            while (true) {
                Random random = new Random();
                int compRowShot = random.nextInt(TestMain.ROW);
                int compColShot = random.nextInt(TestMain.COL);

                if(Objects.equals(CompMap.compMap[compRowShot][compColShot], " ")) {
                    CompMap.compMap[compRowShot][compColShot] = "-";
                    break;
                }else {
                    if(Objects.equals(CompMap.compMap[compRowShot][compColShot], "0")) {
                        CompMap.compMap[compRowShot][compColShot] = "!";
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
                    if (Objects.equals(PlayerMap.playerMap[userRowShot][userColShot], " ")) {
                        PlayerMap.playerMap[userRowShot][userColShot] = "-";
                        break;
                    } else {
                        if (Objects.equals(PlayerMap.playerMap[userRowShot][userColShot], "0")) {
                            PlayerMap.playerMap[userRowShot][userColShot] = "!";
                            break;
                        }
                    }
                }
                else System.out.println("Вы стреляете за карту, повторите ввод координат");
            }
        }
    }

    void createPlayers() {
       Player playerOne = new Player(true).setParameters();
       Player  playerTwo = new Player(false).setParameters();
        playerList.add(playerOne);
        playerList.add(playerTwo);
        for(Player value  : playerList) {
            System.out.println(value);
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