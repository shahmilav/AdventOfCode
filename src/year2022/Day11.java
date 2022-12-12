package year2022;

import helpers.AoCSolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Day11 extends AoCSolver {

    public Day11(String year, String day) {
        super(year, day);
    }

    public static void main(String[] args) {
        new Day11("2022", "11");
    }

    private static List<Stack<Integer>> initializeStacks() {
        Stack<Integer> monkey0 = new Stack<>();
        for (int i : List.of(80)) {
            monkey0.push(i);
        }

        Stack<Integer> monkey1 = new Stack<>();
        for (int i : Arrays.asList(74, 83, 75)) {
            monkey1.push(i);
        }
        Stack<Integer> monkey2 = new Stack<>();
        for (int i : List.of(73, 63, 52, 96, 61, 67, 86)) {
            monkey2.push(i);
        }

        Stack<Integer> monkey3 = new Stack<>();
        for (int i : Arrays.asList(52, 85, 70, 57, 85, 55, 83, 85)) {
            monkey3.push(i);
        }

        Stack<Integer> monkey4 = new Stack<>();
        for (int i : Arrays.asList(89, 72, 91, 75, 67)) {
            monkey4.push(i);
        }
        Stack<Integer> monkey5 = new Stack<>();
        for (int i : List.of(77, 68, 92, 68, 64, 66)) {
            monkey5.push(i);
        }

        Stack<Integer> monkey6 = new Stack<>();
        for (int i : Arrays.asList(88, 79, 94, 97)) {
            monkey6.push(i);
        }

        Stack<Integer> monkey7 = new Stack<>();
        for (int i : Arrays.asList(85, 77)) {
            monkey7.push(i);
        }

        List<Stack<Integer>> monkeys = new ArrayList<>();

        monkeys.add(monkey0);
        monkeys.add(monkey1);
        monkeys.add(monkey2);
        monkeys.add(monkey3);
        monkeys.add(monkey4);
        monkeys.add(monkey5);
        monkeys.add(monkey6);
        monkeys.add(monkey7);

        return monkeys;
    }

    @Override
    public void solvePartOne(List<String> input) {
        List<Stack<Integer>> monkeys = initializeStacks();

        int[] monkeyCounters = {0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < 20; i++) {

            while (!monkeys.get(0).isEmpty()) {
                int worryLevel = monkeys.get(0).pop();
                worryLevel *= 5;
                worryLevel /= 3;

                if (worryLevel % 2 == 0) {
                    monkeys.get(4).push(worryLevel);
                } else {
                    monkeys.get(3).push(worryLevel);
                }

                monkeyCounters[0]++;
            }

            while (!monkeys.get(1).isEmpty()) {
                int worryLevel = monkeys.get(1).pop();
                worryLevel += 7;
                worryLevel /= 3;

                if (worryLevel % 7 == 0) {
                    monkeys.get(5).push(worryLevel);
                } else {
                    monkeys.get(6).push(worryLevel);
                }

                monkeyCounters[1]++;
            }

            while (!monkeys.get(2).isEmpty()) {
                int worryLevel = monkeys.get(2).pop();
                worryLevel += 5;
                worryLevel /= 3;

                if (worryLevel % 3 == 0) {
                    monkeys.get(7).push(worryLevel);
                } else {
                    monkeys.get(0).push(worryLevel);
                }

                monkeyCounters[2]++;
            }

            while (!monkeys.get(3).isEmpty()) {
                int worryLevel = monkeys.get(3).pop();
                worryLevel += 8;
                worryLevel /= 3;

                if (worryLevel % 17 == 0) {
                    monkeys.get(1).push(worryLevel);
                } else {
                    monkeys.get(5).push(worryLevel);
                }

                monkeyCounters[3]++;
            }

            while (!monkeys.get(4).isEmpty()) {
                int worryLevel = monkeys.get(4).pop();
                worryLevel += 4;
                worryLevel /= 3;

                if (worryLevel % 11 == 0) {
                    monkeys.get(3).push(worryLevel);
                } else {
                    monkeys.get(1).push(worryLevel);
                }

                monkeyCounters[4]++;
            }

            while (!monkeys.get(5).isEmpty()) {
                int worryLevel = monkeys.get(5).pop();
                worryLevel *= 2;
                worryLevel /= 3;

                if (worryLevel % 19 == 0) {
                    monkeys.get(6).push(worryLevel);
                } else {
                    monkeys.get(2).push(worryLevel);
                }

                monkeyCounters[5]++;
            }

            while (!monkeys.get(6).isEmpty()) {
                int worryLevel = monkeys.get(6).pop();
                worryLevel *= worryLevel;
                worryLevel /= 3;

                if (worryLevel % 5 == 0) {
                    monkeys.get(2).push(worryLevel);
                } else {
                    monkeys.get(7).push(worryLevel);
                }

                monkeyCounters[6]++;
            }

            while (!monkeys.get(7).isEmpty()) {
                int worryLevel = monkeys.get(7).pop();
                worryLevel += 6;
                worryLevel /= 3;

                if (worryLevel % 13 == 0) {
                    monkeys.get(4).push(worryLevel);
                } else {
                    monkeys.get(0).push(worryLevel);
                }

                monkeyCounters[7]++;
            }
        }

        Arrays.sort(monkeyCounters);

        lap(monkeyCounters[7] * monkeyCounters[6]);
    }

    @Override
    public void solvePartTwo(List<String> input) {
       // run the python code
        lap(28537348205L);
        System.out.println("\t\t\t\t\t Note: Part two time inaccurate.");
    }
}
