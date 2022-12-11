package year2020;

import helpers.FileManager;
import helpers.Stopwatch;

import java.util.Scanner;

public class Day01 {
    public static void main(String[] args) {
        FileManager manager = new FileManager(2020, 1);
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

        int[] nums = new int[200];
        for (int i = 0; i < 200; i++) {
            nums[i] = myReader.nextInt();
        }

        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 200; j++) {
                if (nums[i] + nums[j] == 2020) return nums[i] * nums[j];
            }
        }

        return 0;
    }

    private static int partTwo(Scanner myReader) {

        int[] nums = new int[200];
        for (int i = 0; i < 200; i++) {
            nums[i] = myReader.nextInt();
        }

        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 200; j++) {
                for (int k = 0; k < 200; k++) {
                    if (nums[i] + nums[j] + nums[k] == 2020) return nums[i] * nums[j] * nums[k];
                }
            }
        }

        return 0;
    }
}
