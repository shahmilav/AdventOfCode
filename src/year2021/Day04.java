package year2021;

import helpers.FileManager;
import helpers.Stopwatch;

import java.util.Scanner;

public class Day04 {
    public static void main(String[] args) {

        FileManager manager = new FileManager(2021, 4);
        Stopwatch s = new Stopwatch();

        s.start();
        int partOne = partOne(manager.generateScanner());
        s.stop();
        System.out.println("Part 1: " + partOne + " (" + s.getElapsedTime() + " ms)");
        s.reset();

        //        s.start();
        //        int partTwo = partTwo(manager.generateScanner());
        //        s.stop();
        //        System.out.println("Part 2: " + partTwo + " (" + s.getElapsedTime() + " ms)");
    }

    private static int partOne(Scanner myReader) {
        String s = myReader.nextLine();
        String[] numbers = s.split(",");
        int counter = 0;
        int prevCounter = counter;
        int fin = 0;

        main:
        while (myReader.hasNextLine()) {
            int[][] board = new int[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.println("I=" + i + ", J=" + j);
                    s = myReader.nextLine();
                    System.out.println(s.isEmpty() + " <" + s + ">");
                    if (s.equals("")) continue main;
                    else {
                        String[] a = s.split(" ");
                        System.out.println();
                        String m = a[j].replace(" ", "");
                        System.out.println("m " + m + ", a[j] " + a[j]);

                        board[i][j] = Integer.parseInt(m);
                    }
                }
            }

            loop:
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    for (String number : numbers) {
                        counter++;

                        if (Integer.parseInt(number) == board[i][j]) {
                            board[i][j] = -1;

                            if (board[i][0] == board[i][1]
                                    && board[i][1] == board[i][2]
                                    && board[i][1] == board[i][3]
                                    && board[i][1] == board[i][4]
                                    && board[i][1] == -1) {
                                break loop;
                            }

                            if (board[0][j] == board[1][j]
                                    && board[1][j] == board[2][j]
                                    && board[1][j] == board[i][3]
                                    && board[1][j] == board[4][j]
                                    && board[1][j] == -1) {
                                break loop;
                            }
                        }
                    }
                }
            }

            if (counter <= prevCounter) fin = counter;

            counter = 0;
        }
        return fin;
    }
}
