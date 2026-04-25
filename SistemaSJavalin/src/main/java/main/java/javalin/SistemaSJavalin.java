package main.java.javalin;

import io.javalin.Javalin;
import unibo.basicomm23.utils.CommUtils;

public class SistemaSJavalin {

    public void doJob() {
        Javalin app = Javalin.create();

        String html = "<!DOCTYPE html><html><body>"
            + "<h2>Client WebSocket - /eval</h2>"
            + "<input type='number' id='input' placeholder='Inserisci x' step='any'>"
            + "<button onclick='sendValue()'>Invia</button>"
            + "<div id='log'></div>"
            + "<script>"
            + "const log = document.getElementById('log');"
            + "const ws = new WebSocket('ws://localhost:8080/eval');"
            + "ws.onopen = () => log.innerHTML += '<p style=\"color:gray\">Connesso</p>';"
            + "ws.onmessage = e => log.innerHTML += '<p style=\"color:green\">Risposta: ' + e.data + '</p>';"
            + "ws.onerror = () => log.innerHTML += '<p style=\"color:red\">Errore</p>';"
            + "ws.onclose = () => log.innerHTML += '<p style=\"color:gray\">Chiuso</p>';"
            + "function sendValue() {"
            + "  const val = document.getElementById('input').value;"
            + "  if (val === '') return;"
            + "  ws.send(val);"
            + "  log.innerHTML += '<p style=\"color:blue\">Inviato: ' + val + '</p>';"
            + "}"
            + "</script></body></html>";

        app.get("/", ctx -> ctx.html(html));

        app.ws("/eval", ws -> {
            ws.onConnect(ctx -> {
                System.out.println(">>> Client connesso!");
                ctx.send("welcome");
            });
            ws.onMessage(ctx -> {
                String message = ctx.message();
                System.out.println(">>> Messaggio: " + message);
                try {
                    double x = Double.parseDouble(message);
                    double r = Math.sin(x) + Math.cos(Math.sqrt(3) * x);
                    ctx.send(String.valueOf(r));
                } catch (NumberFormatException e) {
                    ctx.send("Errore: num non valido");
                }
            });
            ws.onClose(ctx -> System.out.println(">>> Chiuso: " + ctx.status() + " " + ctx.reason()));
        });

        app.start(8080);
    }

    public static void main(String[] args) {
        new SistemaSJavalin().doJob();
    }
}