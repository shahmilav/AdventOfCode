package year2022;

import helpers.AoCSolver;
import helpers.Point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day12 extends AoCSolver {
    public static final Map<Point, Integer> map = new HashMap<>();
    public static int WIDTH;
    public static int HEIGHT;

    public Day12(int year, String day) {
        super(year, day);
    }

    public static void main(String[] args) {
        new Day12(2022, "12");
    }

    /**
     * Solves the problem. Reused for both parts.
     *
     * @param input the input list
     * @param part true if it is part one, false for part two.
     */
    public void solve(List<String> input, boolean part) {
        HEIGHT = input.size();
        WIDTH = input.get(0).length();
        Point start = null;
        Point end = null;
        for (int row = 0; row < input.size(); row++) {
            String s = input.get(row);
            for (int col = 0; col < s.length(); col++) {
                Point p = new Point(row, col);
                char c = s.charAt(col);
                if (c == 'S') {
                    start = p;
                    c = 'a';
                }
                if (c == 'E') {
                    end = p;
                    c = 'z';
                }
                map.put(p, c - 'a');
            }
        }
        assert start != null && end != null;

        flood(start, end, part);
    }

    @Override
    public void solvePartOne(List<String> input) {
        solve(input, true);
    }

    @Override
    public void solvePartTwo(List<String> input) {
        solve(input, false);
    }

    public void flood(Point start, Point end, boolean part1) {
        Map<Point, Integer> shortestPath = new HashMap<>();
        shortestPath.put(start, 0);
        List<Point> queue = new ArrayList<>();
        queue.add(start);
        while (queue.size() > 0) {
            Point p = queue.remove(0);
            if (p.row() != 0)
                checkPoint(p, new Point(p.row() - 1, p.col()), shortestPath, queue, part1);
            if (p.row() != HEIGHT - 1)
                checkPoint(p, new Point(p.row() + 1, p.col()), shortestPath, queue, part1);
            if (p.col() != 0)
                checkPoint(p, new Point(p.row(), p.col() - 1), shortestPath, queue, part1);
            if (p.col() != WIDTH - 1)
                checkPoint(p, new Point(p.row(), p.col() + 1), shortestPath, queue, part1);
        }
        lap(shortestPath.get(end));
    }

    public void checkPoint(
            Point p,
            Point dir,
            Map<Point, Integer> shortestPath,
            List<Point> queue,
            boolean part1) {
        int gridHeight = map.get(dir);
        if (gridHeight - map.get(p) <= 1) {
            int pathLen = shortestPath.get(p) + 1;
            if (shortestPath.getOrDefault(dir, Integer.MAX_VALUE) > pathLen) {
                queue.add(dir);
                if (!part1 && gridHeight == 0) {
                    shortestPath.put(dir, 0);
                } else {
                    shortestPath.put(dir, pathLen);
                }
            }
        }
    }
}
