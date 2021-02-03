package com.erik;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class GridTest {
    @Nested
    public class Acceptance {
        @Test
        void parsesWell() {
            String[] input = new String[]{
                    "123",
                    "456",
                    "789"
            };
            Grid cut = new Grid(input);
            Assertions.assertEquals("123\n456\n789\n", cut.toString());
        }

        @Test
        void acceptsCorrect() {
            String[] input = new String[]{
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
            String[] input = new String[]{
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
            String[] input = new String[]{
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
            String[] input = new String[]{
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
            String[] input = new String[]{
                    "1234",
                    "3421",
                    "2143",
                    "4314"
            };
            Grid cut = new Grid(input);
            Assertions.assertFalse(cut.isAccepted());
        }
    }

    @Nested
    public class Rejection {
        @Test
        void doesNotRejectIncomplete() {
            String[] input = new String[]{
                    "1230",
                    "3421",
                    "2143",
                    "4312"
            };
            Grid cut = new Grid(input);
            Assertions.assertFalse(cut.isRejected());
        }

        @Test
        void rejectsIncorrectRow() {
            String[] input = new String[]{
                    "1231",
                    "0000",
                    "0000",
                    "0000"
            };
            Grid cut = new Grid(input);
            Assertions.assertTrue(cut.isRejected());
        }

        @Test
        void doesNotRejectInitialGrid() {
            String[] input = new String[]{
                    "0000",
                    "0000",
                    "0000",
                    "0000"
            };
            Grid cut = new Grid(input);
            Assertions.assertFalse(cut.isRejected());
        }

        @Test
        void rejectsIncorrectColumn() {
            String[] input = new String[]{
                    "1000",
                    "1000",
                    "0000",
                    "0000"
            };
            Grid cut = new Grid(input);
            Assertions.assertTrue(cut.isRejected());
        }

        @Test
        void doesNotRejectIncompleteColumn() {
            String[] input = new String[]{
                    "1234",
                    "3421",
                    "2143",
                    "0312"
            };
            Grid cut = new Grid(input);
            Assertions.assertFalse(cut.isRejected());
        }

        @Test
        void rejectsIncorrectSquare1() {
            String[] input = new String[]{
                    "1000",
                    "0100",
                    "0000",
                    "0000"
            };
            Grid cut = new Grid(input);
            Assertions.assertTrue(cut.isRejected());
        }

        @Test
        void rejectsIncorrectSquare2() {
            String[] input = new String[]{
                    "0010",
                    "0001",
                    "0000",
                    "0000"
            };
            Grid cut = new Grid(input);
            Assertions.assertTrue(cut.isRejected());
        }

        @Test
        void rejectsIncorrectSquare3() {
            String[] input = new String[]{
                    "0000",
                    "0000",
                    "1000",
                    "0100"
            };
            Grid cut = new Grid(input);
            Assertions.assertTrue(cut.isRejected());
        }

        @Test
        void rejectsIncorrectSquare4() {
            String[] input = new String[]{
                    "0000",
                    "0000",
                    "0010",
                    "0001"
            };
            Grid cut = new Grid(input);
            Assertions.assertTrue(cut.isRejected());
        }
    }
}
