package fr.sfeir.aoc;

import io.quarkus.test.junit.main.Launch;
import io.quarkus.test.junit.main.LaunchResult;
import io.quarkus.test.junit.main.QuarkusMainTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusMainTest
class Day2Test {

    @Test
    @Launch(value = {"day2", "part1"})
    void testPart1(LaunchResult result) {
        assertEquals("150", result.getOutput());
    }

    @Test
    @Launch(value = {"day2", "part2"})
    void testPart2(LaunchResult result) {
        assertEquals("900", result.getOutput());
    }

}
