package year2020;

import helpers.AoCSolver;

import java.util.List;

public class Day04 extends AoCSolver {

    public Day04(String year, String day) {
        super(year, day);
    }

    public static void main(String[] args) {
        new Day04("2020", "04");
    }

    @Override
    public void solvePartOne(List<String> input) {
        int validPasswords = 0;
        int requiredFields;
        for (int i = 0; i < input.size(); i++) {
            requiredFields = 0;

            while (i < input.size() && !input.get(i).isBlank()) {
                String s = input.get(i);
                if (s.contains("byr")) {
                    requiredFields++;
                }
                if (s.contains("iyr")) {
                    requiredFields++;
                }
                if (s.contains("eyr")) {
                    requiredFields++;
                }
                if (s.contains("hgt")) {
                    requiredFields++;
                }
                if (s.contains("hcl")) {
                    requiredFields++;
                }
                if (s.contains("ecl")) {
                    requiredFields++;
                }
                if (s.contains("pid")) {
                    requiredFields++;
                }

                i++;
            }

            if (requiredFields == 7) validPasswords++;
        }

        lap(validPasswords);
    }

    @Override
    public void solvePartTwo(List<String> input) {
        int requiredFields;
        int validPassports = 0;
        for (int i = 0; i < input.size(); i++) {

            StringBuilder s = new StringBuilder(input.get(i));
            while (i < input.size() - 1 && !input.get(i).isBlank()) {
                i++;
                s.append(" ").append(input.get(i));
            }

            String[] constraints = s.toString().split(" ");
            requiredFields = 0;

            for (String constraint : constraints) {
                String[] thisConst = constraint.split(":");

                switch (thisConst[0]) {
                    case ("byr") -> {
                        if (Integer.parseInt(thisConst[1]) >= 1920
                                && Integer.parseInt(thisConst[1]) <= 2002) {
                            requiredFields++;
                        }
                    }
                    case ("iyr") -> {
                        if (Integer.parseInt(thisConst[1]) >= 2010
                                && Integer.parseInt(thisConst[1]) <= 2020) {
                            requiredFields++;
                        }
                    }
                    case ("eyr") -> {
                        if (Integer.parseInt(thisConst[1]) >= 2020
                                && Integer.parseInt(thisConst[1]) <= 2030) {
                            requiredFields++;
                        }
                    }
                    case ("hgt") -> {
                        if (thisConst[1].contains("cm")) {
                            thisConst[1] = thisConst[1].replace("cm", "");
                            int a = Integer.parseInt(thisConst[1]);

                            if ((a >= 150) && (a <= 193)) {
                                requiredFields++;
                            }

                        } else if (thisConst[1].contains("in")) {
                            thisConst[1] = thisConst[1].replace("in", "");
                            int a = Integer.parseInt(thisConst[1]);
                            if ((a >= 59) && (a <= 76)) {
                                requiredFields++;
                            }
                        }
                    }
                    case ("hcl") -> {
                        if (thisConst[1].charAt(0) == '#' && thisConst[1].length() == 7) {

                            thisConst[1] = thisConst[1].replace("#", "");
                            boolean isValid = false;
                            for (int j = 0; j < 6; j++) {
                                if (thisConst[1].charAt(j) == 'a'
                                        || thisConst[1].charAt(j) == 'b'
                                        || thisConst[1].charAt(j) == 'c'
                                        || thisConst[1].charAt(j) == 'd'
                                        || thisConst[1].charAt(j) == 'e'
                                        || thisConst[1].charAt(j) == 'f'
                                        || thisConst[1].charAt(j) == '0'
                                        || thisConst[1].charAt(j) == '1'
                                        || thisConst[1].charAt(j) == '2'
                                        || thisConst[1].charAt(j) == '3'
                                        || thisConst[1].charAt(j) == '4'
                                        || thisConst[1].charAt(j) == '5'
                                        || thisConst[1].charAt(j) == '6'
                                        || thisConst[1].charAt(j) == '7'
                                        || thisConst[1].charAt(j) == '8'
                                        || thisConst[1].charAt(j) == '9') {
                                    isValid = true;
                                } else {
                                    isValid = false;
                                    break;
                                }
                            }

                            if (isValid) {
                                requiredFields++;
                            }
                        }
                    }
                    case ("ecl") -> {
                        if (thisConst[1].equals("amb")
                                || thisConst[1].equals("blu")
                                || thisConst[1].equals("brn")
                                || thisConst[1].equals("gry")
                                || thisConst[1].equals("grn")
                                || thisConst[1].equals("hzl")
                                || thisConst[1].equals("oth")) {
                            requiredFields++;
                        }
                    }
                    case ("pid") -> {
                        if (thisConst[1].length() == 9) {
                            boolean validField = false;
                            for (int t = 0; t < thisConst.length; t++) {
                                if (thisConst[1].charAt(t) == '0'
                                        || thisConst[1].charAt(t) == '1'
                                        || thisConst[1].charAt(t) == '2'
                                        || thisConst[1].charAt(t) == '3'
                                        || thisConst[1].charAt(t) == '4'
                                        || thisConst[1].charAt(t) == '5'
                                        || thisConst[1].charAt(t) == '6'
                                        || thisConst[1].charAt(t) == '7'
                                        || thisConst[1].charAt(t) == '8'
                                        || thisConst[1].charAt(t) == '9') validField = true;
                                else {
                                    validField = false;
                                    break;
                                }
                            }
                            if (validField) {
                                requiredFields++;
                            }
                        }
                    }
                    default -> {}
                }
            }

            if (requiredFields == 7) {
                validPassports++;
            }
        }

        lap(validPassports);
    }
}
