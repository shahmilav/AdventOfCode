package year2022;

import helpers.AoCSolver;

import java.util.List;

public class Day02 extends AoCSolver {

    public Day02(String year, String day) {
        super(year, day);
    }

    public static void main(String[] args) {
        new Day02("2022", "02");
    }

    @Override
    public void solvePartOne(List<String> input) {
        int points = 0;

        for (String s : input) {

            switch (s) {
                    // Rock = Rock (1+3)
                case "A X" -> points += 4;
                    // Rock < Paper (2+6)
                case "A Y" -> points += 8;
                    // Rock > Scissors (3+0)
                case "A Z" -> points += 3;
                    // Paper > Rock (1+0)
                case "B X" -> points += 1;
                    // Paper = Paper (2+3)
                case "B Y" -> points += 5;
                    // Paper < Scissors (3+6)
                case "B Z" -> points += 9;
                    // Scissors < Rock (1+6)
                case "C X" -> points += 7;
                    // Scissors > Paper (2+0)
                case "C Y" -> points += 2;
                    // Scissors = Scissors (3+3)
                case "C Z" -> points += 6;
            }
        }

        lap(points);
    }

    @Override
    public void solvePartTwo(List<String> input) {
        int points = 0;

        for (String s : input) {

            switch (s.charAt(0)) {
                case 'A':
                    switch (s.charAt(2)) {
                            // need to lose
                        case 'X' -> points += 3;
                            // need to draw
                        case 'Y' -> points += 4;
                            // need to win
                        case 'Z' -> points += 8;
                    }

                    break;
                case 'B':
                    switch (s.charAt(2)) {
                            // need to lose
                        case 'X' -> points += 1;
                            // need to draw
                        case 'Y' -> points += 5;
                            // need to win
                        case 'Z' -> points += 9;
                    }

                    break;
                case 'C':
                    switch (s.charAt(2)) {
                            // need to lose
                        case 'X' -> points += 2;
                            // need to draw
                        case 'Y' -> points += 6;
                            // need to win
                        case 'Z' -> points += 7;
                    }

                    break;
            }
        }

        lap(points);
    }
}
