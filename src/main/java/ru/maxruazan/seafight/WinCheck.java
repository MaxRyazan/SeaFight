package ru.maxruazan.seafight;

import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
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
            System.out.println("Победа игрока " + "   " + value.getCountry() + " from " + value.getName());
            break;
        }
        return true;
    }
}


