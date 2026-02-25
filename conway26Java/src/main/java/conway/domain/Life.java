package conway.domain;

public class Life implements LifeInterface {
    private int rows;
    private int cols;
    private boolean[][] grid;

    public Life(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new boolean[rows][cols];
    }

    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public int getCols() {
        return cols;
    }

    @Override
    public void setCell(int x, int y, boolean alive) {
        if(x >= 0 && x < rows && y >= 0 && y < cols) {
            grid[x][y] = alive;
        }
    }

    @Override
    public boolean isAlive(int x, int y) {
        if(x >= 0 && x < rows && y >= 0 && y < cols) {
            return grid[x][y];
        }
        return false;
    }

    @Override
    public void nextGeneration() {
        boolean[][] nextGrid = new boolean[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int aliveNeighbors = countNeighborsAlive(i, j);
                
                if (grid[i][j]) {
                    // Cella viva: sopravvive se ha 2 o 3 vicini
                    nextGrid[i][j] = (aliveNeighbors == 2 || aliveNeighbors == 3);
                } else {
                    // Cella morta: nasce se ha esattamente 3 vicini
                    nextGrid[i][j] = (aliveNeighbors == 3);
                }
            }
        }
        grid = nextGrid;
    }

    @Override
    public void clear() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = false;
            }
        }
    }

    @Override
    public String gridRep() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append(grid[i][j] ? "1" : "0");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    
    // Metodo di supporto per contare i vicini
    private int countNeighborsAlive(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; 
                int r = row + i;
                int c = col + j;
                if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c]) {
                    count++;
                }
            }
        }
        return count;
    }
}