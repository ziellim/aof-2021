package fr.sfeir.aoc;

import io.quarkus.test.junit.main.Launch;
import io.quarkus.test.junit.main.LaunchResult;
import io.quarkus.test.junit.main.QuarkusMainTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusMainTest
class Day3Test {

    @Test
    @Launch(value = {"day3", "part1"})
    void testPart1(LaunchResult result) {
        assertEquals("198", result.getOutput());
    }

    @Test
    @Launch(value = {"day3", "part2"})
    void testPart2(LaunchResult result) {
        assertEquals("4830672", result.getOutput());
    }

}
