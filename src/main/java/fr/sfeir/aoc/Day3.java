package fr.sfeir.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day3 extends AOCApplication {

    @Override
    int part1() throws IOException {
        String gamaRate, epsilonRate;
        try (var reader = Files.newBufferedReader(getFilePath("day-3.txt"))) {
            var length = reader.lines().findAny().map(String::length).get();
            String line;
            int[] falseCount = new int[length], trueCount = new int[length];
            while ((line = reader.readLine()) != null) {
                for (var i = 0; i < length; i++) {
                    incrementCounters(line.charAt(i), falseCount, trueCount, i);
                }
            }
            var gamaRateBuilder = new StringBuilder();
            var epsilonRateBuilder = new StringBuilder();
            for (var i = 0; i < length; i++) {
                if (trueCount[i] > falseCount[i]) {
                    gamaRateBuilder.append('1');
                    epsilonRateBuilder.append('0');
                } else {
                    gamaRateBuilder.append('0');
                    epsilonRateBuilder.append('1');
                }
            }
            gamaRate = gamaRateBuilder.toString();
            epsilonRate = epsilonRateBuilder.toString();
        }
        System.out.println(toDecimal(gamaRate) * toDecimal(epsilonRate));
        return 0;
    }

    @Override
    int part2() throws IOException {
        String oxygenGeneratorRating, co2ScrubberRating;
        try (var reader = Files.newBufferedReader(getFilePath("day-3.txt"))) {
            var forOxygenList = reader.lines().collect(Collectors.toList());
            var forCo2List = new ArrayList<>(forOxygenList);
            oxygenGeneratorRating = findNumber(forOxygenList, '1', '0');
            co2ScrubberRating = findNumber(forCo2List, '0', '1');
        }
        System.out.println(toDecimal(oxygenGeneratorRating) * toDecimal(co2ScrubberRating));
        return 0;
    }

    private String findNumber(List<String> values, char mostCommon, char leastCommon) {
        int counter = 0;
        while (values.size() > 1) {
            int trueCounter = 0;
            int falseCounter = 0;
            for (String value : values) {
                if (value.charAt(counter) == '1') {
                    trueCounter++;
                } else {
                    falseCounter++;
                }
            }
            for (var it = values.iterator(); it.hasNext(); ) {
                if (it.next().charAt(counter) == (trueCounter >= falseCounter ? leastCommon : mostCommon)) {
                    it.remove();
                }
            }
            counter++;
        }
        return values.get(0);
    }

    private void incrementCounters(char c, int[] falseCount, int[] trueCount, int position) {
        if (c == '1') {
            trueCount[position]++;
        } else {
            falseCount[position]++;
        }
    }

    private int toDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }
}
