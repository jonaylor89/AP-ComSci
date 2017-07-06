package TextAdventureGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TextAdventure {

    private static Scanner userInput = new Scanner(System.in);
    private static Random rn = new Random();

    public static void main(String[] argv) {

        int numOfBadGuys = 5;

        ArrayList<Character> BadArray = new ArrayList<>();

        MainCharacter player = new MainCharacter();

        for (int i = 0; i < numOfBadGuys; i++) {

            int r1 = rn.nextInt(4) + 1;
            int r2 = rn.nextInt(2) + 1;
            BadArray.add(new Character(r1, r2));

        }

        System.out.println("Controls: w,a,s,d");
        System.out.println("Map: m");
        System.out.println("Room Number: r");
        System.out.println("Kill Enemy: k");
        System.out.println("Quit: q");


        System.out.println("\n\nYou are now in room1.\n\n");

        for (Character b : BadArray)
            if (player.lookAround(b)) {
                System.out.println("There is a bad guy in your room");
            }


        while (true) {

            String control = userInput.next();

            if ((control.equals("w")) && (player.y < 2)) {
                player.moveUp();
                for (Character b : BadArray) {
                    if (player.lookAround(b)) {
                        System.out.println("There is a bad guy in your room");
                    }
                }
            } else if (control.equals("w") && (player.y >= 2)) {
                System.out.println("You can't go up anymore");
            } else if (control.equals("a") && (player.x > 1)) {
                player.moveLeft();
                for (Character b : BadArray) {
                    if (player.lookAround(b)) {
                        System.out.println("There is a bad guy in your room");
                    }
                }
            } else if (control.equals("a") && (player.x <= 1)) {
                System.out.println("You can't go over anymore");
            } else if (control.equals("s") && (player.y > 1)) {
                player.moveDown();
                for (Character b : BadArray) {
                    if (player.lookAround(b)) {
                        System.out.println("There is a bad guy in your room");
                    }
                }
            } else if (control.equals("s") && (player.y <= 1)) {
                System.out.println("You can't go down anymore");
            } else if (control.equals("d") && (player.x < 4)) {
                player.moveRight();
                for (Character b : BadArray) {
                    if (player.lookAround(b)) {
                        System.out.println("There is a bad guy in your room");
                    }
                }
            } else if (control.equals("k")) {
                int initSize = BadArray.size();
                int temp = 0;
                for (int z = BadArray.size() - 1; z >= 0; z--) {
                    if ((BadArray.get(z).x == player.x) && (BadArray.get(z).y == player.y)) {
                        BadArray.remove(BadArray.get(z));
                        System.out.println("You killed a bad guy!");
                    } else {
                        temp += 1;
                    }

                    if (temp == initSize) {
                        System.out.println("There is no one for you to kill in here.");
                    }
                }
            } else if (control.equals("d") && (player.x >= 4)) {
                System.out.println("You can't go over anymore");
            } else if (control.equals("r")) {
                System.out.println(player.getRoom());
            } else if (control.equals("p")) {
                int[] posArray = player.getRoomPos();
                System.out.println(Arrays.toString(posArray));
            } else if (control.equals("m")) {
                System.out.println("room5 \t room6 \t room7 \t room8 \n");
                System.out.println("room1 \t room2 \t room3 \t room4");
            } else if (control.equals("clear")) {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            } else if (control.equals("q")) {
                break;
            }


            if (BadArray.size() == 0) {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\nYou killed all of the bad guys!");
                break;
            }
        }

        System.out.println("Thanks for playing!");


    }

}
