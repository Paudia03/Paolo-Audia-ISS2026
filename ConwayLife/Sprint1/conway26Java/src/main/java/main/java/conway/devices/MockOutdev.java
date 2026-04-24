package main.java.conway.devices;

import main.java.conway.domain.IGrid;
import main.java.conway.devices.IOutDev;

public class MockOutdev implements IOutDev {
    @Override
    public void display(IGrid grid, int generation) {
        System.out.println("Generazione " + generation + ":");
        int rows = grid.getRowsNum();
        int cols = grid.getColsNum();
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(grid.getCellValue(r, c) ? "O " : ". ");
            }
            System.out.println();
        }
        System.out.println("-------------------");
    }
}