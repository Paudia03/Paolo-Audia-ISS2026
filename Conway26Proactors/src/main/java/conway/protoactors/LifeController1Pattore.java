package conway.protoactors;

import main.java.conway.domain.LifeInterface;
import protoactor26.AbstractProtoactor26;
import protoactor26.ProtoActorContextInterface;
import unibo.basicomm23.interfaces.IApplMessage;
import unibo.basicomm23.utils.CommUtils;

public class LifeController1Pattore extends AbstractProtoactor26 {

    private final LifeInterface life;
    private final OutGuiDev outdev;
    private boolean running = false;

    public LifeController1Pattore(String name, LifeInterface life,
                                   ProtoActorContextInterface ctx, OutGuiDev outdev) {
        super(name, ctx);
        this.life   = life;
        this.outdev = outdev;
    }

    private String gridToString() {
        StringBuilder sb = new StringBuilder();
        int rows = life.getGrid().getRowsNum();
        int cols = life.getGrid().getColsNum();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                sb.append(life.getGrid().getCellValue(r, c) ? "O" : ".");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private void displayGrid() {
    outdev.display(gridToString());
    emitInfo(CommUtils.buildEvent("lifectrl", "display", gridToString()));
}

    @Override
    protected void elabDispatch(IApplMessage m) {
        String payload = m.msgContent();
        CommUtils.outblue(name + " elabDispatch: " + payload);
        switch (payload) {
            case "start" -> { running = true;  CommUtils.outgreen(name + " START"); }
            case "stop"  -> { running = false; CommUtils.outred(name + " STOP"); }
            case "clear" -> { life.getGrid().reset(); displayGrid(); }
            default -> {
                if (payload.startsWith("cell")) {
                    String[] coords = payload.replace("cell(", "").replace(")", "").split(",");
                    int r = Integer.parseInt(coords[0]);
                    int c = Integer.parseInt(coords[1]);
                    boolean cur = life.getGrid().getCellValue(r, c);
                    life.getGrid().setCellValue(r, c, !cur);
                    displayGrid();
                }
            }
        }
    }

    @Override
    protected IApplMessage elabRequest(IApplMessage req) {
        CommUtils.outblue(name + " elabRequest: " + req);
        return CommUtils.buildReply(name, "gridReply", gridToString(), req.msgSender());
    }

    @Override
    protected void elabReply(IApplMessage req) {}

    @Override
    protected void elabEvent(IApplMessage ev) {}

    @Override
    protected void proactiveJob() {
        new Thread(() -> {
            while (true) {
                try {
                    if (running) {
                        life.computeNextGen();
                        displayGrid();
                        Thread.sleep(500);
                    } else {
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }
}