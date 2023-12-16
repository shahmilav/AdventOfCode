package helpers;

import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public abstract class AoCSolver {

    private final String day;
    private int part = 1;
    private long timerStart;

    public AoCSolver(int year, String day) {
        this.day = day;
        File file = new File("src/year" + year + "/inputs/day" + day + ".in");
        if (!file.exists()) {
            timerStart = System.nanoTime();
            solve(new ArrayList<>());
            return;
        }

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.err.println("File not found!!");
            timerStart = System.nanoTime();
            solve(new ArrayList<>());
            return;
        }

        List<String> inputLines = new ArrayList<>();
        try {
            String line;
            while ((line = reader.readLine()) != null) inputLines.add(line);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        timerStart = System.nanoTime();
        solve(inputLines);
    }


    /**
     * Solves the puzzle
     *
     * @param input the file input.
     */
    private void solve(List<String> input) {
        System.out.println("Timer Started @ "+LocalTime.now());
        solvePartOne(input);
        solvePartTwo(input);
    }

    /**
     * Solves part one of the puzzle.
     *
     * @param input the file input.
     */
    public abstract void solvePartOne(List<String> input);

    /**
     * Solves part two of the puzzle.
     *
     * @param input the file input.
     */
    public abstract void solvePartTwo(List<String> input);

    /**
     * Times and prints the answer.
     *
     * @param answer the answer
     */
    public void lap(int answer) {
        lap(String.valueOf(answer));
    }

    /**
     * Times and prints the answer.
     *
     * @param answer the answer
     */
    public void lap(long answer) {
        lap(String.valueOf(answer));
    }

    /**
     * Times and prints the answer.
     *
     * @param answer the answer
     */
    public void lap(String answer) {

        if (part == 1) {
            System.out.println("-- Day " + day + " -- \n");
        }
        long timeSpent = (System.nanoTime() - timerStart) / 1000;
        System.out.println("Part " + part + ": " + answer + ", Duration: " + timeToString(timeSpent));
        timerStart = System.nanoTime();
        part++;
    }

    public String timeToString(long timeSpent) {
        if (timeSpent < 1000) {
            return timeSpent + "µs";
        } else if (timeSpent < 1000000) {
            return (timeSpent / 1000.0) + "ms";
        } else {
            return (timeSpent / 1000000.0) + "s";
        }
    }
}
