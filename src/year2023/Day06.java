package year2023;

import helpers.AoCSolver;

import java.util.ArrayList;
import java.util.List;

public class Day06 extends AoCSolver {

    public Day06(int year, String day) {
        super(year, day);
    }

    public static void main(String[] args) {
        new Day06(2023, "06");
    }

    @Override
    public void solvePartOne(List<String> input) {
        String ts = input.get(0);
        String ds = input.get(1);

        ts = ts.replace("Time:", "").trim();
        ds = ds.replace("Distance:", "").trim();
        String[] tc = ts.split(" ");
        String[] dc = ds.split(" ");

        List<String> times = new ArrayList<>();
        List<String> dists = new ArrayList<>();
        for (String s : tc) {
            if (!s.isEmpty()) {
                times.add(s);
            }
        }
        for (String s : dc) {
            if (!s.isEmpty()) {
                dists.add(s);
            }
        }

        System.out.println(times);


        int waysToWin = 1;


        for (int i = 0; i < times.size(); i++) {


            int lowerBound = 0, upperBound = 0;
            int recordToBeat = Integer.parseInt(dists.get(i));
            int timeForRace = Integer.parseInt(times.get(i));

            for (int timeHeld = 1; timeHeld < timeForRace; timeHeld++) {
                int timeLeft = timeForRace - timeHeld;

                int distance = timeHeld * timeLeft;
                if (distance > recordToBeat) {
                    lowerBound = timeHeld;
                    break;
                }
            }

            for (int timeHeld = timeForRace; timeHeld > lowerBound; timeHeld--) {
                int timeLeft = timeForRace - timeHeld;

                int distance = timeHeld * timeLeft;
                if (distance > recordToBeat) {
                    upperBound = timeHeld;
                    break;
                }
            }

            waysToWin *= (upperBound - lowerBound + 1);


        }

        lap(waysToWin);
    }

    @Override
    public void solvePartTwo(List<String> input) {
        String time = input.get(0).replace("Time:", "").replaceAll(" ", "");
        String dist = input.get(1).replace("Distance:", "").replaceAll(" ", "");

        System.out.println(time);
        System.out.println(dist);


        long lowerBound = 0, upperBound = 0;
        long recordToBeat = Long.parseLong(dist);
        long timeForRace = Long.parseLong(time)
                ;

        for (int timeHeld = 1; timeHeld < timeForRace; timeHeld++) {
            long timeLeft = timeForRace - timeHeld;

            long distance = timeHeld * timeLeft;
            if (distance > recordToBeat) {
                lowerBound = timeHeld;
                break;
            }
        }

        for (long timeHeld = timeForRace; timeHeld > lowerBound; timeHeld--) {
            long timeLeft = timeForRace - timeHeld;

            long distance = timeHeld * timeLeft;
            if (distance > recordToBeat) {
                upperBound = timeHeld;
                break;
            }
        }

        lap(upperBound - lowerBound + 1);

    }
}
