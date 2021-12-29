package fr.sfeir.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import io.quarkus.runtime.QuarkusApplication;

public class Day1 implements QuarkusApplication {

    @Override
    public int run(String... args) throws Exception {
        return switch (args.length > 0 ? args[0] : "null") {
            case "part1" -> part1();
            case "part2" -> part2();
            default -> 1;
        };
    }

    int part1() throws IOException {
        int measurementCount = 0;
        try (var reader = Files.newBufferedReader(getFilePath())) {
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
        try (var reader = Files.newBufferedReader(getFilePath())) {
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

    private Path getFilePath() {
        return Paths.get(getClass().getClassLoader().getResource("day-1.txt").getPath());
    }
}
