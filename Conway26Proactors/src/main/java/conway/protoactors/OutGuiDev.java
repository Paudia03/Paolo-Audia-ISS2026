package conway.protoactors;

public class OutGuiDev {

    private volatile String currentGrid = "In attesa...";

    public void display(String gridRepresentation) {
        currentGrid = gridRepresentation;
    }

    public String getCurrentGrid() {
        return currentGrid;
    }
}