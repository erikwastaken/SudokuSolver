package com.erik;

import java.util.HashSet;
import java.util.Set;

public class Grid {
    private Cell[][] cells;
    private int size;
    private int squareSize;
    private int currentRow = 0;
    private int currentColumn = 0;

    public Grid(String[] input) {
        parseInputArray(input);
    }

    public Grid(String input) {
        String[] splits = input.split("\n");
        parseInputArray(splits);
    }

    public Grid(String[] input, int row, int col) {
        parseInputArray(input);
        this.currentColumn = col;
        this.currentRow = row;
    }

    private void parseInputArray(String[] input) {
        this.size = input.length;
        this.squareSize = (int) Math.floor(Math.sqrt(this.size));
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

    @Override
    public boolean equals(Object o) {
        return toString().equals(o.toString());
    }

    public boolean isRejected() {
        for (int i=0; i<size; i++) {
            if (isRowRejected(i)) return true;
            if (isColumnRejected(i)) return true;
        }
        return areSquaresRejected();
    }

    private boolean areSquaresRejected() {
        // take the size of the individual squares and generate the corresponding coordinates for the cells;
        for (int k=0; k<squareSize; k++) {
            for (int kk=0; kk<squareSize; kk++) {
                Set<Integer> seen = new HashSet<>();
                for (int j = k * squareSize; j < k*squareSize + squareSize; j++) {
                    for (int jj = kk*squareSize; jj < kk*squareSize + squareSize; jj++) {
                        Cell cell = cells[j][jj];
                        if (cell.getValue() == 0) continue;
                        if (!seen.add(cell.getValue())) return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean isColumnRejected(int j) {
        Set<Integer> seen = new HashSet<>();
        for (int i=0; i<size; i++) {
            Cell cell = cells[i][j];
            if (cell.getValue() == 0) continue;
            if (!seen.add(cell.getValue())) return true;
        }
        return false;
    }

    private boolean isRowRejected(int i) {
        Set<Integer> seen = new HashSet<>();
        for (int j=0; j<size; j++) {
            Cell cell = cells[i][j];
            if (cell.getValue() == 0) continue;
            if (!seen.add(cell.getValue())) return true;
        }
        return false;
    }

    public Grid getFirstExtension() {
        for (int i=0; i<size; i++) {
            for (int ii=0; ii<size; ii++) {
                if (cells[i][ii].getValue() == 0) {
                    String[] splits = toString().split("\n");
                    splits[i] = splits[i].substring(0,ii) + "1" + splits[i].substring(ii+1);
                    return new Grid(splits,i,ii);
                }
            }
        }
        return null;
    }

    public Grid next() throws NumberTooLarge {
        int currentValue = cells[currentRow][currentColumn].getValue();
        if (currentValue == size) throw new NumberTooLarge();
        String[] splits = toString().split("\n");
        splits[currentRow] = splits[currentRow].substring(0,currentColumn) + ++currentValue + splits[currentRow].substring(currentColumn+1);
        return new Grid(splits,currentRow,currentColumn);
    }

    public class NumberTooLarge extends Throwable {
    }
}
