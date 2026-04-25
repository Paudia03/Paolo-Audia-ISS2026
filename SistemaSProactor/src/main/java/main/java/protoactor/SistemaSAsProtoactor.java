package main.java.protoactor;

import protoactor26.AbstractProtoactor26;
import protoactor26.ProtoActorContextInterface;
import unibo.basicomm23.interfaces.IApplMessage;
import unibo.basicomm23.utils.CommUtils;

public class SistemaSAsProtoactor extends AbstractProtoactor26 {

    public SistemaSAsProtoactor(String name, ProtoActorContextInterface ctx) {
        super(name, ctx);
    }

    protected double eval(double x) {
        return Math.sin(x) + Math.cos(Math.sqrt(3) * x);
    }

    @Override
    protected void elabEvent(IApplMessage ev) {
        CommUtils.outblue(name + " elabEvent: " + ev);
    }

   @Override
protected IApplMessage elabRequest(IApplMessage req) {
    System.out.println(">>> elabRequest chiamato: " + req);
    try {
        double x = Double.parseDouble(req.msgContent());
        double r = eval(x);
        return CommUtils.buildReply(name, "evalReply", String.valueOf(r), req.msgSender());
    } catch (NumberFormatException e) {
        return CommUtils.buildReply(name, "evalReply", "Errore: num non valido", req.msgSender());
    }
}

    @Override
    protected void elabDispatch(IApplMessage req) {
        CommUtils.outblue(name + " elabDispatch: " + req);
        try {
            double x = Double.parseDouble(req.msgContent());
            double r = eval(x);
            CommUtils.outgreen(name + " dispatch result: " + r);
        } catch (NumberFormatException e) {
            CommUtils.outred(name + " Errore: num non valido");
        }
    }

        @Override
    protected void elabReply(IApplMessage req) {
        CommUtils.outblue(name + " elabReply: " + req);
    }

    @Override
    protected void proactiveJob() {
        // nessun comportamento autonomo per ora
    }
}