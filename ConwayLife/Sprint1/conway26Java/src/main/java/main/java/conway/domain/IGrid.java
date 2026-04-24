package main.java.conway.domain;

public interface IGrid {
    int getRowsNum();
    int getColsNum();
    ICell getCell(int row, int col);
    
    void setCellValue(int row, int col, boolean value);
    boolean getCellValue(int row, int col);
    
    void reset();
}