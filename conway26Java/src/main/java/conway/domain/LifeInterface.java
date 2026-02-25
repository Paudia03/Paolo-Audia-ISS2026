package conway.domain;

public interface LifeInterface {
    int getRows();
    int getCols();
    void setCell(int x, int y, boolean alive);
    boolean isAlive(int x, int y);
    void nextGeneration();
    void clear();
    public String gridRep();
}