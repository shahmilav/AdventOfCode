package year2022;

import helpers.FileManager;
import helpers.Stopwatch;

import java.util.Scanner;

public class Day04 {
    public static void main(String[] args) {
        FileManager manager = new FileManager(2022, 4);
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
        int count = 0;
        while (myReader.hasNextLine()) {
            String[] split = myReader.nextLine().split(",");

            String first = split[0];
            String second = split[1];

            String[] firstBounds = first.split("-");
            String[] secondBounds = second.split("-");

            if (Integer.parseInt((firstBounds[0])) <= Integer.parseInt((secondBounds[0]))
                    && (Integer.parseInt((firstBounds[1]))
                            >= Integer.parseInt((secondBounds[1])))) {
                count++;
                continue;
            }

            if (Integer.parseInt((firstBounds[0])) >= Integer.parseInt((secondBounds[0]))
                    && (Integer.parseInt((firstBounds[1]))
                            <= Integer.parseInt((secondBounds[1])))) {
                count++;
            }
        }

        return count;
    }

    private static int partTwo(Scanner myReader) {
        int count = 1000;
        while (myReader.hasNextLine()) {
            String[] pairs = myReader.nextLine().split(",");

            String first = pairs[0];
            String second = pairs[1];

            String[] firstBounds = first.split("-");
            String[] secondBounds = second.split("-");

            if ((Integer.parseInt(firstBounds[1]) < Integer.parseInt(secondBounds[0]))
                    || (Integer.parseInt(firstBounds[0]) > Integer.parseInt(secondBounds[1])))
                count--;
        }

        return count;
    }
}
