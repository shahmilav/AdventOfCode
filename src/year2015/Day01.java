package year2015;

import helpers.FileManager;

import java.util.Scanner;

public class Day01 {
    public static void main(String[] args) {
        FileManager manager = new FileManager(2015, 1);

        Scanner myReader = manager.generateScanner();
        System.out.println(partOne(myReader));

        myReader = manager.generateScanner();
        System.out.println(partTwo(myReader));
    }

    private static int partOne(Scanner myReader) {
        int floors = 0;

        String s = myReader.nextLine();
        char[] directions = s.toCharArray();

        for (char direction : directions) {
            if (direction == '(') floors++;
            else floors--;
        }

        return floors;
    }

    private static int partTwo(Scanner myReader) {
        int floors = 0;

        String s = myReader.nextLine();
        char[] directions = s.toCharArray();

        for (int i = 0; i < directions.length; i++) {
            char direction = directions[i];
            if (direction == '(') floors++;
            else floors--;

            if (floors == -1) return i + 1;
        }

        return 0;
    }
}
