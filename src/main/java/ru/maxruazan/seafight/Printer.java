package ru.maxruazan.seafight;

import org.springframework.stereotype.Component;

@Component
public class Printer {


    void refreshMaps(Map playerMap, Map compMap) {
        System.out.println("                 Карта  игрока1                                        Карта игрока2    ");
        System.out.print("   | ");
        for (int i = 0; i < TestMain.COL; i++) {
            if(i < 9) {
            System.out.print(i + " | ");
        } else {
                System.out.print(i + " |");
            }
        }


        if(TestMain.COL < 10) {
            System.out.print("                       | ");
        }else {
            System.out.print("                        | ");
        }

        for (int i = 0; i < TestMain.COL; i++) {
            if (i < 9) {
                System.out.print(i + " | ");
            } else {
                System.out.print(i + " |");
            }
        }
        System.out.println();
        for (int k = 0; k < TestMain.ROW; k++) {
            if(k < 10) {
                System.out.print(k + " ");
            }else {
                System.out.print(k);
            }
            for (int i = 0; i < TestMain.COL; i++) {
                System.out.print(" | " + playerMap.getSymbol(k, i));
            }
            if(k < 10) {
                System.out.print(" |                     " + k + " ");
            }else {
                System.out.print(" |                     " + k);
            }
            for (int i = 0; i < TestMain.COL; i++) {
                System.out.print(" | " + compMap.getSymbol(k, i));
            }
            System.out.print(" |");
            System.out.println();
        }
    }
}
