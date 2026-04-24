package main.java.conway.domain;


import main.java.conway.domain.Life;
import main.java.conway.domain.LifeInterface;
import main.java.conway.domain.GameController;
import main.java.conway.domain.LifeController;
import main.java.conway.devices.IOutDev;
import main.java.conway.devices.MockOutdev;

public class MainConwayLifeJava {
    
    public static void main(String[] args) {
        System.out.println("=== Conway's Game of Life - MVC Setup ===");
        
        // 1. Creazione Model
        LifeInterface gameModel = new Life(5, 5);
        
        // Setup iniziale (es. un Blinker)
        gameModel.getGrid().setCellValue(2, 1, true);
        gameModel.getGrid().setCellValue(2, 2, true);
        gameModel.getGrid().setCellValue(2, 3, true);
        
        // 2. Creazione View
        IOutDev outputDevice = new MockOutdev();
        
        // 3. Creazione e Avvio Controller
        GameController lifeController = new LifeController(gameModel, outputDevice);
        
        try {
            lifeController.start(3); // Esegue 3 generazioni
        } catch (InterruptedException e) {
            System.err.println("Simulazione interrotta.");
        }
    }
}