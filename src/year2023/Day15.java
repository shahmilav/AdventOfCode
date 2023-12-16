package year2023;

import helpers.AoCSolver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Day15 extends AoCSolver {
    public Day15(int year, String day) {
        super(year, day);
    }

    public static void main(String[] args) {
        new Day15(2023, "15");
    }

    private static int HASH(char[] chars) {
        int currentValue = 0;
        for (char c : chars) {
            currentValue += c;
            currentValue *= 17;
            currentValue %= 256;
        }
        return currentValue;
    }

    @Override
    public void solvePartOne(List<String> input) {
        String line = input.get(0);

        String[] seq = line.split(",");

        int total = 0;
        for (int i = 0; i < seq.length; i++) {
            int currentValue = 0;
            char[] chars = seq[i].toCharArray();

            currentValue = HASH(chars);

            total += currentValue;

        }

        lap(total);
    }

    @Override
    public void solvePartTwo(List<String> input) {
        List<List<String>> boxes = new ArrayList<>();
        for (int i = 0; i < 256; i++) {
            List<String> strl = new ArrayList<>();
            strl.add("");
            boxes.add(strl);
        }

        String ln = input.get(0);
        String[] data = ln.split(",");


        for (String datum : data) {
            String str = datum.replaceAll("-", "").replaceAll("=", "").replaceAll("[0-9]", "");
            int boxNumber = HASH(str.toCharArray());
            if (datum.contains("-")) {
                System.out.println("--" + datum);
                boxes.get(boxNumber).remove(datum);
                Iterator<String> it = boxes.get(boxNumber).iterator();
                for (int i = 0; i < boxes.get(boxNumber).size(); i++) {
                    it.next();

                    if (boxes.get(boxNumber).get(i).contains(datum.replace("-", ""))) {
                        it.remove();
                    }
                }
            } else {
                if (boxes.get(boxNumber).isEmpty()) {
                    boxes.get(boxNumber).add(datum);

                }else if (boxes.get(boxNumber).get(0).isEmpty()) {
                    boxes.get(boxNumber).set(0, datum);

                } else {
                    boolean ex = false;
                    for (int j = 0; j < boxes.get(boxNumber).size(); j++) {
                        String label = datum.replace("=", "").replaceAll("[0-9]", "");
                        System.out.println(label);
                        if (boxes.get(boxNumber).get(j).contains(label)) {
                            boxes.get(boxNumber).set(j, datum);
                            ex = true;
                            break;
                        }


                    }
                    if (!ex) {
                        boxes.get(boxNumber).add(datum);
                    }
                }


            }

            System.out.println(boxes);
        }

        // Boxes Sorted !!

        int sum = 0;
        for (int i = 0; i < boxes.size(); i++) {
            if (boxes.get(i).isEmpty() || boxes.get(i).get(0).isEmpty()) continue;

            for (int j = 0; j < boxes.get(i).size(); j++) {
                String lens = boxes.get(i).get(j);
                lens =lens.replaceAll("[^\\d]", "");


                sum += ((i + 1) * (j + 1) * Integer.parseInt(lens));
            }
        }

        lap(sum);

    }
}
