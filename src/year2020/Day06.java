package year2020;

import helpers.AoCSolver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day06 extends AoCSolver {

    public Day06(String year, String day) {
        super(year, day);
    }

    public static void main(String[] args) {
        new Day06("2020", "06");
    }

    @Override
    public void solvePartOne(List<String> input) {

        int counts = 0;
        for (int i = 0; i < input.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append(input.get(i));
            while (!(input.get(i).isBlank()) && i < input.size() - 1) {
                i++;
                stringBuilder.append(input.get(i));
            }


            String s = Arrays.stream(stringBuilder.toString().split("")).distinct().collect(Collectors.joining());

            counts += s.length();
        }

        lap(counts);
    }

    @Override
    public void solvePartTwo(List<String> input) {
        int counts = 0;
        for (int i = 0; i < input.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            int people = 0;
            stringBuilder.append(input.get(i));
            while (!(input.get(i).isBlank())) {
                if (i == input.size() - 1) {
                    people++;
                    stringBuilder.append(input.get(i));
                    break;
                } else {
                    i++;
                    people++;
                    stringBuilder.append(input.get(i));
                }


            }
            System.out.println(people);

            String string = stringBuilder.toString();

            int count = 0;


            if (string.length() - string.replaceAll("a", "").length() == people) count++;
            if (string.length() - string.replaceAll("b", "").length() == people) count++;
            if (string.length() - string.replaceAll("c", "").length() == people) count++;
            if (string.length() - string.replaceAll("d", "").length() == people) count++;
            if (string.length() - string.replaceAll("e", "").length() == people) count++;
            if (string.length() - string.replaceAll("f", "").length() == people) count++;
            if (string.length() - string.replaceAll("g", "").length() == people) count++;
            if (string.length() - string.replaceAll("h", "").length() == people) count++;
            if (string.length() - string.replaceAll("i", "").length() == people) count++;
            if (string.length() - string.replaceAll("j", "").length() == people) count++;
            if (string.length() - string.replaceAll("k", "").length() == people) count++;
            if (string.length() - string.replaceAll("l", "").length() == people) count++;
            if (string.length() - string.replaceAll("m", "").length() == people) count++;
            if (string.length() - string.replaceAll("n", "").length() == people) count++;
            if (string.length() - string.replaceAll("o", "").length() == people) count++;
            if (string.length() - string.replaceAll("p", "").length() == people) count++;
            if (string.length() - string.replaceAll("q", "").length() == people) count++;
            if (string.length() - string.replaceAll("r", "").length() == people) count++;
            if (string.length() - string.replaceAll("s", "").length() == people) count++;
            if (string.length() - string.replaceAll("t", "").length() == people) count++;
            if (string.length() - string.replaceAll("u", "").length() == people) count++;
            if (string.length() - string.replaceAll("w", "").length() == people) count++;
            if (string.length() - string.replaceAll("v", "").length() == people) count++;
            if (string.length() - string.replaceAll("x", "").length() == people) count++;
            if (string.length() - string.replaceAll("y", "").length() == people) count++;
            if (string.length() - string.replaceAll("z", "").length() == people) count++;

            counts += count;
        }

        lap(counts);
    }
}
