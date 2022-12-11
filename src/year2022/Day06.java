package year2022;

import helpers.FileManager;
import helpers.Stopwatch;

import java.util.Scanner;

public class Day06 {
    public static void main(String[] args) {
        FileManager manager = new FileManager(2022, 6);
        Stopwatch s = new Stopwatch();

        s.start();
        int partOne = partOne(manager.generateScanner());
        s.stop();
        System.out.println("Part 1: " + partOne + " (" + s.getElapsedTime() + " ms)");
        s.reset();

        s.start();
        int partTwo = partTwo(manager.generateScanner());
        s.stop();
        System.out.println("Part 2: " + partTwo + " (" + s.getElapsedTime() + " ms)");
    }

    private static int partOne(Scanner myReader) {
        String s = myReader.nextLine();

        char[] dataStream = s.toCharArray();

        for (int i = 3; i < dataStream.length; i++) {
            char first = dataStream[i - 3];
            char second = dataStream[i - 2];
            char third = dataStream[i - 1];
            char fourth = dataStream[i];

            if (first != second && first != third && first != fourth) {
                if (second != third && second != fourth) {
                    if (third != fourth) {
                        return i + 1; // message index (not zero based!)
                    }
                }
            }
        }
        return 0;
    }

    public static int partTwo(Scanner myReader) {
        String s = myReader.nextLine();

        char[] dataStream = s.toCharArray();

        for (int i = 13; i < s.length(); i++) {

            char one = dataStream[i - 13];
            char two = dataStream[i - 12];
            char three = dataStream[i - 11];
            char four = dataStream[i - 10];
            char five = dataStream[i - 9];
            char six = dataStream[i - 8];
            char seven = dataStream[i - 7];
            char eight = dataStream[i - 6];
            char nine = dataStream[i - 5];
            char ten = dataStream[i - 4];
            char eleven = dataStream[i - 3];
            char twelve = dataStream[i - 2];
            char thirteen = dataStream[i - 1];
            char fourteen = dataStream[i];

            /*
            This is a horrible mess of nested if statements.
            TODO(never) try and use a for-loop here instead.
             */
            if ((one != two)
                    && (one != three)
                    && (one != four)
                    && (one != five)
                    && (one != six)
                    && (one != seven)
                    && (one != eight)
                    && (one != nine)
                    && (one != ten)
                    && (one != eleven)
                    && (one != twelve)
                    && (one != thirteen)
                    && (one != fourteen)) {
                if ((two != three)
                        && (two != four)
                        && (two != five)
                        && (two != six)
                        && (two != seven)
                        && (two != eight)
                        && (two != nine)
                        && (two != ten)
                        && (two != eleven)
                        && (two != twelve)
                        && (two != thirteen)
                        && (two != fourteen)) {
                    if ((three != four)
                            && (three != five)
                            && (three != six)
                            && (three != seven)
                            && (three != eight)
                            && (three != nine)
                            && (three != ten)
                            && (three != eleven)
                            && (three != twelve)
                            && (three != thirteen)
                            && (three != fourteen)) {
                        if ((four != five)
                                && (four != six)
                                && (four != seven)
                                && (four != eight)
                                && (four != nine)
                                && (four != ten)
                                && (four != eleven)
                                && (four != twelve)
                                && (four != thirteen)
                                && (four != fourteen)) {
                            if ((five != six)
                                    && (five != seven)
                                    && (five != eight)
                                    && (five != nine)
                                    && (five != ten)
                                    && (five != eleven)
                                    && (five != twelve)
                                    && (five != thirteen)
                                    && (five != fourteen)) {
                                if ((six != seven)
                                        && (six != eight)
                                        && (six != nine)
                                        && (six != ten)
                                        && (six != eleven)
                                        && (six != twelve)
                                        && (six != thirteen)
                                        && (six != fourteen)) {
                                    if ((seven != eight)
                                            && (seven != nine)
                                            && (seven != ten)
                                            && (seven != eleven)
                                            && (seven != twelve)
                                            && (seven != thirteen)
                                            && (seven != fourteen)) {
                                        if ((eight != nine)
                                                && (eight != ten)
                                                && (eight != eleven)
                                                && (eight != twelve)
                                                && (eight != thirteen)
                                                && (eight != fourteen)) {
                                            if ((nine != ten)
                                                    && (nine != eleven)
                                                    && (nine != twelve)
                                                    && (nine != thirteen)
                                                    && (nine != fourteen)) {
                                                if (ten != eleven
                                                        && ten != twelve
                                                        && ten != thirteen
                                                        && ten != fourteen) {
                                                    if (eleven != twelve
                                                            && eleven != thirteen
                                                            && eleven != fourteen) {
                                                        if (twelve != thirteen
                                                                && twelve != fourteen) {
                                                            if (thirteen != fourteen) {
                                                                return i + 1;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return 0;
    }
}
