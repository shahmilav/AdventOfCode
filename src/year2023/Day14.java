package year2023;

import helpers.AoCSolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Day14 extends AoCSolver {
    public Day14(int year, String day) {
        super(year, day);
    }

    public static void main(String[] args) {
        new Day14(2023, "14");
    }

    private static void printMap(List<String> input) {
        for (String s : input) {
            System.out.println(s);
        }
    }

    private static int calcNorthLoad(List<String> copy) {
        int sum = 0;
        for (int i = 0; i < copy.size(); i++) {
            String[] split = copy.get(i).split("");
            for (String s : split) {
                if (Objects.equals(s, "O")) {
                    sum += copy.size() - i;
                }
            }
        }
        return sum;
    }

    private void tiltNorth(List<String> input) {
        for (int i = 1; i < input.size(); i++) {
            String[] array = input.get(i).split("");
            for (int j = 0; j < array.length; j++) {
                for (int k = i; k > 0; k--) {
                    if (input.get(k - 1).charAt(j) == '.' && input.get(k).charAt(j) == 'O') {
                        String s = addChar(input.get(k - 1), 'O', j);
                        String rep = addChar(input.get(k), '.', j);
                        input.set(k - 1, s);
                        input.set(k, rep);

                    }
                }

            }
        }
    }

    public String addChar(String str, char ch, int position) {
        return str.substring(0, position) + ch + str.substring(position + 1);
    }

    @Override
    public void solvePartOne(List<String> input) {
        List<String> copy = new ArrayList<>(input);

        tiltNorth(copy);
//
        int sum = calcNorthLoad(copy);

        lap(sum);

    }

    private void tiltSouth(List<String> input) {
        for (int i = input.size() - 1; i > 0; i--) {
            String[] array = input.get(i).split("");
            for (int j = 0; j < array.length; j++) {
                for (int k = 0; k < i; k++) {
                    if (input.get(k + 1).charAt(j) == '.' && input.get(k).charAt(j) == 'O') {
                        String s = addChar(input.get(k + 1), 'O', j);
                        String rep = addChar(input.get(k), '.', j);
                        input.set(k + 1, s);
                        input.set(k, rep);

                    }
                }

            }
        }
    }

    private void tiltWest(List<String> input) {
        for (int i = 0; i < input.size(); i++) {
            String s = input.get(i);
            List<String> a = new ArrayList<>(List.of(s.split("")));
            for (int j = 1; j < input.size(); j++) {
                int k = j;
                while (a.get(k).equals("O") && a.get(k - 1).equals(".")) {
                    a.set(k, ".");
                    a.set(k - 1, "O");
                    k--;
                    if (k == 0) break;
                }
            }
            input.set(i, a.toString().replaceAll(" ", "").replaceAll(",", "").replace("[", "").replace("]", ""));
        }
    }

    private void tiltEast(List<String> input) {
        for (int i = 0; i < input.size(); i++) {
            String s = input.get(i);
            List<String> a = new ArrayList<>(List.of(s.split("")));
            for (int j = a.size(); j >= 0; j--) {
                int k = j;
                try {
                    while (a.get(k).equals("O") && a.get(k + 1).equals(".")) {
                        a.set(k, ".");
                        a.set(k + 1, "O");
                        k++;
                    }
                } catch (IndexOutOfBoundsException ignored) {

                }
            }
            input.set(i, a.toString().replaceAll(" ", "").replaceAll(",", "").replace("[", "").replace("]", ""));
        }
    }


    @Override
    public void solvePartTwo(List<String> input) {
        List<String> copy = new ArrayList<>(input);
        List<List<String>> saves = new ArrayList<>();

        int A = 0, B = 0;

        for (int i = 0; i < 1000; i++) {

            tiltNorth(copy);
            tiltWest(copy);
            tiltSouth(copy);
            tiltEast(copy);


            if (saves.contains(copy)) {
                saves.add(copy);
                A = Math.min(saves.indexOf(copy), i);
                B = Math.max(saves.indexOf(copy), i);

                break;
            } else {
                saves.add(new ArrayList<>(copy));
            }
        }


        List<Integer> pattern = new ArrayList<>();
        for (int i = A; i < B; i++) {
            pattern.add(calcNorthLoad(saves.get(i)));
        }


        int lap = (1_000_000_000 - A) % (B - A);
        lap(pattern.get(lap - 1));

    }
}
