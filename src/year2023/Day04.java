package year2023;

import helpers.AoCSolver;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class Day04 extends AoCSolver {

    public Day04(int year, String day) {
        super(year, day);
    }

    public static void main(String[] args) {
        new Day04(2023, "04");
    }

    @Override
    public void solvePartOne(List<String> input) {

        int totalPoints = 0;
        for (String line : input) {
            line = line.replace("Card " + (input.indexOf(line) + 1) + ": ", "").trim();
            String[] cards = line.split(" \\| ");

            List<String> real = Arrays.stream(cards[0].split(" ")).toList();
            List<String> mine = Arrays.stream(cards[1].split(" ")).toList();

            int score = 0;
            for (int i = 0; i < mine.size(); i++) {
                if (real.contains(mine.get(i)) && !mine.get(i).isEmpty()) {
                    if (score == 0) score++;
                    else score *= 2;
                }
            }

            totalPoints += score;
        }


        lap(totalPoints);

    }

    @Override
    public void solvePartTwo(List<String> input) {

        Dictionary<Integer, Integer> dict = new Hashtable<>();
        System.out.println(dict);


        for (int i = 0; i < input.size(); i++) {
            dict.put(i+1, 1);
        }

        for (int i = 0; i < input.size(); i++) {
            String line = input.get(i);
            line = line.replace("Card ", "").replace(": ", " | ").trim();
            String[] thisCard = line.split(" \\| ");


            int id = Integer.parseInt(thisCard[0]);
            List<String> real = Arrays.stream(thisCard[1].split(" ")).toList();
            List<String> mine = Arrays.stream(thisCard[2].split(" ")).toList();


            int wc = 0;
            for (String s : real) {
                if (mine.contains(s) && !s.isEmpty()) {
                    wc++;
                }
            }

            for (int j = wc; j > 0; j--) {

                int toFind = i + j + 1;

                int c = dict.get(id);
                dict.put(toFind, dict.get(toFind)+c);

            }

        }


        int size = 0;
        for (int i = 1; i <= dict.size(); i++) {
            size += dict.get(i);
        }

        System.out.println(dict);
        lap(size);

    }

}
