package year2022;

import helpers.AoCSolver;
import helpers.Point;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day09 extends AoCSolver {

    public Day09(int year, String day) {
        super(year, day);
    }

    public static void main(String[] args) {
        new Day09(2022, "09");
    }


    private static int getVisitedPoints(List<String> input, Set<Point> visited, List<Point> snake) {
        visited.add(snake.get(snake.size() - 1));

        for (String s : input) {

            String[] parts = s.split(" ");

            Direction dir;
            switch (parts[0]) {
                case "U" -> dir = Direction.UP;

                case "D" -> dir = Direction.DOWN;
                case "L" -> dir = Direction.LEFT;
                default -> dir = Direction.RIGHT;
            }

            for (int i = 0; i < Integer.parseInt(parts[1]); i++) {
                moveSnake(dir, snake, visited);
            }
        }
        return visited.size();
    }

    private static void moveSnake(Direction dir, List<Point> snake, Set<Point> visited) {
        Point head = snake.get(0);
        head = dir.movePointInDir(head);
        snake.set(0, head);
        for (int j = 1; j < snake.size(); j++) {
            head = snake.get(j - 1);
            Point tail = snake.get(j);
            int rowDifference = Math.abs(head.row() - tail.row());
            int columnDifference = Math.abs(head.col() - tail.col());
            if (rowDifference > columnDifference) {
                if (head.row() - tail.row() > 1) tail = new Point(tail.row() + 1, head.col());
                if (tail.row() - head.row() > 1) tail = new Point(tail.row() - 1, head.col());
            } else if (rowDifference < columnDifference) {
                if (head.col() - tail.col() > 1) tail = new Point(head.row(), tail.col() + 1);
                if (tail.col() - head.col() > 1) tail = new Point(head.row(), tail.col() - 1);
            } else if (rowDifference > 1) {
                if (head.row() - tail.row() > 1) tail = new Point(tail.row() + 1, tail.col());
                if (tail.row() - head.row() > 1) tail = new Point(tail.row() - 1, tail.col());
                if (head.col() - tail.col() > 1) tail = new Point(tail.row(), tail.col() + 1);
                if (tail.col() - head.col() > 1) tail = new Point(tail.row(), tail.col() - 1);
            }

            snake.set(j, tail);
            if (j == snake.size() - 1) visited.add(tail);
        }
    }

    @Override
    public void solvePartOne(List<String> input) {

        Set<Point> visited = new HashSet<>();

        List<Point> snake = new ArrayList<>();
        snake.add(new Point(0, 0));
        snake.add(new Point(0, 0));

        lap(getVisitedPoints(input, visited, snake));
    }

    @Override
    public void solvePartTwo(List<String> input) {
        Set<Point> visited = new HashSet<>();
        List<Point> snake = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            snake.add(new Point(0, 0));
        }

        lap(getVisitedPoints(input, visited, snake));
    }

    private enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;

        public Point movePointInDir(Point p) {
            Point m = null;
            switch (this) {
                case UP -> m = new Point(p.row() - 1, p.col());
                case DOWN -> m = new Point(p.row() + 1, p.col());
                case LEFT -> m = new Point(p.row(), p.col() - 1);
                case RIGHT -> m = new Point(p.row(), p.col() + 1);
            }
            return m;
        }
    }
}
