# issLab2026
Laboratorio di <b>Ingegneria dei Sistemi Software</b> a.a. 2025/2026 di Paolo Audia

[Testo di riferimento](https://anatali.github.io/issLab2026/_static/docs/Protobook.pdf)

## Diario di Bordo (Chronicle)
INDEX👉 [Apri il Chronicle](https://htmlpreview.github.io/?https://github.com/Paudia03/Paolo-Audia-ISS2026/blob/main/Index.html)

<h2 id="ParteA">Parte A: Dai programmi ai Sistemi a Microservizi</h2>

### Sistema ConwayLife in locale

* [ConwayLife Sprint1](ConwayLife/Sprint1/conway26Java): impostazione di un primo prototipo in Java con dispositivi Mock di I/O. <i>Distribuzione</i>: file jar.
* [ConwayLife Sprint2](ConwayLife/Sprint2/conway26Java): evoluzione del primo prototipo con un dispositivo di output realizzato in Swing. <i>Distribuzione</i>: file jar.

### Sistema ConwayLife con pagine HTML

* [ConwayLife Sprint3](ConwayLife/Sprint3/conway26GuiHtml): evoluzione del sistema usando una pagina HTML come dispositivo di I/O. <i>Distribuzione</i>: Docker.

### Sistemi come servizi

* [SistemaSJavalin](SistemaSJavalin): servizio WebSocket che calcola sin(x) + cos(√3·x). <i>Distribuzione</i>: Docker.

### Sistemi basati su Protoattori

* [SistemaSProtoactor](SistemaSProactor): refactoring di SistemaSJavalin con architettura a protoattori.
* [Conway26Protoactors](Conway26Proactors): ConwayLife con LifeController come pattore proattivo e reattivo.

### Sistemi basati su Attori (QAK)

* [Firefly](firefly): primo modello QAK di una singola lucciola con comportamento autonomo di lampeggio e output su grid HTML.
* [Fireflysynch](fireflysynch): sistema decentralizzato di 3 lucciole che allineano autonomamente la propria frequenza e fase dopo 10 secondi.
* [Fireflysonar](fireflysonar): evoluzione di Fireflysynch con l'introduzione di un Sonar (mock e handler) per forzare la sincronizzazione/desincronizzazione in base alla distanza di un ostacolo.