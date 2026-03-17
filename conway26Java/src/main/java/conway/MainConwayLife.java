package conway;
import conway.domain.*;
import conway.devices.*;

public class MainConwayLife {
    public static void main(String[] args) {
        System.out.println("Sistema: Inizializzazione in corso...");

        // 1. Inizializziamo il Modello (Il Core)
        LifeInterface gameModel = new Life(5, 5);
        
        // Impostiamo un pattern iniziale (il solito Blinker) per vederlo muoversi
        gameModel.setCell(2, 1, true);
        gameModel.setCell(2, 2, true);
        gameModel.setCell(2, 3, true);

        // 2. Inizializziamo l'Output (Il Device)
        IOutDev outputDevice = new ConwayOutConsole();

        // 3. Inizializziamo il Controller iniettando le dipendenze
        GameController lifeController = new LifeController(gameModel, outputDevice);

        // 4. Avvio del sistema
        System.out.println("Sistema: Inizializzazione completata. Cedo il controllo al LifeController.");
        lifeController.play();
    }
}