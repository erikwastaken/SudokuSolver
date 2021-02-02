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
    void acceptsCorrect() {
        String[] input = new String[] {
                "1234",
                "3421",
                "2143",
                "4312"
        };
        Grid cut = new Grid(input);
        Assertions.assertTrue(cut.isAccepted());
    }

    @Test
    void doesNotAcceptIncompleteRow() {
        String[] input = new String[] {
                "1230",
                "3421",
                "2143",
                "4312"
        };
        Grid cut = new Grid(input);
        Assertions.assertFalse(cut.isAccepted());
    }

    @Test
    void doesNotAcceptIncorrectRow() {
        String[] input = new String[] {
                "1231",
                "3421",
                "2143",
                "4312"
        };
        Grid cut = new Grid(input);
        Assertions.assertFalse(cut.isAccepted());
    }

    @Test
    void doesNotAcceptIncompleteColumn() {
        String[] input = new String[] {
                "1234",
                "3421",
                "2143",
                "4310"
        };
        Grid cut = new Grid(input);
        Assertions.assertFalse(cut.isAccepted());
    }

    @Test
    void doesNotAcceptIncorrectColumn() {
        String[] input = new String[] {
                "1234",
                "3421",
                "2143",
                "4314"
        };
        Grid cut = new Grid(input);
        Assertions.assertFalse(cut.isAccepted());
    }

    @Test
    void doesNotAcceptIncorrectSquare() {
        String[] input = new String[] {
                "1234",
                "1421",
                "2143",
                "4312"
        };
        Grid cut = new Grid(input);
    }
}
