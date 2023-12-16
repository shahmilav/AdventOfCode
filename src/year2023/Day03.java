package year2023;

import helpers.AoCSolver;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class Day03 extends AoCSolver {
    public Day03(int year, String day) {
        super(year, day);
    }

    public static void main(String[] args) {
        new Day03(2023, "03");
    }

    public static boolean isSymbol(char c) {
        String symbols = "*&$-+%/#=@";
        return symbols.contains(c + "");

    }

    private static boolean isItAPart(int count, String str, int i, int lineLen) {
        for (int j = 0; j < count; j++) {


            try {
                if (isSymbol(str.charAt(i + j - 1))) {
                    return true;

                }
            } catch (IndexOutOfBoundsException ignored) {
            }

            try {
                if (isSymbol(str.charAt(i + j + 1))) {
                    return true;

                }
            } catch (IndexOutOfBoundsException ignored) {
            }

            try {
                if (isSymbol(str.charAt(i + j - lineLen))) {
                    return true;

                }
            } catch (IndexOutOfBoundsException ignored) {
            }
            try {
                if (isSymbol(str.charAt(i + j + lineLen))) {
                    return true;

                }
            } catch (IndexOutOfBoundsException ignored) {
            }
            try {
                if (isSymbol(str.charAt(i - lineLen - 1))) {
                    return true;

                }
            } catch (IndexOutOfBoundsException ignored) {
            }
            try {
                if (isSymbol(str.charAt(i + j - lineLen + 1))) {
                    return true;

                }
            } catch (IndexOutOfBoundsException ignored) {
            }
            try {
                if (isSymbol(str.charAt(i + lineLen - 1))) {
                    return true;

                }
            } catch (IndexOutOfBoundsException ignored) {
            }
            try {
                if (isSymbol(str.charAt(i + j + lineLen + 1))) {
                    return true;
                }
            } catch (IndexOutOfBoundsException ignored) {
            }

        }
        return false;
    }

    private static int getNumberLength(int i, String str, int count) {
        for (int j = i; j < i + 3; j++) {
            if (Character.isDigit(str.charAt(j))) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    private static int isGear(int count, String str, int i, int lineLen) {
        for (int j = 0; j < count; j++) {


            try {
                if ((str.charAt(i + j - 1) == '*')) {
                    return i + j - 1;

                }
            } catch (IndexOutOfBoundsException ignored) {
            }

            try {
                if ((str.charAt(i + j + 1) == '*')) {
                    return i + j + 1;

                }
            } catch (IndexOutOfBoundsException ignored) {
            }

            try {
                if ((str.charAt(i + j - lineLen) == '*')) {
                    return i + j - lineLen;

                }
            } catch (IndexOutOfBoundsException ignored) {
            }
            try {
                if ((str.charAt(i + j + lineLen) == '*')) {
                    return i + j + lineLen;

                }
            } catch (IndexOutOfBoundsException ignored) {
            }
            try {
                if ((str.charAt(i - lineLen - 1) == '*')) {
                    return i - lineLen - 1;

                }
            } catch (IndexOutOfBoundsException ignored) {
            }
            try {
                if ((str.charAt(i + j - lineLen + 1) == '*')) {
                    return i + j - lineLen + 1;

                }
            } catch (IndexOutOfBoundsException ignored) {
            }
            try {
                if ((str.charAt(i + lineLen - 1) == '*')) {
                    return i + lineLen - 1;

                }
            } catch (IndexOutOfBoundsException ignored) {
            }
            try {
                if ((str.charAt(i + j + lineLen + 1) == '*')) {
                    return i + j + lineLen + 1;
                }
            } catch (IndexOutOfBoundsException ignored) {
            }

        }
        return -1;
    }

    @Override
    public void solvePartOne(List<String> input) {
        StringBuilder is = new StringBuilder();

        for (String s : input) {
            is.append(s);
        }

        int lineLen = input.get(0).length();
        String str = is.toString();


        boolean isPart;
        int partsSum = 0;

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                int count = 0;
                count = getNumberLength(i, str, count);

                isPart = isItAPart(count, str, i, lineLen);
                String num = str.substring(i, count + i);
                if (isPart) {
                    partsSum += Integer.parseInt(num);
                }
                i += count;
            }
        }
        lap(partsSum);

    }

    @Override
    public void solvePartTwo(List<String> input) {
        StringBuilder inputStr = new StringBuilder();

        for (String s : input) {
            inputStr.append(s);
        }

        int lineLen = input.get(0).length();
        String str = inputStr.toString();

        int gearIndex = 0;

        Dictionary<Integer, List<Integer>> table = new Hashtable<>();
        List<Integer> gears = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                int count = 0;
                count = getNumberLength(i, str, count);

                gearIndex = isGear(count, str, i, lineLen);
                String num = str.substring(i, count + i);
                if (gearIndex > -1) {
                    List<Integer> nums = table.get(gearIndex);

                    if (nums != null) {
                        nums.add(Integer.parseInt(num));
                        table.put(gearIndex, nums);

                    } else {
                        nums = new ArrayList<>();
                        nums.add(Integer.parseInt(num));
                        table.put(gearIndex, nums);
                        gears.add(gearIndex);

                    }
                }
                i += count;
            }
        }

        long gearRatioSums = 0;
        for (Integer gear : gears) {
            List<Integer> ratios = table.get(gear);
            if (ratios.size() == 2) {
                gearRatioSums += (long) ratios.get(0) * ratios.get(1);
            }
        }

        lap(gearRatioSums);
    }

}


//(i + j + lineLen + 1