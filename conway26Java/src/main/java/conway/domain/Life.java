package conway.domain;

public class Life implements LifeInterface {
    private Grid grid;

    public Life(int rows, int cols) {
        this.grid = new Grid(rows, cols); 
    }

    @Override
    public int getRows() {
        return grid.getRows();
    }

    @Override
    public int getCols() {
        return grid.getCols();
    }

    @Override
    public void setCell(int x, int y, boolean alive) {
        if(x >= 0 && x < getRows() && y >= 0 && y < getCols()) {
            grid.getCell(x, y).setState(alive); 
        }
    }

    @Override
    public boolean isAlive(int x, int y) {
        if(x >= 0 && x < getRows() && y >= 0 && y < getCols()) {
            return grid.getCell(x, y).isAlive();
        }
        return false;
    }

    @Override
    public void nextGeneration() {
        int rows = getRows();
        int cols = getCols();
        boolean[][] nextStates = new boolean[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int aliveNeighbors = countNeighborsAlive(i, j);
                boolean currentState = grid.getCell(i, j).isAlive();
                
                if (currentState) {
                    nextStates[i][j] = (aliveNeighbors == 2 || aliveNeighbors == 3);
                } else {
                    nextStates[i][j] = (aliveNeighbors == 3);
                }
            }
        }
        
        // Applica i nuovi stati alle Celle vere
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid.getCell(i, j).setState(nextStates[i][j]);
            }
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                grid.getCell(i, j).setState(false);
            }
        }
    }

    @Override
    public String gridRep() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                sb.append(grid.getCell(i, j).isAlive() ? "1" : "0");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    
    private int countNeighborsAlive(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; 
                int r = row + i;
                int c = col + j;
                if (r >= 0 && r < getRows() && c >= 0 && c < getCols() && grid.getCell(r, c).isAlive()) {
                    count++;
                }
            }
        }
        return count;
    }
}