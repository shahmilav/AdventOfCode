package year2022;

import helpers.AoCSolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Day05 extends AoCSolver {
    public Day05(String year, String day) {
        super(year, day);
    }

    public static void main(String[] args) {
        new Day05("2022", "05");
    }

    private static List<Stack<String>> initializeStacks() {
        Stack<String> stack1 = new Stack<>();
        for (String s : Arrays.asList("T", "P", "Z", "C", "S", "L", "Q", "N")) {
            stack1.push(s);
        }

        Stack<String> stack2 = new Stack<>();
        for (String s : Arrays.asList("L", "P", "T", "V", "H", "C", "G")) {
            stack2.push(s);
        }

        Stack<String> stack3 = new Stack<>();
        for (String s : Arrays.asList("D", "C", "Z", "F")) {
            stack3.push(s);
        }

        Stack<String> stack4 = new Stack<>();
        for (String s : Arrays.asList("G", "W", "T", "D", "L", "M", "V", "C")) {
            stack4.push(s);
        }

        Stack<String> stack5 = new Stack<>();
        for (String s : Arrays.asList("P", "W", "C")) {
            stack5.push(s);
        }

        Stack<String> stack6 = new Stack<>();
        for (String s : Arrays.asList("P", "F", "J", "D", "C", "T", "S", "Z")) {
            stack6.push(s);
        }

        Stack<String> stack7 = new Stack<>();
        for (String s : Arrays.asList("V", "W", "G", "B", "D")) {
            stack7.push(s);
        }

        Stack<String> stack8 = new Stack<>();
        for (String s : Arrays.asList("N", "J", "S", "Q", "H", "W")) {
            stack8.push(s);
        }

        Stack<String> stack9 = new Stack<>();
        for (String s : Arrays.asList("R", "C", "Q", "F", "S", "L", "V")) {
            stack9.push(s);
        }

        List<Stack<String>> stacks = new ArrayList<>();

        stacks.add(stack1);
        stacks.add(stack2);
        stacks.add(stack3);
        stacks.add(stack4);
        stacks.add(stack5);
        stacks.add(stack6);
        stacks.add(stack7);
        stacks.add(stack8);
        stacks.add(stack9);

        return stacks;
    }

    @Override
    public void solvePartOne(List<String> input) {
        List<Stack<String>> stacks = initializeStacks();
        Stack<String> stack1 = stacks.get(0);
        Stack<String> stack2 = stacks.get(1);
        Stack<String> stack3 = stacks.get(2);
        Stack<String> stack4 = stacks.get(3);
        Stack<String> stack5 = stacks.get(4);
        Stack<String> stack6 = stacks.get(5);
        Stack<String> stack7 = stacks.get(6);
        Stack<String> stack8 = stacks.get(7);
        Stack<String> stack9 = stacks.get(8);

        for (String s : input) {

            if (!s.isEmpty() && s.charAt(0) == 'm') {

                for (String s1 : Arrays.asList("move ", "from ", "to ")) {
                    s = s.replace(s1, "");
                }

                String[] rules = s.split(" ");
                int numberToMove = Integer.parseInt(rules[0]);
                int startStack = Integer.parseInt(rules[1]);
                int endStack = Integer.parseInt(rules[2]);

                String[] moving = new String[numberToMove];

                switch (startStack) {
                    case (1) -> {
                        for (int i = 0; i < numberToMove; i++) {
                            moving[i] = (stack1.pop());
                        }
                    }
                    case (2) -> {
                        for (int i = 0; i < numberToMove; i++) {
                            moving[i] = (stack2.pop());
                        }
                    }
                    case (3) -> {
                        for (int i = 0; i < numberToMove; i++) {
                            moving[i] = (stack3.pop());
                        }
                    }
                    case (4) -> {
                        for (int i = 0; i < numberToMove; i++) {
                            moving[i] = (stack4.pop());
                        }
                    }
                    case (5) -> {
                        for (int i = 0; i < numberToMove; i++) {
                            moving[i] = (stack5.pop());
                        }
                    }
                    case (6) -> {
                        for (int i = 0; i < numberToMove; i++) {
                            moving[i] = (stack6.pop());
                        }
                    }
                    case (7) -> {
                        for (int i = 0; i < numberToMove; i++) {
                            moving[i] = (stack7.pop());
                        }
                    }
                    case (8) -> {
                        for (int i = 0; i < numberToMove; i++) {
                            moving[i] = (stack8.pop());
                        }
                    }
                    case (9) -> {
                        for (int i = 0; i < numberToMove; i++) {
                            moving[i] = (stack9.pop());
                        }
                    }
                }

                switch (endStack) {
                    case (1) -> {
                        for (int i = 0; i < numberToMove; i++) {
                            stack1.push(moving[i]);
                        }
                    }
                    case (2) -> {
                        for (int i = 0; i < numberToMove; i++) {
                            stack2.push(moving[i]);
                        }
                    }
                    case (3) -> {
                        for (int i = 0; i < numberToMove; i++) {
                            stack3.push(moving[i]);
                        }
                    }
                    case (4) -> {
                        for (int i = 0; i < numberToMove; i++) {
                            stack4.push(moving[i]);
                        }
                    }
                    case (5) -> {
                        for (int i = 0; i < numberToMove; i++) {
                            stack5.push(moving[i]);
                        }
                    }
                    case (6) -> {
                        for (int i = 0; i < numberToMove; i++) {
                            stack6.push(moving[i]);
                        }
                    }
                    case (7) -> {
                        for (int i = 0; i < numberToMove; i++) {
                            stack7.push(moving[i]);
                        }
                    }
                    case (8) -> {
                        for (int i = 0; i < numberToMove; i++) {
                            stack8.push(moving[i]);
                        }
                    }
                    case (9) -> {
                        for (int i = 0; i < numberToMove; i++) {
                            stack9.push(moving[i]);
                        }
                    }
                }
            }
        }

        lap(
                stack1.peek()
                        + stack2.peek()
                        + stack3.peek()
                        + stack4.peek()
                        + stack5.peek()
                        + stack6.peek()
                        + stack7.peek()
                        + stack8.peek()
                        + stack9.peek());
    }

    @Override
    public void solvePartTwo(List<String> input) {

        List<Stack<String>> stacks = initializeStacks();
        Stack<String> stack1 = stacks.get(0);
        Stack<String> stack2 = stacks.get(1);
        Stack<String> stack3 = stacks.get(2);
        Stack<String> stack4 = stacks.get(3);
        Stack<String> stack5 = stacks.get(4);
        Stack<String> stack6 = stacks.get(5);
        Stack<String> stack7 = stacks.get(6);
        Stack<String> stack8 = stacks.get(7);
        Stack<String> stack9 = stacks.get(8);

        for (String s : input) {

            if (!s.isEmpty() && s.charAt(0) == 'm') {

                for (String s1 : Arrays.asList("move ", "from ", "to ")) {
                    s = s.replace(s1, "");
                }

                String[] rules = s.split(" ");
                int numberToMove = Integer.parseInt(rules[0]);
                int startStack = Integer.parseInt(rules[1]);
                int endStack = Integer.parseInt(rules[2]);

                String[] moving = new String[numberToMove];

                switch (startStack) {
                    case (1) -> {
                        for (int i = 0; i < numberToMove; i++) {
                            moving[i] = (stack1.pop());
                        }
                    }
                    case (2) -> {
                        for (int i = 0; i < numberToMove; i++) {
                            moving[i] = (stack2.pop());
                        }
                    }
                    case (3) -> {
                        for (int i = 0; i < numberToMove; i++) {
                            moving[i] = (stack3.pop());
                        }
                    }
                    case (4) -> {
                        for (int i = 0; i < numberToMove; i++) {

                            moving[i] = (stack4.pop());
                        }
                    }
                    case (5) -> {
                        for (int i = 0; i < numberToMove; i++) {
                            moving[i] = (stack5.pop());
                        }
                    }
                    case (6) -> {
                        for (int i = 0; i < numberToMove; i++) {
                            moving[i] = (stack6.pop());
                        }
                    }
                    case (7) -> {
                        for (int i = 0; i < numberToMove; i++) {
                            moving[i] = (stack7.pop());
                        }
                    }
                    case (8) -> {
                        for (int i = 0; i < numberToMove; i++) {
                            moving[i] = (stack8.pop());
                        }
                    }
                    case (9) -> {
                        for (int i = 0; i < numberToMove; i++) {
                            moving[i] = (stack9.pop());
                        }
                    }
                }

                switch (endStack) {
                    case (1) -> {
                        for (int i = numberToMove - 1; i >= 0; i--) {
                            stack1.push(moving[i]);
                        }
                    }
                    case (2) -> {
                        for (int i = numberToMove - 1; i >= 0; i--) {
                            stack2.push(moving[i]);
                        }
                    }
                    case (3) -> {
                        for (int i = numberToMove - 1; i >= 0; i--) {
                            stack3.push(moving[i]);
                        }
                    }
                    case (4) -> {
                        for (int i = numberToMove - 1; i >= 0; i--) {
                            stack4.push(moving[i]);
                        }
                    }
                    case (5) -> {
                        for (int i = numberToMove - 1; i >= 0; i--) {
                            stack5.push(moving[i]);
                        }
                    }
                    case (6) -> {
                        for (int i = numberToMove - 1; i >= 0; i--) {
                            stack6.push(moving[i]);
                        }
                    }
                    case (7) -> {
                        for (int i = numberToMove - 1; i >= 0; i--) {
                            stack7.push(moving[i]);
                        }
                    }
                    case (8) -> {
                        for (int i = numberToMove - 1; i >= 0; i--) {
                            stack8.push(moving[i]);
                        }
                    }
                    case (9) -> {
                        for (int i = numberToMove - 1; i >= 0; i--) {
                            stack9.push(moving[i]);
                        }
                    }
                }
            }
        }
        lap(
                stack1.peek()
                        + stack2.peek()
                        + stack3.peek()
                        + stack4.peek()
                        + stack5.peek()
                        + stack6.peek()
                        + stack7.peek()
                        + stack8.peek()
                        + stack9.peek());
    }
}
