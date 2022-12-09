package year2021;

import helpers.FileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day03 {
    public static void main(String[] args) {
        FileManager manager = new FileManager(2021, 3);

        Scanner myReader = manager.generateScanner();
        System.out.println(partOne(myReader));

        myReader = manager.generateScanner();
        System.out.println(partTwo(myReader));
    }

    private static int partOne(Scanner myReader) {

        StringBuilder gamma = new StringBuilder();
        int count0;
        int count1;

        // GENERATE GAMMA
        for (int i = 0; i < 12; i++) {
            count0 = 0;
            count1 = 0;

            while (myReader.hasNextLine()) {
                String s = myReader.nextLine();

                if (s.charAt(i) == '0') count0++;
                else count1++;

                if (!myReader.hasNextLine()) {
                    if (count0 > count1) gamma.append("0");
                    else if (count1 > count0) gamma.append("1");
                    break;
                }
            }

            try {
                myReader = new Scanner(new File("year2021/day03/input.txt"));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        // GENERATE EPSILON

        String epsilon = gamma.toString();
        epsilon = epsilon.replace("0", "n");
        epsilon = epsilon.replace("1", "0");
        epsilon = epsilon.replace("n", "1");

        int e = Integer.parseInt(epsilon, 2);
        int g = Integer.parseInt(gamma.toString(), 2);

        return e * g;
    }

    private static int partTwo(Scanner myReader) {

        int count0;
        int count1;

        String[] bits = new String[1000];

        for (int k = 0; k < 1000; k++) {
            bits[k] = myReader.nextLine();
        }

        for (int i = 0; i < 12; i++) {

            count0 = 0;
            count1 = 0;

            for (String bit : bits) {

                if (!bit.equals("L")) {
                    if (bit.charAt(i) == '0') count0++;
                    else count1++;
                }
            }

            if (count0 > count1) {

                for (int j = 0; j < bits.length; j++) {
                    if (!bits[j].equals("L")) {
                        if (bits[j].charAt(i) == '1') {
                            bits[j] = "L";
                        }
                    }
                }
            } else {

                for (int j = 0; j < bits.length; j++) {
                    if (!bits[j].equals("L")) {
                        if (bits[j].charAt(i) == '0') {
                            bits[j] = "L";
                        }
                    }
                }
            }
        }

        Arrays.sort(bits);
        int oxygenRating = Integer.parseInt(bits[0], 2);

        // ---------------------------------------------------

        try {
            myReader = new Scanner(new File("year2021/day03/input.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (int k = 0; k < 1000; k++) {
            bits[k] = myReader.nextLine();
        }

        myReader.close();

        for (int i = 0; i < 12; i++) {

            count0 = 0;
            count1 = 0;

            for (String bit : bits) {

                if (!bit.equals("L")) {
                    if (bit.charAt(i) == '0') count0++;
                    else count1++;
                }
            }

            if (count0 <= count1) {
                for (int j = 0; j < bits.length; j++) {
                    if (!bits[j].equals("L")) {
                        if (bits[j].charAt(i) == '1') {
                            bits[j] = "L";
                        }
                    }
                }
            } else {
                for (int j = 0; j < bits.length; j++) {
                    if (!bits[j].equals("L")) {

                        if (bits[j].charAt(i) == '0') {
                            bits[j] = "L";
                        }
                    }
                }
            }

            Arrays.sort(bits);
            if (bits[1].equals("L")) break;
        }

        int c02Rating = Integer.parseInt(bits[0], 2);
        return oxygenRating * c02Rating;
    }
}
