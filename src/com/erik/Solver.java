package com.erik;

public class Solver {
    private Grid root;
    private Grid current;
    private boolean isFinished = false;
    private Grid solution;

    public Solver(String input) {
        this.root = new Grid(input);
        this.current = new Grid(input);
    }

    public String solve() {
        bt();
        return solution.toString();
    }

    private void bt() {
        if (isFinished || current.isRejected()) return;
        if (current.isAccepted()) {
            isFinished = true;
            solution = current;
            return;
        }
        current = current.getFirstExtension();
        while (!isFinished) {
            bt();
            current = current.next();
        }
    }
}
