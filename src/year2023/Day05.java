package year2023;

import helpers.AoCSolver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Day05 extends AoCSolver {
    public Day05(int year, String day) {
        super(year, day);
    }

    public static void main(String[] args) {
        new Day05(2023, "05");
    }

    private static String getMapName(String line, String oldName) {
        return switch (line) {
            case "seed-to-soil map:" -> "soil";
            case "soil-to-fertilizer map:" -> "fert";
            case "fertilizer-to-water map:" -> "wate";
            case "water-to-light map:" -> "ligh";
            case "light-to-temperature map:" -> "temp";
            case "temperature-to-humidity map:" -> "humi";
            case "humidity-to-location map:" -> "loca";
            default -> oldName;
        };
    }

    private static void moveLeftovers(List<Long> source, List<Long> destination) {
        Iterator<Long> it = source.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
            it.remove();
        }
    }

    @Override
    public void solvePartOne(List<String> input) {
//        lap(seedToLoc(input));
    }

    private Long seedToLoc(List<String> input) {
        List<Long> seed = new ArrayList<>();
        for (int i = 0; i < input.get(0).replace("seeds: ", "").split(" ").length; i++) {
            String a = input.get(0).replace("seeds: ", "").split(" ")[i];
            seed.add(Long.parseLong(a));
        }


        System.out.println(seed);

        List<Long> soilsMap = new ArrayList<>();
        List<Long> fertilizerMap = new ArrayList<>();
        List<Long> waterMap = new ArrayList<>();
        List<Long> lightMap = new ArrayList<>();
        List<Long> temperatureMap = new ArrayList<>();
        List<Long> humidityMap = new ArrayList<>();
        List<Long> localizationMap = new ArrayList<>();

        String mapName = "";

        for (String line : input) {
            if (line.startsWith("seeds:")) continue;

            mapName = getMapName(line, mapName);

            switch (mapName) {
                case "soil" -> sourceToDest(input, seed, soilsMap, line);
                case "fert" -> {
                    moveLeftovers(seed, soilsMap);
                    sourceToDest(input, soilsMap, fertilizerMap, line);
                }
                case "wate" -> {
                    moveLeftovers(soilsMap, fertilizerMap);
                    sourceToDest(input, fertilizerMap, waterMap, line);
                }
                case "ligh" -> {
                    moveLeftovers(fertilizerMap, waterMap);
                    sourceToDest(input, waterMap, lightMap, line);
                }
                case "temp" -> {
                    moveLeftovers(waterMap, lightMap);
                    sourceToDest(input, lightMap, temperatureMap, line);
                }
                case "humi" -> {
                    moveLeftovers(lightMap, temperatureMap);
                    sourceToDest(input, temperatureMap, humidityMap, line);
                }
                case "loca" -> {
                    moveLeftovers(temperatureMap, humidityMap);
                    sourceToDest(input, humidityMap, localizationMap, line);
                }
            }


        }

        moveLeftovers(humidityMap, localizationMap);
        Collections.sort(localizationMap);
        return localizationMap.get(0);
    }

    private void sourceToDest(List<String> input, List<Long> sourceList, List<Long> destList, String t) {
        if (t.isEmpty() || !Character.isDigit(t.charAt(0))) {
            return;
        }
        String[] mapData = t.split(" ");
        long destRange = Long.parseLong(mapData[0]), sourceRange = Long.parseLong(mapData[1]);
        long ranLen = Long.parseLong(mapData[2]);

        for (long j = 0; j < ranLen; j++) {

            Iterator<Long> it = sourceList.iterator();
            while (it.hasNext()) {

                if (it.next() == sourceRange + j) {
                    long ms = destRange + j;
                    destList.add(ms);
                    it.remove();
                }
            }


        }
    }

    @Override
    public void solvePartTwo(List<String> input) {

        // loop through seeds
        // store min loc value
        // each seed do stuff

        List<String> oneSeedRange = new ArrayList<>();
        String[] line1 = input.get(0).replace("seeds: ", "").split(" ");
        for (int i = 0; i < line1.length; i += 2) {
            for (int j = 0; j < Integer.parseInt(line1[i + 1]); j++) {
                System.out.println(Integer.parseInt(line1[i+1])+j);
            }
        }


    }
}
