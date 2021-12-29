package fr.sfeir.aoc;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Application {

    public static void main(String... args) {
        Quarkus.run(Day1.class, args);
    }
}
