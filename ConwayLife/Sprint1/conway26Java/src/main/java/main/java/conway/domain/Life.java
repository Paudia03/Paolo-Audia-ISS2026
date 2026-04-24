package main.java.conway.domain;

public class Life implements LifeInterface {
    private final IGrid grid;

    public Life(int rows, int cols) {
        this.grid = new Grid(rows, cols);
    }

    @Override
    public IGrid getGrid() {
        return grid;
    }

    @Override
    public void computeNextGen() {
    	int rows = grid.getRowsNum();
    	int cols = grid.getColsNum();
        boolean[][] nextState = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int neighbors = countNeighbors(r, c);
                boolean alive = grid.getCell(r, c).isAlive();
                nextState[r][c] = alive ? (neighbors == 2 || neighbors == 3) : (neighbors == 3);
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid.getCell(r, c).setStatus(nextState[r][c]);
            }
        }
    }

    private int countNeighbors(int r, int c) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                ICell neighbor = grid.getCell(r + i, c + j);
                if (neighbor != null && neighbor.isAlive()) count++;
            }
        }
        return count;
    }
}