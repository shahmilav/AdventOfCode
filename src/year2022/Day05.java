package year2022;

import helpers.FileManager;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Day05 {
    public static void main(String[] args) throws FileNotFoundException {
        FileManager manager = new FileManager(2022, 5);

        Scanner myReader = manager.generateScanner();
        System.out.println(partOne(myReader));

        myReader = manager.generateScanner();
        System.out.println(partTwo(myReader));
    }

    private static String partOne(Scanner myReader) {

        // TODO(never) read stacks from file instead of hardcoding.

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

        while (myReader.hasNextLine()) {
            String s = myReader.nextLine();

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

        return stack1.peek()
                + stack2.peek()
                + stack3.peek()
                + stack4.peek()
                + stack5.peek()
                + stack6.peek()
                + stack7.peek()
                + stack8.peek()
                + stack9.peek();
    }

    private static String partTwo(Scanner myReader) {
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

        while (myReader.hasNextLine()) {
            String s = myReader.nextLine();

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
        return stack1.peek()
                + stack2.peek()
                + stack3.peek()
                + stack4.peek()
                + stack5.peek()
                + stack6.peek()
                + stack7.peek()
                + stack8.peek()
                + stack9.peek();
    }
}
