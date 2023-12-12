package year2023;

import helpers.AoCSolver;

import java.util.List;

public class Day01 extends AoCSolver {

    public Day01(int year, String day) {
        super(year, day);
    }

    public static void main(String[] args) {
        new Day01(2023, "01");
    }

    private static String replacer(String s) {


        s = s.replaceAll("twone", "21");
        s = s.replaceAll("eightwo", "82");
        s = s.replaceAll("eighthree", "83");
        s = s.replaceAll("fiveight", "58");
        s = s.replaceAll("oneight", "18");
        s = s.replaceAll("threeight", "38");

        s = s.replaceAll("one", "1");
        s = s.replaceAll("two", "2");
        s = s.replaceAll("three", "3");
        s = s.replaceAll("four", "4");
        s = s.replaceAll("five", "5");
        s = s.replaceAll("six", "6");
        s = s.replaceAll("seven", "7");
        s = s.replaceAll("eight", "8");
        s = s.replaceAll("nine", "9");
        s = s.replaceAll("zero", "0");
        return s;

    }

    @Override
    public void solvePartOne(List<String> input) {
        int sum = 0;

        for (String s : input) {
            String line = s.replaceAll("[^\\d.]", "");
            sum = sumNums(sum, line);

        }

        lap(sum);


    }

    @Override
    public void solvePartTwo(List<String> input) {

        int sum = 0;
        for (String l : input) {
            String line = replacer(l);
            System.out.println(line);

            line = line.replaceAll("[^\\d.]", "");

            sum = sumNums(sum, line);
        }

        lap(sum);
    }

    private int sumNums(int sum, String line) {
        char t = line.charAt(0);
        char o = line.charAt(line.length() - 1);

        int ten = Integer.parseInt(t + "") * 10;
        int ones = Integer.parseInt(o + "");

        sum += ten;
        sum += ones;
        return sum;
    }
}
