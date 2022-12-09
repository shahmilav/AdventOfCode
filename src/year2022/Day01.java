package year2022;

import helpers.FileManager;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Day01 {

    public static void main(String[] args) throws IOException {
        FileManager manager = new FileManager(2022, 1);

        Scanner myReader = manager.generateScanner();
        System.out.println(partOne(myReader));

        myReader = manager.generateScanner();
        System.out.println(partTwo(myReader));
    }

    private static int partOne(Scanner myReader) {
        int[] cals = readCals(myReader);
        return cals[249];
    }

    private static int partTwo(Scanner myReader) {
        int[] cals = readCals(myReader);
        return cals[cals.length - 1] + cals[cals.length - 2] + cals[cals.length - 3];
    }

    private static int[] readCals(Scanner myReader) {
        int[] cals = new int[250];

        for (int i = 1; i < cals.length; i++) {
            String s = myReader.nextLine();
            while (!s.isEmpty()) {
                cals[i] += Integer.parseInt(s);
                s = myReader.nextLine();
            }
        }
        Arrays.sort(cals);
        return cals;
    }
}
