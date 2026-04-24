package main.java.conway.domain;

public class Grid implements IGrid {
    private final int rows;
    private final int cols;
    private final ICell[][] cells;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.cells = new ICell[rows][cols];
        reset();
    }

    @Override
    public int getRowsNum() { return this.rows; }

    @Override
    public int getColsNum() { return this.cols; }

    @Override
    public ICell getCell(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            return cells[row][col];
        }
        return null;
    }

    // Implementazione dei nuovi metodi
    @Override
    public void setCellValue(int row, int col, boolean value) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            cells[row][col].setStatus(value);
        }
    }

    @Override
    public boolean getCellValue(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            return cells[row][col].isAlive();
        }
        return false;
    }

    @Override
    public void reset() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                cells[r][c] = new Cell();
            }
        }
    }
}