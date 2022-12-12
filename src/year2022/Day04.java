package year2022;

import helpers.AoCSolver;

import java.util.List;

public class Day04 extends AoCSolver {
    public Day04(String year, String day) {
        super(year, day);
    }

    public static void main(String[] args) {
        new Day04("2022", "04");
    }

    @Override
    public void solvePartOne(List<String> input) {
        int count = 0;
        for (String s : input) {
            String[] split = s.split(",");

            String first = split[0];
            String second = split[1];

            String[] firstBounds = first.split("-");
            String[] secondBounds = second.split("-");

            if (Integer.parseInt((firstBounds[0])) <= Integer.parseInt((secondBounds[0]))
                    && (Integer.parseInt((firstBounds[1]))
                            >= Integer.parseInt((secondBounds[1])))) {
                count++;
                continue;
            }

            if (Integer.parseInt((firstBounds[0])) >= Integer.parseInt((secondBounds[0]))
                    && (Integer.parseInt((firstBounds[1]))
                            <= Integer.parseInt((secondBounds[1])))) {
                count++;
            }
        }

        lap(count);
    }

    @Override
    public void solvePartTwo(List<String> input) {
        int count = 1000;
        for (String s : input) {
            String[] pairs = s.split(",");

            String first = pairs[0];
            String second = pairs[1];

            String[] firstBounds = first.split("-");
            String[] secondBounds = second.split("-");

            if ((Integer.parseInt(firstBounds[1]) < Integer.parseInt(secondBounds[0]))
                    || (Integer.parseInt(firstBounds[0]) > Integer.parseInt(secondBounds[1])))
                count--;
        }

        lap(count);
    }
}
