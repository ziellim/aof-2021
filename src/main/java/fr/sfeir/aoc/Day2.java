package fr.sfeir.aoc;

import java.io.IOException;
import java.nio.file.Files;

public class Day2 extends AOCApplication {

    @Override
    int part1() throws IOException {
        int position = 0;
        int depth = 0;
        try(var reader = Files.newBufferedReader(getFilePath("day-2.txt"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                var instruction = line.split(" ");
                switch (instruction[0]) {
                    case "forward" -> position += toInt(instruction[1]);
                    case "down" -> depth += toInt(instruction[1]);
                    case "up" -> depth -= toInt(instruction[1]);
                }
            }
        }
        System.out.println(position * depth);
        return 0;
    }

    @Override
    int part2() throws IOException {
        int position = 0;
        int depth = 0;
        int aim = 0;
        try(var reader = Files.newBufferedReader(getFilePath("day-2.txt"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                var instruction = line.split(" ");
                switch (instruction[0]) {
                    case "forward" -> {
                        position += toInt(instruction[1]);
                        depth += aim * toInt(instruction[1]);
                    }
                    case "down" -> aim += toInt(instruction[1]);
                    case "up" -> aim -= toInt(instruction[1]);
                }
            }
        }
        System.out.println(position * depth);
        return 0;
    }
}
