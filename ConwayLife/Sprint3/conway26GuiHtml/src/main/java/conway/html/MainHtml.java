package conway.html;

import main.java.conway.domain.Life;
import main.java.conway.domain.LifeInterface;
import main.java.conway.domain.GameController;
import main.java.conway.domain.LifeController;

public class MainHtml {
    public static void main(String[] args) {
        LifeInterface gameModel = new Life(5, 5);

        gameModel.getGrid().setCellValue(2, 1, true);
        gameModel.getGrid().setCellValue(2, 2, true);
        gameModel.getGrid().setCellValue(2, 3, true);

        OutdevHtml htmlView = new OutdevHtml();

        GameController lifeController = new LifeController(gameModel, htmlView);

        new Thread(() -> {
            try {
                lifeController.start(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}