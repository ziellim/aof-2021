package fr.sfeir.aoc;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Application {

    public static void main(String... args) {
        if(args.length == 0) return;
        var clazz  = switch (args[0]) {
            case "day1" -> Day1.class;
            case "day2" -> Day2.class;
            default -> null;
        };
        Quarkus.run(clazz, args);
    }
}
