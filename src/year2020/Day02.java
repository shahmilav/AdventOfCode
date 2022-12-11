package year2020;

import helpers.FileManager;
import helpers.Stopwatch;

import java.util.Arrays;
import java.util.Scanner;

public class Day02 {
    public static void main(String[] args) {
        FileManager manager = new FileManager(2020, 2);
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
        int validPasswords = 0;
        while (myReader.hasNextLine()) {
            String s = myReader.nextLine();
            s = s.replace(":", "");
            String[] split = s.split(" ");

            char target = split[1].charAt(0);
            String[] bounds = split[0].split("-");
            String password = split[2];

            int numOfTargets = 0;
            for (int i = 0; i < password.length(); i++) {
                if (password.charAt(i) == target) numOfTargets++;
            }

            if ((numOfTargets <= Integer.parseInt(bounds[1]))
                    && (numOfTargets >= Integer.parseInt(bounds[0]))) {
                validPasswords++;
            }
        }
        return validPasswords;
    }

    private static int partTwo(Scanner myReader) {
        int validPasswords = 0;
        while (myReader.hasNextLine()) {
            String s = myReader.nextLine().replace(":", "");
            String[] split = s.split(" ");

            char target = split[1].charAt(0);
            String[] choices = split[0].split("-");
            String password = split[2];

            System.out.println(password);
            System.out.println(Arrays.toString(choices) + " " + target);
            System.out.println(choices[0]);
            if ((password.charAt(Integer.parseInt(choices[0]) - 1) == target)
                            && (password.charAt(Integer.parseInt(choices[1]) - 1) != target)
                    || (password.charAt(Integer.parseInt(choices[0]) - 1) != target)
                            && (password.charAt(Integer.parseInt(choices[1]) - 1) == target))
                validPasswords++;
        }

        return validPasswords;
    }
}
