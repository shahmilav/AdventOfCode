package year2023;

import helpers.AoCSolver;

import java.util.ArrayList;
import java.util.List;

public class Day10 extends AoCSolver {

    public Day10(int year, String day) {
        super(year, day);
    }

    public static void main(String[] args) {
        new Day10(2023, "10");
    }

    private static int n(Point currentPt, Point sp, PipeMap matrix, Point endpoint, List<Point> visited) {
        int pipesTraveled = 1;
        List<String> path = new ArrayList<>();
        while (!currentPt.equals(sp)) {
            try {
                if ((matrix.getAbove(currentPt) == endpoint && endpoint.isUpPipe(currentPt)) || (matrix.getBelow(currentPt) == endpoint && endpoint.isDownPipe(currentPt)) || (matrix.getLeft(currentPt) == endpoint && endpoint.isLeftPipe(currentPt)) || (matrix.getRight(currentPt) == endpoint && endpoint.isRightPipe(currentPt))) {
                    currentPt = sp;
                    visited.add(endpoint);
                    visited.add(sp);


                    pipesTraveled++;
                    break;
                }

            } catch (IndexOutOfBoundsException ignored) {
            }


            if (currentPt.x > 0 && (!visited.contains(matrix.getLeft(currentPt)) && matrix.getLeft(currentPt).isLeftPipe(currentPt))) {
                visited.add(currentPt);
                currentPt = matrix.getLeft(currentPt);
                pipesTraveled++;
                path.add("Left");
            } else if (currentPt.x < matrix.data.get(0).size() - 1 && (!visited.contains(matrix.getRight(currentPt)) && matrix.getRight(currentPt).isRightPipe(currentPt))) {

                currentPt = matrix.getRight(currentPt);
                pipesTraveled++;

                path.add("Right");
            } else if (currentPt.y > 0 && (!visited.contains(matrix.getAbove(currentPt)) && matrix.getAbove(currentPt).isUpPipe(currentPt))) {

                currentPt = matrix.getAbove(currentPt);
                pipesTraveled++;

                path.add("Up");
            } else {
                if (currentPt.y < matrix.data.size() - 1) {

                    currentPt = matrix.getBelow(currentPt);
                    pipesTraveled++;

                    path.add("Down");
                }

            }

            visited.add(currentPt);


        }

        System.out.println(path);


        return pipesTraveled;
    }

    @Override
    public void solvePartOne(List<String> input) {
        List<List<Point>> md = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            md.add(new ArrayList<>());
            for (int j = 0; j < input.get(i).split("").length; j++) {
                String val = input.get(i).split("")[j];
                md.get(i).add(new Point(j, i, val));

            }
        }
        PipeMap matrix = new PipeMap(md);
        Point sp = new Point();
        Point enterA = new Point();
        Point enterB = new Point();
        List<Point> visited = new ArrayList<>();
        i:
        for (int i = 0; i < matrix.data.size(); i++) {
            for (int j = 0; j < matrix.data.get(i).size(); j++) {
                if (matrix.data.get(i).get(j).value.equals("S")) {
                    sp = matrix.data.get(i).get(j);
                    for (int k = 0; k < 4; k++) {
                        if (sp.x > 0 && matrix.getLeft(sp).isLeftPipe(sp)) {
                            enterA = matrix.getLeft(sp);
                        } else if (sp.x < matrix.data.get(0).size() - 1 && matrix.getRight(sp).isRightPipe(sp)) {
                            enterA = matrix.getRight(sp);
                        } else if (sp.y > 0 && matrix.getAbove(sp).isUpPipe(sp)) {
                            enterA = matrix.getAbove(sp);
                        } else {
                            if (sp.y < matrix.data.size() - 1) enterA = matrix.getBelow(sp);
                        }

                        if (sp.x > 0 && matrix.getLeft(sp).isLeftPipe(sp) && enterA != matrix.getLeft(sp)) {
                            enterB = matrix.getLeft(sp);
                        } else if (sp.x < matrix.data.get(0).size() - 1 && matrix.getRight(sp).isRightPipe(sp) && enterA != matrix.getRight(sp)) {
                            enterB = matrix.getRight(sp);
                        } else if (sp.y > 0 && matrix.getAbove(sp).isUpPipe(sp) && enterA != matrix.getAbove(sp)) {
                            enterB = matrix.getAbove(sp);
                        } else {
                            if (sp.y < matrix.data.size() - 1) enterB = matrix.getBelow(sp);
                        }

                        enterA.distance = 1;

                    }
                    break i;
                }
            }
        }

        visited.add(enterA);
        int trav = n(enterA, sp, matrix, enterB, visited);

        lap((trav / 2) + 1);
    }

    @Override
    public void solvePartTwo(List<String> input) {


    }

    static class PipeMap {
        List<List<Point>> data;

        public PipeMap(List<List<Point>> data) {
            this.data = data;
        }

        public Point getBelow(Point point) {
            return data.get(point.y + 1).get(point.x);
        }

        public Point getAbove(Point point) {

            return data.get(point.y - 1).get(point.x);
        }

        public Point getLeft(Point point) {
            return data.get(point.y).get(point.x - 1);
        }

        public Point getRight(Point point) {
            return data.get(point.y).get(point.x + 1);
        }

    }

    static class Point {
        private int x;
        private int y;

        private int distance;

        private String value;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        public Point(int x, int y, String value, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.value = value;
        }

        public Point(int x, int y, String value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        public Point() {

        }


        @Override
        public String toString() {
            return distance + " (" + x + ", " + y + ") = " + value;
        }

        public boolean isEqual(Point b) {
            return this.x == b.x && this.y == b.y && this.distance == b.distance;
        }

        public boolean isUpPipe(Point mp) {
            String v = this.value;
            if (mp.value.equals("-") || mp.value.equals("F") || mp.value.equals("7")) return false;
            return (v.equals("|") || v.equals("F") || v.equals("7"));
        }

        public boolean isDownPipe(Point mp) {

            String v = this.value;
            if (mp.value.equals("-") || mp.value.equals("J") || mp.value.equals("L")) {
                return false;
            }
            return (v.equals("|") || v.equals("J") || v.equals("L"));

        }

        public boolean isLeftPipe(Point mp) {
            String v = this.value;
            if (mp.value.equals("|") || mp.value.equals("L") || mp.value.equals("F")) return false;
            return (v.equals("-") || v.equals("L") || v.equals("F"));
        }

        public boolean isRightPipe(Point mp) {
            String v = this.value;
            if (mp.value.equals("|") || mp.value.equals("J") || mp.value.equals("7")) return false;

            return (v.equals("-") || v.equals("J") || v.equals("7"));
        }


    }


}
