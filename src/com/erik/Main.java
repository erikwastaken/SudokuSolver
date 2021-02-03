package com.erik;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Error, provide a file path to the puzzle");
            return;
        }
        try {
            String input = Files.readString(Path.of(args[0]));
            Solver s = new Solver(input);
            System.out.println(s.solve());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
