package com.erik;

import java.util.HashSet;
import java.util.Set;

public class Grid {
    private Cell[][] cells;
    private int size;

    public Grid(String[] input) {
        this.size = input.length;
        this.cells = new Cell[size][size];
        for (int i = 0; i<size; i++) {
            String[] splits = input[i].split("");
            for (int ii = 0; ii<size; ii++) {
                cells[i][ii] = new Cell(i,ii, Integer.parseInt(splits[ii]));
            }
        }
    }

    public boolean isAccepted() {
        if (!isComplete()) return false;
        for (int i=0; i<size; i++) {
            if (!isRowAccepted(i)) return false;
            if (!isColumnAccepted(i)) return false;
        }
        return true;
    }

    private boolean isComplete() {
        for (int i=0; i<size; i++) {
            for (int ii=0; ii<size; ii++) {
                if (cells[i][ii].getValue() == 0) return false;
            }
        }
        return true;
    }

    private boolean isRowAccepted(int i) {
        Set<Integer> row = new HashSet<>();
        for (int j=0; j<size; j++) {
            Cell cell = cells[i][j];
            if (!row.add(cell.getValue())) return false;
        }
        return true;
    }

    private boolean isColumnAccepted(int j) {
        Set<Integer> row = new HashSet<>();
        for (int i=0; i<size; i++) {
            Cell cell = cells[i][j];
            if (!row.add(cell.getValue())) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i=0; i<size; i++) {
            for (int ii=0; ii<size; ii++) {
                result.append(cells[i][ii].toString());
            }
            result.append("\n");
        }
        return result.toString();
    }
}
