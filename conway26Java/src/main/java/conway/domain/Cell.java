package conway.domain;

public class Cell {
    private boolean state; // true = viva, false = morta

    public Cell(boolean initialState) {
        this.state = initialState;
    }

    public boolean isAlive() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}