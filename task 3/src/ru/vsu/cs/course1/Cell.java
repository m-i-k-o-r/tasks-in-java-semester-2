package ru.vsu.cs.course1;

public class Cell {

    private int col;
    private int row;

    public int col(){
        return col;
    }

    public int row(){
        return row;
    }

    public Cell(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public Cell(int [] arr) {
        this.col = arr[0];
        this.row = arr[1];
    }
}
