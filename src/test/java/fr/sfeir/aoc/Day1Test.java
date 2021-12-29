package fr.sfeir.aoc;

import io.quarkus.test.junit.main.Launch;
import io.quarkus.test.junit.main.LaunchResult;
import io.quarkus.test.junit.main.QuarkusMainTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusMainTest
class Day1Test {

    @Test
    @Launch(value = {"part1"})
    void testPart1(LaunchResult result) {
        assertEquals("7", result.getOutput());
    }

    @Test
    @Launch(value = {"part2"})
    void testPart2(LaunchResult result) {
        assertEquals("5", result.getOutput());
    }

}
