package year2021;

import helpers.FileManager;

import java.util.Scanner;

public class Day01 {

    public static void main(String[] args) {
        FileManager manager = new FileManager(2021, 1);

        Scanner myReader = manager.generateScanner();
        System.out.println(partOne(myReader));

        myReader = manager.generateScanner();
        System.out.println(partTwo(myReader));
    }

    private static int partOne(Scanner myReader) {

        int[] depths = new int[2000];
        int counter = 0;
        for (int i = 0; i < depths.length; i++) {
            depths[i] = myReader.nextInt();
        }
        for (int i = 0; i < depths.length - 1; i++) {
            if (depths[i + 1] > depths[i]) counter++;
        }
        return counter;
    }

    private static int partTwo(Scanner myReader) {

        int sum = 0;
        int count = 0;
        int tempSum;

        int[] depths = new int[2000];

        for (int i = 0; i < depths.length; i++) {
            depths[i] = myReader.nextInt();
        }

        for (int i = 0; i <= 2; i++) {
            sum += depths[i];
        }

        tempSum = sum;

        for (int i = 1; i <= depths.length - 3; i++) {

            sum -= depths[i - 1];
            sum += depths[i + 2];

            if (tempSum < sum) count++;
            tempSum = sum;
        }

        return count;
    }
}
