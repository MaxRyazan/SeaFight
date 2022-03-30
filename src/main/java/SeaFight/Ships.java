package SeaFight;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ships {

    Gameplay gameplay;
    boolean isRandom;


    public List<String> createShipCoordinate(int capacity, List<String> list) {
        System.out.println("*********");

        System.out.println("*********");
        if (!isRandom && !gameplay.player1.isComputerPlayer() && !gameplay.player2.isComputerPlayer()) {
            for (int i = 0; i < capacity; i++) {
                System.out.print("Введите координату корабля: ");
                String row = new Scanner(System.in).nextLine();
                String col = new Scanner(System.in).nextLine();
                list.add(row + " " + col);
            }
        } else {
            if (isRandom || gameplay.player1.isComputerPlayer() || gameplay.player2.isComputerPlayer()) {
                Random random = new Random();
                for (int i = 0; i < capacity; i++) {
                    String row = Integer.toString(random.nextInt(TestMain.ROW));
                    String col = Integer.toString(random.nextInt(TestMain.ROW));
                    list.add(row + " " + col);
                }
            }
        }
        return list;
    }

}
