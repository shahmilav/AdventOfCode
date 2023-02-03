package year2022;

import helpers.AoCSolver;
import helpers.Point;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day14 extends AoCSolver {

    public Day14(int year, String day) {
        super(year, day);
    }

    public static void main(String[] args) {
        new Day14(2022, "14");
    }

    @Override
    public void solvePartOne(List<String> input) {
        Map<Point, Integer> map = new HashMap<>();
        int highestRow = 0;
        for (String s : input) {
            String[] parts = s.split(" -> ");
            for (int i = 1; i < parts.length; i++) {
                String[] startCords = parts[i - 1].split(",");
                String[] endCords = parts[i].split(",");
                int startCol = Integer.parseInt(startCords[0]);
                int startRow = Integer.parseInt(startCords[1]);
                int endCol = Integer.parseInt(endCords[0]);
                int endRow = Integer.parseInt(endCords[1]);

                if (startCol != endCol) {
                    for (int j = Math.min(startCol, endCol); j <= Math.max(startCol, endCol); j++)
                        map.put(new Point(startRow, j), 1);
                } else {
                    for (int j = Math.min(startRow, endRow); j <= Math.max(startRow, endRow); j++)
                        map.put(new Point(j, startCol), 1);
                }

                if (endRow > highestRow) highestRow = endRow;
                if (startRow > highestRow) highestRow = startRow;
            }
        }

        int sand = 0;
        boolean fallingIntoAbyss = false;
        boolean canFall = true;
        while (canFall) {
            Point sandPoint = new Point(0, 500);
            boolean resting = false;
            while (!resting) {
                Point below = new Point(sandPoint.row() + 1, sandPoint.col());
                if (below.row() == (highestRow + 2)) {
                    fallingIntoAbyss = true;
                    resting = true;
                    map.put(sandPoint, 2);
                    continue;
                }
                if (map.containsKey(below)) {
                    Point belowLeft = new Point(sandPoint.row() + 1, sandPoint.col() - 1);
                    if (!map.containsKey(belowLeft)) {
                        sandPoint = belowLeft;
                        continue;
                    }

                    Point belowRight = new Point(sandPoint.row() + 1, sandPoint.col() + 1);
                    if (!map.containsKey(belowRight)) {
                        sandPoint = belowRight;
                        continue;
                    }

                    if (sandPoint.row() == 0 && sandPoint.col() == 500) {
                        canFall = false;
                        break;
                    }

                    resting = true;
                    map.put(sandPoint, 2);
                    if (!fallingIntoAbyss) sand++;
                } else {
                    sandPoint = below;
                }
            }
        }

        lap(sand);
    }

    @Override
    public void solvePartTwo(List<String> input) {
        Map<Point, Integer> map = new HashMap<>();
        int highestRow = 0;
        for (String s : input) {
            String[] parts = s.split(" -> ");
            for (int i = 1; i < parts.length; i++) {
                String[] startCords = parts[i - 1].split(",");
                String[] endCords = parts[i].split(",");
                int startCol = Integer.parseInt(startCords[0]);
                int startRow = Integer.parseInt(startCords[1]);
                int endCol = Integer.parseInt(endCords[0]);
                int endRow = Integer.parseInt(endCords[1]);

                if (startCol != endCol) {
                    for (int j = Math.min(startCol, endCol); j <= Math.max(startCol, endCol); j++)
                        map.put(new Point(startRow, j), 1);
                } else {
                    for (int j = Math.min(startRow, endRow); j <= Math.max(startRow, endRow); j++)
                        map.put(new Point(j, startCol), 1);
                }

                if (endRow > highestRow) highestRow = endRow;
                if (startRow > highestRow) highestRow = startRow;
            }
        }

        int sand = 0;
        boolean canFall = true;
        while (canFall) {
            Point sandPoint = new Point(0, 500);
            boolean resting = false;
            while (!resting) {
                Point below = new Point(sandPoint.row() + 1, sandPoint.col());
                if (below.row() == (highestRow + 2)) {
                    resting = true;
                    map.put(sandPoint, 2);
                    sand++;
                    continue;
                }
                if (map.containsKey(below)) {
                    Point belowLeft = new Point(sandPoint.row() + 1, sandPoint.col() - 1);
                    if (!map.containsKey(belowLeft)) {
                        sandPoint = belowLeft;
                        continue;
                    }

                    Point belowRight = new Point(sandPoint.row() + 1, sandPoint.col() + 1);
                    if (!map.containsKey(belowRight)) {
                        sandPoint = belowRight;
                        continue;
                    }

                    if (sandPoint.row() == 0 && sandPoint.col() == 500) {
                        sand++;
                        canFall = false;
                        break;
                    }

                    resting = true;
                    map.put(sandPoint, 2);

                    sand++;
                } else {
                    sandPoint = below;
                }
            }
        }

        lap(sand);
    }
}
