package year2021;

import helpers.FileManager;
import helpers.Stopwatch;

import java.util.Scanner;

public class Day02 {
    public static void main(String[] args) {
        FileManager manager = new FileManager(2021, 2);
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

        int horizontal = 0;
        int depth = 0;

        for (int i = 0; i < 1000; i++) {
            String s = myReader.nextLine();

            String[] split = s.split(" ");

            switch (split[0].charAt(0)) {
                case ('f') -> horizontal += Integer.parseInt(split[1]);
                case ('u') -> depth -= Integer.parseInt(split[1]);
                case ('d') -> depth += Integer.parseInt(split[1]);
            }
        }

        return horizontal * depth;
    }

    private static int partTwo(Scanner myReader) {

        int horizontal = 0, depth = 0, aim = 0;

        for (int i = 0; i < 1000; i++) {
            String s = myReader.nextLine();

            String[] split = s.split(" ");

            switch (split[0].charAt(0)) {
                case ('f') -> {
                    int x = Integer.parseInt(split[1]);
                    horizontal += x;
                    depth += (aim * x);
                }
                case ('u') -> aim -= Integer.parseInt(split[1]);
                case ('d') -> aim += Integer.parseInt(split[1]);
            }
        }

        return horizontal * depth;
    }
}
