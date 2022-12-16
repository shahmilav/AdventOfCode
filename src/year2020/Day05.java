package year2020;

import helpers.AoCSolver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day05 extends AoCSolver {

    public Day05(String year, String day) {
        super(year, day);
    }

    public static void main(String[] args) {
        new Day05("2020", "05");
    }

    @Override
    public void solvePartOne(List<String> input) {

        int maxID = 0;

        for (String s : input) {
            int[] searchRangeRows = {0, 127};
            int[] searchRangeCols = {0, 7};
            String[] spl = s.split("");

            for (int i = 0; i < 7; i++) {
                switch (spl[i]) {
                    case ("F") -> {
                        double mid = (searchRangeRows[0] + searchRangeRows[1]) / 2.0;
                        searchRangeRows[1] = (int) Math.floor(mid);
                    }
                    case ("B") -> {
                        double mid = (searchRangeRows[0] + searchRangeRows[1]) / 2.0;
                        searchRangeRows[0] = (int) Math.ceil(mid);
                    }
                }
            }

            int row = searchRangeRows[0];

            for (int i = 7; i < 10; i++) {
                switch (spl[i]) {
                    case ("L") -> {
                        double mid = (searchRangeCols[0] + searchRangeCols[1]) / 2.0;
                        searchRangeCols[1] = (int) Math.floor(mid);
                    }
                    case ("R") -> {
                        double mid = (searchRangeCols[0] + searchRangeCols[1]) / 2.0;
                        searchRangeCols[0] = (int) Math.ceil(mid);
                    }
                }
            }

            int col = searchRangeCols[0];
            maxID = Math.max(maxID, (row * 8 + col));
        }

        lap(maxID);
    }

    @Override
    public void solvePartTwo(List<String> input) {
        List<Integer> ids = new ArrayList<>();
        for (String s : input) {
            int[] searchRangeRows = {0, 127};
            int[] searchRangeCols = {0, 7};
            String[] spl = s.split("");

            for (int i = 0; i < 7; i++) {
                switch (spl[i]) {
                    case ("F") -> {
                        double mid = (searchRangeRows[0] + searchRangeRows[1]) / 2.0;
                        searchRangeRows[1] = (int) Math.floor(mid);
                    }
                    case ("B") -> {
                        double mid = (searchRangeRows[0] + searchRangeRows[1]) / 2.0;
                        searchRangeRows[0] = (int) Math.ceil(mid);
                    }
                }
            }

            int row = searchRangeRows[0];

            for (int i = 7; i < 10; i++) {
                switch (spl[i]) {
                    case ("L") -> {
                        double mid = (searchRangeCols[0] + searchRangeCols[1]) / 2.0;
                        searchRangeCols[1] = (int) Math.floor(mid);
                    }
                    case ("R") -> {
                        double mid = (searchRangeCols[0] + searchRangeCols[1]) / 2.0;
                        searchRangeCols[0] = (int) Math.ceil(mid);
                    }
                }
            }

            int col = searchRangeCols[0];
            ids.add(row * 8 + col);
        }

        Collections.sort(ids);

        for (int i = 0; i < ids.size() - 1; i++) {
            if (ids.get(i + 1) - (ids.get(i)) != 1) {
                lap(ids.get(i) + 1);
            }
        }

    }
}
