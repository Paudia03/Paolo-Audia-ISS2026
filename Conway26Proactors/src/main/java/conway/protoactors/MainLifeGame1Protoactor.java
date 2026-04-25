package conway.protoactors;

import main.java.conway.domain.Life;
import main.java.conway.domain.LifeInterface;
import protoactor26.ProtoActorContext26;

public class MainLifeGame1Protoactor {

    public static void main(String[] args) {
        int port = 8070;
        ProtoActorContext26 ctx = new ProtoActorContext26("ctx8070", port);
        LifeInterface life      = new Life(20, 20);
        life.getGrid().setCellValue(10, 9,  true);
        life.getGrid().setCellValue(10, 10, true);
        life.getGrid().setCellValue(10, 11, true);
        OutGuiDev outdev = new OutGuiDev();
        new LifeController1Pattore("lifectrl", life, ctx, outdev);

       String html = "<!DOCTYPE html><html><head>"
    + "</head><body>"
    + "<h2>Conway's Game of Life - Protoactors</h2>"
    + "<button onclick=\"sendCmd('start')\">START</button>"
    + "<button onclick=\"sendCmd('stop')\">STOP</button>"
    + "<button onclick=\"sendCmd('clear')\">CLEAR</button>"
    + "<pre id='grid' style='font-size:20px'></pre>"
    + "<script>"
    + "const ws = new WebSocket('ws://localhost:8070/eval');"
    + "ws.onmessage = e => {"
    + "  const msg = e.data;"
    + "  if (msg.includes('display')) {"
    + "    const content = msg.split(',')[4];"
    + "    document.getElementById('grid').innerText = content;"
    + "  }"
    + "};"
    + "function sendCmd(cmd) {"
    + "  ws.send('msg(' + cmd + ',dispatch,browser,lifectrl,' + cmd + ',0)');"
    + "}"
    + "</script>"
    + "</body></html>";

        ctx.getServer().get("/", c -> c.html(html));

        System.out.println("Avviato su http://localhost:8070");
    }
}