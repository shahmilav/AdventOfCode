package year2019;

import helpers.FileManager;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day01 {
    public static void main(String[] args) throws FileNotFoundException {
        FileManager manager = new FileManager(2019, 1);

        Scanner myReader = manager.generateScanner();
        System.out.println(partOne(myReader));

        myReader = manager.generateScanner();
        System.out.println(partTwo(myReader));
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
