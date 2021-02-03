package com.erik;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolverTest {
    @Test
    void solvesPuzzle() {
        Solver cut = new Solver("1234\n3421\n2143\n0000");
        Assertions.assertEquals("1234\n3421\n2143\n4312\n", cut.solve());
    }

    @Test
    void solves3x3Puzzle() {
        Solver cut = new Solver(
                "000260701\n" +
                "680070090\n" +
                "190004500\n" +
                "820100040\n" +
                "004602900\n" +
                "050003028\n" +
                "009300074\n" +
                "040050036\n" +
                "703018000");
        String expected = "435269781\n" +
                "682571493\n" +
                "197834562\n" +
                "826195347\n" +
                "374682915\n" +
                "951743628\n" +
                "519326874\n" +
                "248957136\n" +
                "763418259\n";
        Assertions.assertEquals(expected, cut.solve());
    }
}
