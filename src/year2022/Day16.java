package year2022;

import helpers.AoCSolver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day16 extends AoCSolver {

    public Day16(String year, String day) {
        super(year, day);
    }

    public static void main(String[] args) {
        new Day16("2022", "16");
    }

    private Map<String, Valve> input(List<String> input) {
        HashMap<String, Valve> m = new HashMap<>();

        return m;
    }

    @Override
    public void solvePartOne(List<String> input) {
        Map<String, Valve> valves = input(input);

    }

    @Override
    public void solvePartTwo(List<String> input) {

    }

    public record Valve(String name, long flow, String others) {
    }

    public record State(Map<String, Long> open, Valve valve, long totalFlow) {
    }

    public record State2(Map<String, Long> open, Valve me, Valve elephant, long totalFlow) {
    }
}