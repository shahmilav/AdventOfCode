package year2020;

import helpers.AoCSolver;

import java.util.List;

public class Day03 extends AoCSolver {

    public Day03(String year, String day) {
        super(year, day);
    }

    public static void main(String[] args) {
        new Day03("2020", "03");
    }

    @Override
    public void solvePartOne(List<String> input) {
        int trees = 0;
        int index = 0;
        for (String s : input) {
            StringBuilder sB = new StringBuilder(s);
            while (index >= sB.length()) {
                sB.append(s);
            }
            if (sB.charAt(index) == '#') {
                trees++;
            }
            index += 3;
        }
        lap(trees);
    }

    @Override
    public void solvePartTwo(List<String> input) {
        long prod = 1;

        int trees = 0;
        int index = 0;
        for (String s : input) {
            StringBuilder sB = new StringBuilder(s);
            while (index >= sB.length()) {
                sB.append(s);
            }
            if (sB.charAt(index) == '#') {
                trees++;
            }
            index += 3;
        }
        prod *= trees;

        trees = 0;
        index = 0;
        for (String s : input) {
            StringBuilder sB = new StringBuilder(s);
            while (index >= sB.length()) {
                sB.append(s);
            }
            if (sB.charAt(index) == '#') {
                trees++;
            }
            index++;
        }

        prod *= trees;

        trees = 0;
        index = 0;
        for (String s : input) {
            StringBuilder sB = new StringBuilder(s);
            while (index >= sB.length()) {
                sB.append(s);
            }
            if (sB.charAt(index) == '#') {
                trees++;
            }
            index += 5;
        }

        prod *= trees;

        trees = 0;
        index = 0;
        for (String s : input) {
            StringBuilder sB = new StringBuilder(s);
            while (index >= sB.length()) {
                sB.append(s);
            }
            if (sB.charAt(index) == '#') {
                trees++;
            }
            index += 7;
        }

        prod *= trees;

        trees = 0;
        index = 0;
        for (int i = 0; i < input.size(); i++) {
            String s = input.get(i);
            StringBuilder sB = new StringBuilder(s);
            while (index >= sB.length()) {
                sB.append(s);
            }
            if (sB.charAt(index) == '#') {
                trees++;
            }
            index += 1;
            i++;
        }

        prod *= trees;

        lap(prod);
    }
}
