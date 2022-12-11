package year2019;

import helpers.FileManager;
import helpers.Stopwatch;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day01 {
    public static void main(String[] args) throws FileNotFoundException {
        FileManager manager = new FileManager(2019, 1);
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
        int sum = 0;
        while (myReader.hasNextLine()) {
            int m = myReader.nextInt();
            int fuel = (int) Math.floor(m / 3.0) - 2;
            sum += fuel;
        }

        return sum;
    }

    private static int partTwo(Scanner myReader) {
        int sum = 0;
        while (myReader.hasNextLine()) {
            int m = myReader.nextInt();
            int fuel = (int) Math.floor(m / 3.0) - 2;
            sum += fuel;
        }

        System.out.println(sum);

        int fuel = sum;
        System.out.println(fuel);

        while (fuel >= 0) {
            System.out.println(fuel);

            fuel = (int) Math.floor(fuel / 3.0) - 2;
            if (fuel < 0) break;
            sum += fuel;
        }
        return sum;
    }
}
