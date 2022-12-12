package year2022;

import helpers.AoCSolver;

import java.util.ArrayList;
import java.util.List;

public class Day10 extends AoCSolver {
    public Day10(String year, String day) {
        super(year, day);
    }

    public static void main(String[] args) {
        new Day10("2022", "10");
    }

    private static int signalStrength(int cycle, int x) {
        if (((cycle + 20) % 40) == 0) {
            return cycle * x;
        }
        return 0;
    }

    private static String getPixel(long cycle, long x) {
        long i = (cycle - 1) % 40;
        if (List.of(x - 1, x, x + 1).contains(i)) {
            if (i == 0) {
                return "\n" + "#";
            }
            return "" + "#";
        }
        if (i == 0) {
            return "\n" + ".";
        }
        return "" + ".";
    }

    @Override
    public void solvePartOne(List<String> input) {
        int cycle = 1, X = 1;
        List<Integer> list = new ArrayList<>();

        for (String s : input) {

            list.add(signalStrength(cycle, X));

            String[] instruction = s.split(" ");

            if (instruction[0].equals("noop")) {
                cycle++;
            } else if (instruction[0].equals("addx")) {
                long a = Integer.parseInt(instruction[1]);
                cycle++;
                list.add(signalStrength(cycle, X));
                cycle++;
                X += a;
            }
        }

        int sum = 0;
        for (Integer aLong : list) {
            sum += aLong;
        }
        lap(sum);
    }

    @Override
    public void solvePartTwo(List<String> input) {
        long cycle = 1, X = 1;
        List<String> list = new ArrayList<>();

        for (String value : input) {

            list.add(getPixel(cycle, X));

            String[] instruction = value.split(" ");

            if (instruction[0].equals("noop")) {
                cycle++;
            } else if (instruction[0].equals("addx")) {
                long a = Integer.parseInt(instruction[1]);
                cycle++;
                list.add(getPixel(cycle, X));
                cycle++;
                X += a;
            }
        }

        StringBuilder m = new StringBuilder();
        for (String s : list) {
            m.append(s);
        }

        lap(m.toString());
    }
}
