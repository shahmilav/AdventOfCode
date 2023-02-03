package year2020;

import helpers.AoCSolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day06 extends AoCSolver {

    public Day06(int year, String day) {
        super(year, day);
    }

    public static void main(String[] args) {
        new Day06(2020, "06");
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

            String s =
                    Arrays.stream(stringBuilder.toString().split(""))
                            .distinct()
                            .collect(Collectors.joining());

            counts += s.length();
        }

        lap(counts);
    }

    @Override
    public void solvePartTwo(List<String> input) {
        int counts = 0;
        List<Integer> peoples = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        int peopleCounter = 0;
        for (String item : input) {
            if (item.isBlank()) {
                s.append("\n");
                peoples.add(peopleCounter);
                peopleCounter = 0;
            } else {
                s.append(item);
                peopleCounter++;
            }
        }
        peoples.add(peopleCounter);

        String[] arr = s.toString().split("\n");

        System.out.println("====" + peoples + "=====");

        for (int i = 0; i < peoples.size(); i++) {
            String value = arr[i];

            System.out.println(value);
            int people = peoples.get(i);
            System.out.println(people);
            int count = 0;

            if (value.chars().filter(ch -> ch == 'a').count() == people) {
                count++;
            }
            if (value.chars().filter(ch -> ch == 'b').count() == people) {
                count++;
            }
            if (value.chars().filter(ch -> ch == 'c').count() == people) {
                count++;
            }
            if (value.chars().filter(ch -> ch == 'd').count() == people) {
                count++;
            }
            if (value.chars().filter(ch -> ch == 'e').count() == people) {
                count++;
            }
            if (value.chars().filter(ch -> ch == 'f').count() == people) {
                count++;
            }
            if (value.chars().filter(ch -> ch == 'g').count() == people) {
                count++;
            }
            if (value.chars().filter(ch -> ch == 'h').count() == people) {
                count++;
            }
            if (value.chars().filter(ch -> ch == 'i').count() == people) {
                count++;
            }
            if (value.chars().filter(ch -> ch == 'j').count() == people) {
                count++;
            }
            if (value.chars().filter(ch -> ch == 'k').count() == people) {
                count++;
            }
            if (value.chars().filter(ch -> ch == 'l').count() == people) {
                count++;
            }
            if (value.chars().filter(ch -> ch == 'm').count() == people) {
                count++;
            }
            if (value.chars().filter(ch -> ch == 'n').count() == people) {
                count++;
            }
            if (value.chars().filter(ch -> ch == 'o').count() == people) {
                count++;
            }
            if (value.chars().filter(ch -> ch == 'p').count() == people) {
                count++;
            }
            if (value.chars().filter(ch -> ch == 'q').count() == people) {
                count++;
            }
            if (value.chars().filter(ch -> ch == 'r').count() == people) {
                count++;
            }
            if (value.chars().filter(ch -> ch == 's').count() == people) {
                count++;
            }
            if (value.chars().filter(ch -> ch == 't').count() == people) {
                count++;
            }
            if (value.chars().filter(ch -> ch == 'u').count() == people) {
                count++;
            }
            if (value.chars().filter(ch -> ch == 'v').count() == people) {
                count++;
            }
            if (value.chars().filter(ch -> ch == 'w').count() == people) {
                count++;
            }
            if (value.chars().filter(ch -> ch == 'x').count() == people) {
                count++;
            }
            if (value.chars().filter(ch -> ch == 'y').count() == people) {
                count++;
            }
            if (value.chars().filter(ch -> ch == 'z').count() == people) {
                count++;
            }

            System.out.println(count);
            counts += count;
        }

        lap(counts);
    }
}
