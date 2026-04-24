package main.java.conway.domain;

import main.java.conway.devices.IOutDev;

public class LifeController implements GameController {
    private final LifeInterface gameModel;
    private final IOutDev outDev;

    // Dependency Injection: il controller non crea le dipendenze, le riceve
    public LifeController(LifeInterface gameModel, IOutDev outDev) {
        this.gameModel = gameModel;
        this.outDev = outDev;
    }

    @Override
    public void start(int generations) throws InterruptedException {
        for (int i = 0; i <= generations; i++) {
            // 1. Aggiorna la vista
            outDev.display(gameModel.getGrid(), i);
            
            // 2. Calcola il prossimo stato (se non è l'ultimo ciclo)
            if (i < generations) {
                gameModel.computeNextGen();
            }
            
            // Pausa di mezzo secondo per rendere l'output leggibile
            Thread.sleep(500); 
        }
    }
}