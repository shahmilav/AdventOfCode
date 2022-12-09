package year2022;

import helpers.FileManager;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Day07 {
    public static void main(String[] args) {
        FileManager manager = new FileManager(2022, 7);

        Scanner myReader = manager.generateScanner();
        System.out.println(partOne(myReader));

        myReader = manager.generateScanner();
        System.out.println(partTwo(myReader));
    }

    private static void goUp(Stack<Integer> stack, Stack<Integer> sizes) {
        sizes.push(stack.pop());

        if (!stack.isEmpty()) {
            Integer m = stack.pop();
            m += sizes.peek();
            stack.push(m);
        }
    }

    private static int partOne(Scanner myReader) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> sizes = new Stack<>();

        while (myReader.hasNextLine()) {
            String s = myReader.nextLine();
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

        return sum;
    }

    private static int partTwo(Scanner myReader) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> sizes = new Stack<>();

        while (myReader.hasNextLine()) {
            String s = myReader.nextLine();
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
                return Integer.parseInt(a[i].toString());
            }
        }

        return 0;
    }
}
