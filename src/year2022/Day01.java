package year2022;

import helpers.AoCSolver;

import java.util.ArrayList;
import java.util.List;

public class Day01 extends AoCSolver {

    public Day01(String year, String day) {
        super(year, day);
    }

    public static void main(String[] args) {
        new Day01("2022", "01");
    }

    private static List<Integer> readCals(List<String> input) {
        List<Integer> cals = new ArrayList<>();

        int index = 0;

        for (String s : input) {

            if (s.isBlank()) {
                index++;
                continue;
            }

            if (cals.size() == index) {
                cals.add(0);
            }

            int cal = Integer.parseInt(s);

            int curr = cals.get(index);
            cals.set(index, curr + cal);
        }
        cals.sort((a, b) -> (b - a));
        return cals;
    }

    @Override
    public void solvePartOne(List<String> input) {
        List<Integer> cals = readCals(input);
        lap(cals.get(0));
    }

    @Override
    public void solvePartTwo(List<String> input) {
        List<Integer> cals = readCals(input);
        lap(cals.get(0) + cals.get(1) + cals.get(2));
    }
}
