package com.erik;

public class Solver {
    private Grid root;
//    private Grid current;
    private boolean isFinished = false;
    private Grid solution;

    public Solver(String input) {
        this.root = new Grid(input);
//        this.current = new Grid(input);
    }

    public String solve() {
        bt(root);
        return solution.toString();
    }

    private void bt(Grid puzzle) {
        if (isFinished || puzzle.isRejected()) return;
        if (puzzle.isAccepted()) {
            isFinished = true;
            solution = puzzle;
            return;
        }
        Grid s = puzzle.getFirstExtension();
        while (!isFinished) {
            bt(s);
            try {
                s = s.next();
            } catch (Grid.NumberTooLarge numberTooLarge) {
                return;
            }
        }
    }
}
