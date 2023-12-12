package year2023;

import helpers.AoCSolver;
import org.jetbrains.annotations.NotNull;

import java.util.*;


public class Day07 extends AoCSolver {

    public Day07(int year, String day) {
        super(year, day);
    }

    public static void main(String[] args) {
        new Day07(2023, "07");
    }

    private static void sorter(List<String> list, boolean isP1) {
        List<String> order;
        if (isP1) {
            order = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A");
        } else {
            order = Arrays.asList("J", "2", "3", "4", "5", "6", "7", "8", "9", "T", "Q", "K", "A");

        }

        Comparator<String> comp1 = Comparator.comparing(c -> order.indexOf(c.substring(0, 1)));
        Comparator<String> comp2 = Comparator.comparing(c -> order.indexOf(c.substring(1, 2)));
        Comparator<String> comp3 = Comparator.comparing(c -> order.indexOf(c.substring(2, 3)));
        Comparator<String> comp4 = Comparator.comparing(c -> order.indexOf(c.substring(3, 4)));
        Comparator<String> comp5 = Comparator.comparing(c -> order.indexOf(c.substring(4, 5)));

        list.sort(comp5);
        list.sort(comp4);
        list.sort(comp3);
        list.sort(comp2);
        list.sort(comp1);

    }

    private static long calcWinnings(List<String> sl1, List<String> sl2, List<String> sl3, List<String> sl4, List<String> sl5, List<String> sl6, List<String> sl7, HashMap<String, String> bids) {
        // Map out each Rank:Card pairing by merging lists and populating map.
        HashMap<Integer, String> ranks = new HashMap<>();
        List<String> merge = new ArrayList<>();
        merge.addAll(sl1);
        merge.addAll(sl2);
        merge.addAll(sl3);
        merge.addAll(sl4);
        merge.addAll(sl5);
        merge.addAll(sl6);
        merge.addAll(sl7);

        for (int i = 0; i < merge.size(); i++) {
            ranks.put(i + 1, merge.get(i));
        }


        // Calculate winnings
        long winnings = 0;
        for (int i = 1; i <= ranks.size(); i++) {
            String card = ranks.get(i);
            int bid = Integer.parseInt((bids.get(card)));
            winnings += (long) bid * i;
        }
        return winnings;
    }

    @NotNull
    private static HashMap<String, String> getBids(List<String> input) {
        HashMap<String, String> bids = new HashMap<>();
        for (String s : input) {
            String[] a = s.split(" ");
            bids.put(a[0], a[1]);
        }
        return bids;
    }

    @Override
    public void solvePartOne(List<String> input) {

        // Create a map of each card and the corresponding bid.
        HashMap<String, String> bids = getBids(input);

        // Create 7 lists, one for each hand strength
        List<String> sl7 = new ArrayList<>();
        List<String> sl6 = new ArrayList<>();
        List<String> sl5 = new ArrayList<>();
        List<String> sl4 = new ArrayList<>();
        List<String> sl3 = new ArrayList<>();
        List<String> sl2 = new ArrayList<>();
        List<String> sl1 = new ArrayList<>();


        // Populate strength lists
        for (String s : bids.keySet()) {
            switch (calcStrength(s)) {
                case 1 -> sl1.add(s);
                case 2 -> sl2.add(s);
                case 3 -> sl3.add(s);
                case 4 -> sl4.add(s);
                case 5 -> sl5.add(s);
                case 6 -> sl6.add(s);
                case 7 -> sl7.add(s);
            }
        }


        // Sort each list low to high ranking (tiebreakers)
        sorter(sl1, true);
        sorter(sl2, true);
        sorter(sl3, true);
        sorter(sl4, true);
        sorter(sl5, true);
        sorter(sl6, true);
        sorter(sl7, true);

        // Map out each Rank:Card pairing by merging lists and populating map.
        long winnings = calcWinnings(sl1, sl2, sl3, sl4, sl5, sl6, sl7, bids);

        lap(winnings);
    }

    @Override
    public void solvePartTwo(List<String> input) {
        HashMap<String, String> bids = getBids(input);
        // Create 7 lists, one for each hand strength
        List<String> sl7 = new ArrayList<>();
        List<String> sl6 = new ArrayList<>();
        List<String> sl5 = new ArrayList<>();
        List<String> sl4 = new ArrayList<>();
        List<String> sl3 = new ArrayList<>();
        List<String> sl2 = new ArrayList<>();
        List<String> sl1 = new ArrayList<>();


        // Populate strength lists
        for (String s : bids.keySet()) {
            switch (p2strength(s)) {
                case 1 -> sl1.add(s);
                case 2 -> sl2.add(s);
                case 3 -> sl3.add(s);
                case 4 -> sl4.add(s);
                case 5 -> sl5.add(s);
                case 6 -> sl6.add(s);
                case 7 -> sl7.add(s);
            }
        }


        // Sort each list low to high ranking (tiebreakers)
        sorter(sl1, false);
        sorter(sl2, false);
        sorter(sl3, false);
        sorter(sl4, false);
        sorter(sl5, false);
        sorter(sl6, false);
        sorter(sl7, false);

        long winnings = calcWinnings(sl1, sl2, sl3, sl4, sl5, sl6, sl7, bids);

        lap(winnings);

    }

    private int p2strength(String hand) {
        if (hand.contains("J")) {
            int maxval = 0;
            List<String> possibles = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "T", "Q", "K", "A");
            for (String possible : possibles) {
                String h2 = hand;
                h2 = h2.replaceAll("J", possible);
                maxval = Math.max(calcStrength(h2), maxval);
            }

            return maxval;
        } else {
            return calcStrength(hand);
        }
    }

    private int calcStrength(String hand) {
        char[] a = hand.toCharArray();
        Arrays.sort(a);

        if (a[0] == a[1] && a[1] == a[2] && a[2] == a[3] && a[3] == a[4]) {
            return 7;
        } else if (((a[0] == a[1]) && (a[1] == a[2]) && (a[2] == a[3])) || (a[1] == a[2]) && (a[2] == a[3]) && (a[3] == a[4])) {
            return 6;
        } else if (((a[0] == a[1]) && (a[1] == a[2])) || ((a[1] == a[2]) && (a[2] == a[3])) || ((a[2] == a[3]) && (a[3] == a[4]))) {
            if (((a[0] == a[1]) && (a[1] == a[2]) && (a[3] == a[4])) || ((a[0] == a[1]) && (a[2] == a[3]))) {
                return 5;
            } else {
                return 4;
            }
        } else if (a[0] == a[1] || a[1] == a[2] || a[2] == a[3] || a[3] == a[4]) {
            if ((a[1] == a[2] && a[3] == a[4]) || (a[0] == a[1] && a[3] == a[4]) || (a[0] == a[1] && a[2] == a[3])) {
                return 3;
            } else {
                return 2;
            }
        } else {
            return 1;
        }


    }
}
