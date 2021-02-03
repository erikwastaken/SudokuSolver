package com.erik;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolverTest {
    @Test
    void solvesPuzzle() {
        Solver cut = new Solver("1234\n3421\n2143\n0000");
        Assertions.assertEquals("1234\n3421\n2143\n4312\n", cut.solve());
    }
}
