package conway.domain;

public class Grid {
    private int rows;
    private int cols;
    private Cell[][] gridrep;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.gridrep = new Cell[rows][cols];
        
      
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.gridrep[i][j] = new Cell(false);
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    
    public Cell getCell(int row, int col) {
        return gridrep[row][col];
    }
}