package fr.sfeir.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Day1 extends AOCApplication {

    int part1() throws IOException {
        int measurementCount = 0;
        try (var reader = Files.newBufferedReader(getFilePath("day-1.txt"))) {
            var measurement = reader.readLine();
            String nextMeasurement;
            while ((nextMeasurement = reader.readLine()) != null) {
                if (Integer.parseInt(nextMeasurement) > Integer.parseInt(measurement)) {
                    measurementCount++;
                }
                measurement = nextMeasurement;
            }
        }
        System.out.println(measurementCount);
        return 0;
    }

    int part2() throws IOException {
        int measurementCount = 0;
        try (var reader = Files.newBufferedReader(getFilePath("day-1.txt"))) {
            var firstMeasurement = reader.readLine();
            var secondMeasurement = reader.readLine();
            var thirdMeasurement = reader.readLine();
            String fourthMeasurement;
            while ((fourthMeasurement = reader.readLine()) != null) {
                var firstCleanMeasurement = Integer.parseInt(firstMeasurement) + Integer.parseInt(secondMeasurement) + Integer.parseInt(thirdMeasurement);
                var secondCleanMeasurement = Integer.parseInt(secondMeasurement) + Integer.parseInt(thirdMeasurement) + Integer.parseInt(fourthMeasurement);
                if (secondCleanMeasurement > firstCleanMeasurement) {
                    measurementCount++;
                }
                firstMeasurement = secondMeasurement;
                secondMeasurement = thirdMeasurement;
                thirdMeasurement = fourthMeasurement;
            }
        }
        System.out.println(measurementCount);
        return 0;
    }
}
