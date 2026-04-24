package main.java.conway.domain;

public class Cell implements ICell {
    private boolean alive;

    public Cell() {
        this.alive = false;
    }

    @Override
    public boolean isAlive() {
        return this.alive;
    }

    @Override
    public void setStatus(boolean status) {
        this.alive = status;
    }
}