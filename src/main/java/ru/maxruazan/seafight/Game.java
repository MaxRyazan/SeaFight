package ru.maxruazan.seafight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Game {

    private final Gameplay gameplay;
    private final Printer printer;
    private final WinCheck winCheck;


@Autowired
    public Game(final Gameplay gameplay, final Printer printer, final WinCheck winCheck) {
        this.gameplay = gameplay;
        this.printer = printer;
        this.winCheck = winCheck;
    }

    void play() {
        gameplay.fillListOfPlayers();
        for(Player thisPlayer :gameplay.playerList) {
            thisPlayer.createShipCoordinate();
            gameplay.shipsLocalization(thisPlayer);
        }

        while (true) {
            printer.refreshMaps(gameplay.player1.getPlayerMap(), gameplay.player2.getPlayerMap());
            gameplay.player1.shot(gameplay.player1);
            if(winCheck.check(gameplay)) {
                break;
            }
            printer.refreshMaps(gameplay.player1.getPlayerMap(), gameplay.player2.getPlayerMap());
            gameplay.player2.shot(gameplay.player2);
            if(winCheck.check(gameplay)) {
                break;
            }
            printer.refreshMaps(gameplay.player1.getPlayerMap(), gameplay.player2.getPlayerMap());

        }
    }

}
