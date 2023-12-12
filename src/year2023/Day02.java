package year2023;

import helpers.AoCSolver;

import java.util.List;

public class Day02 extends AoCSolver {

    public Day02(int year, String day) {
        super(year, day);
    }

    public static void main(String[] args) {
        new Day02(2023, "02");
    }

    @Override
    public void solvePartOne(List<String> input) {
        int maxRed = 12, maxGreen = 13, maxBlue = 14;
        int sum = 0;

        for (int i = 1; i <= input.size(); i++) {
            String line = input.get(i - 1);
            boolean isPossible = true;
            line = line.replace("Game " + i + ": ", "");
            String[] array = line.split(", |; ");

            for (String s : array) {
                if (s.contains("blue")) {
                    String cn = s.split(" ")[0];
                    int n = Integer.parseInt(cn);
                    if (n > maxBlue) {
                        isPossible = false;
                        break;
                    }
                } else if (s.contains("green")) {
                    String cn = s.split(" ")[0];
                    int n = Integer.parseInt(cn);
                    if (n > maxGreen) {
                        isPossible = false;
                        break;

                    }
                } else {
                    String cn = s.split(" ")[0];
                    int n = Integer.parseInt(cn);
                    if (n > maxRed) {
                        isPossible = false;
                        break;

                    }
                }
            }

            if (isPossible) {
                sum += i;
            }

        }
        lap(sum);

    }

    @Override
    public void solvePartTwo(List<String> input) {
        long result = 0;

        for (int i = 1; i <= input.size(); i++) {
            int nr = 0, nb = 0, ng = 0;
            String line = input.get(i - 1);
            line = line.replace("Game " + i + ": ", "");
            String[] array = line.split(", |; ");
            for (String s : array) {
                if (s.contains("blue")) {
                    nb = Math.max(nb, Integer.parseInt(s.split(" ")[0]));
                } else if (s.contains("green")) {
                    ng = Math.max(ng, Integer.parseInt(s.split(" ")[0]));

                } else {
                    nr = Math.max(nr, Integer.parseInt(s.split(" ")[0]));
                }
            }

            long power = (long) nb * ng * nr;

            result += power;

        }

        lap(result);
    }

}
