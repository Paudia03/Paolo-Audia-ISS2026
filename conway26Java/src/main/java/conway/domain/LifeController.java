package conway.domain;

import java.util.concurrent.TimeUnit;

public class LifeController implements GameController {
    private LifeInterface gameModel;
    private IOutDev outDev;

    // Dependency Injection: il controller RICEVE il modello e l'output, non li crea!
    public LifeController(LifeInterface gameModel, IOutDev outDev) {
        this.gameModel = gameModel;
        this.outDev = outDev;
    }

    @Override
    public void play() {
        outDev.display("=== GAME STARTED ===\n" + gameModel.gridRep());
        try {
            // Facciamo fare al gioco 5 cicli in automatico (Mocking del tempo che passa)
            for (int i = 1; i <= 5; i++) {
                TimeUnit.SECONDS.sleep(1); // Aspetta 1 secondo tra una generazione e l'altra
                gameModel.nextGeneration();
                outDev.display("Generazione " + i + "\n" + gameModel.gridRep());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}