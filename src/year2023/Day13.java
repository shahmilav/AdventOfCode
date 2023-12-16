package year2023;

import helpers.AoCSolver;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day13 extends AoCSolver {
    public Day13(int year, String day) {
        super(year, day);
    }

    public static void main(String[] args) {
        new Day13(2023, "13");
    }

    @Nullable
    private static Integer getVerticalMirrors(List<List<String>> note, List<Integer> mvl) {
        for (List<String> list : note) {
            for (int j = 1; j < list.size(); j++) {
                if (list.get(j).equals(list.get(j - 1))) {
                    mvl.add(j);
                }
            }
        }

        Integer maxVal = mvl.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
        return maxVal;
    }

    @Override
    public void solvePartOne(List<String> input) {
        List<List<String>> note = new ArrayList<>();
        List<Integer> mvl = new ArrayList<>();
        List<Integer> mhl = new ArrayList<>();

        Dictionary<Integer, Integer> vert = new Hashtable<>();
        Dictionary<Integer, Integer> hori = new Hashtable<>();


        for (String s : input) {
            if (s.isEmpty()) {
                // note done!
                System.out.println(note);

                Integer maxVal = getVerticalMirrors(note, mvl);
                System.out.println(maxVal +" " +note.size());
                if (maxVal != null && maxVal == note.size()) {
                    vert.put(input.indexOf(s), maxVal);
                }

                System.out.println(vert);

                note.clear();
            } else {
                note.add(List.of(s.split("")));
            }

        }
    }

    @Override
    public void solvePartTwo(List<String> input) {

    }
}
