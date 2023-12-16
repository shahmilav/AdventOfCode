package year2023;

import helpers.AoCSolver;

import java.util.Arrays;
import java.util.List;

public class Day12 extends AoCSolver {
    public static void main(String[] args) {
        new Day12(2023, "12");
    }
    public Day12(int year, String day) {
        super(year, day);
    }

    @Override
    public void solvePartOne(List<String> input) {
        for (int i = 0; i < input.size(); i++) {
            String ln = input.get(i);
            String[] data = ln.split(" ");
            String[] springs = data[0].split("");
            String[] nums = data[1].split(",");

            System.out.println(Arrays.toString(nums));

        }

    }

    @Override
    public void solvePartTwo(List<String> input) {

    }
}
