package year2022;

import helpers.AoCSolver;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Day07 extends AoCSolver {
    public Day07(String year, String day) {
        super(year, day);
    }

    public static void main(String[] args) {
        new Day07("2022", "07");
    }

    private static void goUp(Stack<Integer> stack, Stack<Integer> sizes) {
        sizes.push(stack.pop());

        if (!stack.isEmpty()) {
            Integer m = stack.pop();
            m += sizes.peek();
            stack.push(m);
        }
    }

    @Override
    public void solvePartOne(List<String> input) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> sizes = new Stack<>();

        for (String s : input) {
            String[] arr = s.split(" ");

            if (arr[0].equals("$")) {
                if (arr[1].equals("cd")) {
                    if (arr[2].equals("..")) {
                        goUp(stack, sizes);
                    } else {
                        stack.push(0);
                    }
                }
            } else if (!arr[0].equals("dir")) {
                int m = Integer.parseInt(arr[0]);
                int top = stack.pop();
                top += m;
                stack.push(top);
            }
        }

        while (!stack.isEmpty()) {
            goUp(stack, sizes);
        }

        int sum = 0;

        for (int i = 0; i < sizes.size(); i += 0) {
            int a = sizes.pop();
            if (a <= 100_000) {
                sum += a;
            }
        }

        lap(sum);
    }

    @Override
    public void solvePartTwo(List<String> input) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> sizes = new Stack<>();

        for (String s : input) {
            String[] arr = s.split(" ");

            if (arr[0].equals("$")) {
                if (arr[1].equals("cd")) {
                    if (arr[2].equals("..")) {
                        goUp(stack, sizes);
                    } else {
                        stack.push(0);
                    }
                }
            } else if (!arr[0].equals("dir")) {
                int m = Integer.parseInt(arr[0]);
                int top = stack.pop();
                top += m;
                stack.push(top);
            }
        }

        while (!stack.isEmpty()) {
            goUp(stack, sizes);
        }

        for (int i = 0; i < sizes.size(); i++) {
            Object[] a = sizes.toArray();
            Arrays.sort(a);

            if (Integer.parseInt(a[i].toString())
                    >= (Integer.parseInt(a[a.length - 1].toString()) - 40000000)) {
                lap(Integer.parseInt(a[i].toString()));
            }
        }
    }
}
