package main.java.protoactor;

import protoactor26.ProtoActorContext26;

public class MainSistemaSAsProtoactor {

   public static void main(String[] args) {
    ProtoActorContext26 ctx = new ProtoActorContext26("ctxSistemaS", 8080);
    new SistemaSAsProtoactor("sistemaS", ctx);

    ctx.getServer().get("/", c -> c.html(
        "<!DOCTYPE html><html><body>"
        + "<h2>Client ProtoActor - /eval</h2>"
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
        + "  const msg = 'msg(eval,request,client,sistemaS,' + val + ',0)';"
        + "  ws.send(msg);"
        + "  log.innerHTML += '<p style=\"color:blue\">Inviato: ' + msg + '</p>';"
        + "}"
        + "</script></body></html>"
    ));

    System.out.println("Avviato su http://localhost:8080");
}
}