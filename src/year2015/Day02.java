package year2015;

import helpers.FileManager;
import helpers.Stopwatch;

import java.util.Arrays;
import java.util.Scanner;

public class Day02 {
    public static void main(String[] args) {
        FileManager manager = new FileManager(2015, 2);
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
        int amountOfWrappingPaper = 0;
        while (myReader.hasNextLine()) {
            int[] dimensions = generateDimensions(myReader);

            amountOfWrappingPaper += 2 * dimensions[0] * dimensions[1];
            amountOfWrappingPaper += 2 * dimensions[1] * dimensions[2];
            amountOfWrappingPaper += 2 * dimensions[0] * dimensions[2];
            amountOfWrappingPaper += dimensions[0] * dimensions[1];
        }
        return amountOfWrappingPaper;
    }

    private static int partTwo(Scanner myReader) {
        int ribbon = 0;
        while (myReader.hasNextLine()) {
            int[] dimensions = generateDimensions(myReader);

            ribbon +=
                    (2 * dimensions[0])
                            + (2 * dimensions[1])
                            + (dimensions[0] * dimensions[1] * dimensions[2]);
        }
        return ribbon;
    }

    private static int[] generateDimensions(Scanner myReader) {
        String[] dimensionsStr = myReader.nextLine().split("x");
        int[] dimensions = new int[3];
        dimensions[0] = Integer.parseInt(dimensionsStr[0]);
        dimensions[1] = Integer.parseInt(dimensionsStr[1]);
        dimensions[2] = Integer.parseInt(dimensionsStr[2]);

        Arrays.sort(dimensions);
        return dimensions;
    }
}
