package com.erik;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GridTest {
    @Test
    void parsesWell() {
        String[] input = new String[] {
                "123",
                "456",
                "789"
        };
        Grid cut = new Grid(input);
        Assertions.assertEquals("123\n456\n789\n", cut.toString());
    }

    @Test
    void acceptsCorrectRows() {
        String[] input = new String[] {
                "123",
                "456",
                "789"
        };
        Grid cut = new Grid(input);
        Assertions.assertTrue(cut.isAccepted());
    }

    @Test
    void doesNotAcceptIncompleteRow() {
        String[] input = new String[] {
                "120",
                "456",
                "789"
        };
        Grid cut = new Grid(input);
        Assertions.assertFalse(cut.isAccepted());
    }

    @Test
    void doesNotAcceptIncorrectRow() {
        String[] input = new String[] {
                "121",
                "456",
                "789"
        };
        Grid cut = new Grid(input);
        Assertions.assertFalse(cut.isAccepted());
    }
}
