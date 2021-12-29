package fr.sfeir.aoc;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import io.quarkus.runtime.QuarkusApplication;

public abstract class AOCApplication implements QuarkusApplication {

    @Override
    public int run(String... args) throws Exception {
        if(args.length == 1) return 1;
        return switch (args[1]) {
            case "part1" -> part1();
            case "part2" -> part2();
            default -> 1;
        };
    }

    abstract int part1() throws IOException;
    abstract int part2() throws IOException;

    protected int toInt(String s) {
        return Integer.parseInt(s);
    }

    protected Path getFilePath(String fileName) {
        return Paths.get(getClass().getClassLoader().getResource(fileName).getPath());
    }

}
