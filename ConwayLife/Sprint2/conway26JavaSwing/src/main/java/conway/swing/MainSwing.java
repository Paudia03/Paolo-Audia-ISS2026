package conway.swing;

// Importiamo dal JAR dello Sprint 1!
import main.java.conway.domain.Life;
import main.java.conway.domain.LifeInterface;
import main.java.conway.domain.GameController;
import main.java.conway.domain.LifeController;

public class MainSwing {
    
    public static void main(String[] args) {
        System.out.println("=== Conway's Game of Life - Avvio Versione Swing ===");
        System.out.println("Caricamento core logico dal JAR dello Sprint 1...");

        // 1. Instanzio il Modello (dal JAR)
        LifeInterface gameModel = new Life(5, 5);
        
        // Setup iniziale (un Blinker orizzontale)
        gameModel.getGrid().setCellValue(2, 1, true);
        gameModel.getGrid().setCellValue(2, 2, true);
        gameModel.getGrid().setCellValue(2, 3, true);
        
        // 2. Instanzio la NUOVA View (Swing)
        OutdevSwing swingView = new OutdevSwing();
        
        // 3. Unisco tutto con il Controller (dal JAR)
        GameController lifeController = new LifeController(gameModel, swingView);
        
        // 4. Avvio la simulazione.
        // Utilizziamo un Thread separato per il loop del gioco, in modo da non 
        // bloccare il Thread principale dell'interfaccia grafica (EDT - Event Dispatch Thread).
        new Thread(() -> {
            try {
                // Eseguiamo 10 generazioni, vedrai la finestra aggiornarsi in tempo reale!
                lifeController.start(10); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}