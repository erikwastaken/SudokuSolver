package com.erik;

public class Cell {
    private int row;
    private int column;
    private int value = 0;

    public Cell(int row, int column, int value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int getValue() {
        return value;
    }
}
