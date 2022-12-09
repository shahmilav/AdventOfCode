package year2022;

import helpers.FileManager;

import java.util.Scanner;

public class Day02 {

    public static void main(String[] args) {
        FileManager manager = new FileManager(2022, 2);

        Scanner myReader = manager.generateScanner();
        System.out.println(partOne(myReader));

        myReader = manager.generateScanner();
        System.out.println(partTwo(myReader));
    }

    private static int partOne(Scanner myReader) {
        int points = 0;

        for (int i = 0; i < 2500; i++) {

            String s = myReader.nextLine();

            switch (s) {
                    // Rock = Rock (1+3)
                case "A X" -> points += 4;
                    // Rock < Paper (2+6)
                case "A Y" -> points += 8;
                    // Rock > Scissors (3+0)
                case "A Z" -> points += 3;
                    // Paper > Rock (1+0)
                case "B X" -> points += 1;
                    // Paper = Paper (2+3)
                case "B Y" -> points += 5;
                    // Paper < Scissors (3+6)
                case "B Z" -> points += 9;
                    // Scissors < Rock (1+6)
                case "C X" -> points += 7;
                    // Scissors > Paper (2+0)
                case "C Y" -> points += 2;
                    // Scissors = Scissors (3+3)
                case "C Z" -> points += 6;
            }
        }

        return points;
    }

    private static int partTwo(Scanner myReader) {
        int points = 0;

        for (int i = 0; i < 2500; i++) {

            String s = myReader.nextLine();

            switch (s.charAt(0)) {
                case 'A':
                    switch (s.charAt(2)) {
                            // need to lose
                        case 'X' -> points += 3;
                            // need to draw
                        case 'Y' -> points += 4;
                            // need to win
                        case 'Z' -> points += 8;
                    }

                    break;
                case 'B':
                    switch (s.charAt(2)) {
                            // need to lose
                        case 'X' -> points += 1;
                            // need to draw
                        case 'Y' -> points += 5;
                            // need to win
                        case 'Z' -> points += 9;
                    }

                    break;
                case 'C':
                    switch (s.charAt(2)) {
                            // need to lose
                        case 'X' -> points += 2;
                            // need to draw
                        case 'Y' -> points += 6;
                            // need to win
                        case 'Z' -> points += 7;
                    }

                    break;
            }
        }

        return points;
    }
}
