
import java.util.Objects;

public class WinCheck {

    boolean check(Gameplay gameplay) {
        for (Player value : gameplay.playerList) {
            for (int i = 0; i < value.getPlayerMap().getMap().length; i++) {
                for (int j = 0; j < value.getPlayerMap().getMap().length; j++) {
                    if (Objects.equals(value.getPlayerMap().getMap()[i][j], "X")) {
                        System.out.println("Пока никто не победил");
                        return false;
                    }
                }
            }
            System.out.println("победа игрока " + value);
        }
        return true;
    }
}
