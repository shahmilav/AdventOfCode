package year2023;

import helpers.AoCSolver;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Day09 extends AoCSolver {
    public Day09(int year, String day) {
        super(year, day);
    }

    public static void main(String[] args) {
        new Day09(2023, "09");
    }

    private static int p1extrapolate(List<String> input, HashMap<String, Stack<List<Integer>>> map) {
        int exp = 0;
        for (int i = 0; i < map.size(); i++) {
            Stack<List<Integer>> stack = map.get(input.get(i));
            for (int j = stack.size(); j > 0; j--) {
                exp += stack.peek().get(stack.peek().size() - 1);
                stack.pop();
            }
        }
        return exp;
    }

    @NotNull
    private static HashMap<String, Stack<List<Integer>>> populateMap(List<String> input) {
        HashMap<String, Stack<List<Integer>>> map = new HashMap<>();

        for (String i : input) {
            Stack<List<Integer>> s = new Stack<>();
            String[] a = i.split(" ");
            List<Integer> li = new ArrayList<>();
            for (String string : a) {
                li.add(Integer.parseInt(string));
            }


            s.push(li);
            map.put(i, s);
        }
        return map;
    }

    private static int p2extrapolate(List<String> input, HashMap<String, Stack<List<Integer>>> map) {
        int exp = 0;
        for (int i = 0; i < map.size(); i++) {
            Stack<List<Integer>> stack = reverseStack(map.get(input.get(i)));

            int j = 0;
            while (!stack.isEmpty()) {
                exp += (j % 2 == 0) ? stack.peek().get(0) : -stack.peek().get(0);
                stack.pop();
                j++;

            }
        }
        return exp;
    }

    @NotNull
    private static Stack<List<Integer>> reverseStack(Stack<List<Integer>> st) {
        Stack<List<Integer>> stack = new Stack<>();
        for (int j = 0; j < st.size() + j; j++) {
            stack.push(st.pop());
        }
        return stack;
    }

    @Override
    public void solvePartOne(List<String> input) {
        HashMap<String, Stack<List<Integer>>> map = populateMap(input);
        findDiffs(input, map);
        lap(p1extrapolate(input, map));
    }

    private void findDiffs(List<String> input, HashMap<String, Stack<List<Integer>>> map) {
        for (int i = 0; i < map.size(); i++) {
            Stack<List<Integer>> stack = map.get(input.get(i));
            while (!areAllEqual(stack.peek())) {
                List<Integer> diff = new ArrayList<>();
                for (int j = 0; j < stack.peek().size() - 1; j++) {
                    int a = stack.peek().get(j);
                    int b = stack.peek().get(j + 1);

                    diff.add((b - a));

                }
                stack.push(diff);
            }
            map.put(input.get(i), stack);
        }
    }

    private boolean areAllEqual(List<Integer> li) {
        int a = li.get(0);
        for (Integer integer : li) {
            if (integer != a) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void solvePartTwo(List<String> input) {
        HashMap<String, Stack<List<Integer>>> map = populateMap(input);
        findDiffs(input, map);

        lap(p2extrapolate(input, map));
    }
}
