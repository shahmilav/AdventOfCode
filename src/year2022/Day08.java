package year2022;

import helpers.FileManager;
import helpers.Stopwatch;

import java.util.Arrays;
import java.util.Scanner;

public class Day08 {
    public static void main(String[] args) {
        FileManager manager = new FileManager(2022, 8);
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

        int visibleTrees = 0;
        String[][] grid = new String[99][99];

        for (int i = 0; i < grid.length; i++) {
            String m = myReader.nextLine();
            String[] a = m.split("");
            grid[i] = a;
        }

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid.length; j++) {

                // These are the edges of the map.
                if (i == 0 || j == 0 || i == grid.length - 1 || j == grid.length - 1) {
                    visibleTrees++;
                    continue;
                }

                int target = Integer.parseInt(grid[i][j]);

                boolean topVisible = false;
                boolean leftVisible = false;
                boolean rightVisible = false;
                boolean bottomVisible = false;

                for (int k = 0; k < i; k++) {
                    if (Integer.parseInt(grid[k][j]) < target) topVisible = true;
                    else if (Integer.parseInt(grid[k][j]) >= target) {
                        topVisible = false;
                        break;
                    }
                }

                for (int k = grid.length - 1; k > i; k--) {
                    if (Integer.parseInt(grid[k][j]) < target) bottomVisible = true;
                    else if (Integer.parseInt(grid[k][j]) >= target) {
                        bottomVisible = false;
                        break;
                    }
                }

                for (int k = 0; k < j; k++) {
                    if (Integer.parseInt(grid[i][k]) < target) leftVisible = true;
                    else if (Integer.parseInt(grid[i][k]) >= target) {
                        leftVisible = false;
                        break;
                    }
                }

                for (int k = grid.length - 1; k > j; k--) {
                    if (Integer.parseInt(grid[i][k]) < target) rightVisible = true;
                    else if (Integer.parseInt(grid[i][k]) >= target) {
                        rightVisible = false;
                        break;
                    }
                }

                if (topVisible || leftVisible || rightVisible || bottomVisible) {
                    visibleTrees++;
                }
            }
        }

        return visibleTrees;
    }

    private static int partTwo(Scanner myReader) {
        Integer[][] grid = new Integer[99][99];

        for (int i = 0; i < grid.length; i++) {

            String line = myReader.nextLine();
            grid[i] =
                    Arrays.copyOf(
                            line.chars().map(Character::getNumericValue).boxed().toArray(),
                            grid.length,
                            Integer[].class);
        }

        int maxScenicScore = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (i != 0 && j != 0 && i != grid.length - 1 && j != grid.length - 1) {
                    int numTreesSeenUp = 0;
                    int numTreesSeenDown = 0;
                    int numTreesSeenLeft = 0;
                    int numTreesSeenRight = 0;

                    for (int k = i - 1; k >= 0; k--) {
                        numTreesSeenUp++;
                        if (grid[k][j] >= grid[i][j]) {

                            break;
                        }
                    }

                    // look down
                    for (int k = i + 1; k < grid.length; k++) {
                        numTreesSeenDown++;
                        if (grid[k][j] >= grid[i][j]) {

                            break;
                        }
                    }

                    // look left
                    for (int k = j - 1; k >= 0; k--) {
                        numTreesSeenLeft++;
                        if (grid[i][k] >= grid[i][j]) {
                            break;
                        }
                    }

                    // look right
                    for (int k = j + 1; k < grid[i].length; k++) {
                        numTreesSeenRight++;
                        if (grid[i][k] >= grid[i][j]) {
                            break;
                        }
                    }

                    int scenicScore =
                            numTreesSeenUp
                                    * numTreesSeenDown
                                    * numTreesSeenLeft
                                    * numTreesSeenRight;

                    maxScenicScore = Math.max(maxScenicScore, scenicScore);
                }
            }
        }

        return maxScenicScore;
    }
}
