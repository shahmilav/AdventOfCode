package year2022;

import helpers.AoCSolver;

import java.util.Arrays;
import java.util.List;

public class Day03 extends AoCSolver {
    public Day03(int year, String day) {
        super(year, day);
    }

    public static void main(String[] args) {
        new Day03(2022, "03");
    }

    private static void charToNumAsString(String[] group2, int i) {
        switch (group2[i].charAt(0)) {
            case ('a') -> group2[i] = "1";
            case ('b') -> group2[i] = "2";
            case ('c') -> group2[i] = "3";
            case ('d') -> group2[i] = "4";
            case ('e') -> group2[i] = "5";
            case ('f') -> group2[i] = "6";
            case ('g') -> group2[i] = "7";
            case ('h') -> group2[i] = "8";
            case ('i') -> group2[i] = "9";
            case ('j') -> group2[i] = "10";
            case ('k') -> group2[i] = "11";
            case ('l') -> group2[i] = "12";
            case ('m') -> group2[i] = "13";
            case ('n') -> group2[i] = "14";
            case ('o') -> group2[i] = "15";
            case ('p') -> group2[i] = "16";
            case ('q') -> group2[i] = "17";
            case ('r') -> group2[i] = "18";
            case ('s') -> group2[i] = "19";
            case ('t') -> group2[i] = "20";
            case ('u') -> group2[i] = "21";
            case ('v') -> group2[i] = "22";
            case ('w') -> group2[i] = "23";
            case ('x') -> group2[i] = "24";
            case ('y') -> group2[i] = "25";
            case ('z') -> group2[i] = "26";
            case ('A') -> group2[i] = "27";
            case ('B') -> group2[i] = "28";
            case ('C') -> group2[i] = "29";
            case ('D') -> group2[i] = "30";
            case ('E') -> group2[i] = "31";
            case ('F') -> group2[i] = "32";
            case ('G') -> group2[i] = "33";
            case ('H') -> group2[i] = "34";
            case ('I') -> group2[i] = "35";
            case ('J') -> group2[i] = "36";
            case ('K') -> group2[i] = "37";
            case ('L') -> group2[i] = "38";
            case ('M') -> group2[i] = "39";
            case ('N') -> group2[i] = "40";
            case ('O') -> group2[i] = "41";
            case ('P') -> group2[i] = "42";
            case ('Q') -> group2[i] = "43";
            case ('R') -> group2[i] = "44";
            case ('S') -> group2[i] = "45";
            case ('T') -> group2[i] = "46";
            case ('U') -> group2[i] = "47";
            case ('V') -> group2[i] = "48";
            case ('W') -> group2[i] = "49";
            case ('X') -> group2[i] = "50";
            case ('Y') -> group2[i] = "51";
            case ('Z') -> group2[i] = "52";
        }
    }

    @Override
    public void solvePartOne(List<String> input) {
        int sum = 0;
        String[] group1;
        String[] group2;

        for (String s : input) {
            int half = s.length() / 2;

            String[] parts = {s.substring(0, half), s.substring(half)};

            group1 = new String[parts[0].length()];
            for (int i = 0; i < parts[0].length(); i++) {
                String m = Character.toString(parts[0].charAt(i));
                group1[i] = m;
            }
            group2 = new String[parts[1].length()];
            for (int i = 0; i < parts[1].length(); i++) {
                String m = Character.toString(parts[1].charAt(i));
                group2[i] = m;
            }

            for (int i = 0; i < group1.length; i++) {
                charToNumAsString(group1, i);
                charToNumAsString(group2, i);
            }

            Arrays.sort(group1);
            Arrays.sort(group2);

            int temp = 0;
            for (String value : group1) {

                for (String item : group2) {
                    if (value.equals(item) && Integer.parseInt(value) != temp) {
                        sum += Integer.parseInt(value);
                        temp = Integer.parseInt(value);
                        break;
                    }
                }
            }
        }

        lap(sum);
    }

    @Override
    public void solvePartTwo(List<String> input) {
        int sum = 0;
        String[] sack1;
        String[] sack2;
        String[] sack3;

        for (int i = 0; i < input.size(); i += 3) {
            String s1 = input.get(i);
            String s2 = input.get(i + 1);
            String s3 = input.get(i + 2);

            // Create sacks
            sack1 = new String[s1.length()];
            for (int j = 0; j < sack1.length; j++) {
                String m = Character.toString(s1.charAt(j));
                sack1[j] = m;
            }
            sack2 = new String[s2.length()];
            for (int j = 0; j < sack2.length; j++) {
                String m = Character.toString(s2.charAt(j));
                sack2[j] = m;
            }
            sack3 = new String[s3.length()];
            for (int j = 0; j < sack3.length; j++) {
                String m = Character.toString(s3.charAt(j));
                sack3[j] = m;
            }

            // Convert sacks to numbers
            for (int j = 0; j < Math.max(Math.max(sack1.length, sack2.length), sack3.length); j++) {
                if (!(j >= sack1.length)) {
                    charToNumAsString(sack1, j);
                }

                if (!(j >= sack2.length)) {
                    charToNumAsString(sack2, j);
                }

                if (!(j >= sack3.length)) {
                    charToNumAsString(sack3, j);
                }
            }

            // Sort sacks
            Arrays.sort(sack1);
            Arrays.sort(sack2);
            Arrays.sort(sack3);

            // Search sacks
            loop:
            for (String s : sack1) {
                for (String item : sack2) {
                    for (String value : sack3) {
                        if (s.equals(item) && value.equals(item)) {
                            sum += Integer.parseInt(item);
                            break loop;
                        }
                    }
                }
            }
        }

        lap(sum);
    }
}
