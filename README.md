# issLab2026
Laboratorio di <b>Ingegneria dei Sistemi Software</b> a.a. 2025/2026 di Paolo Audia

[Testo di riferimento](https://anatali.github.io/issLab2026/_static/docs/Protobook.pdf)

## Diario di Bordo (Chronicle)
INDEX👉 [Apri il Chronicle](https://htmlpreview.github.io/?https://github.com/Paudia03/Paolo-Audia-ISS2026/blob/main/conway26Java/userDocs/index.html)

<h2 id="ParteA">Parte A: Dai programmi ai Sistemi a Microservizi</h2>

### Sistema ConwayLife in locale
[Riferimento: conway26Java Dai requisiti al deployment](https://anatali.github.io/issLab2026/Project%20conway26Java.html#conway26java-dai-requisiti-al-deployment)

* [ConwayLife Sprint1](ConwayLife/Sprint1/conway26Java): impostazione di un primo prototipo in Java con dispositivi Mock di I/O. <i>Distribuzione</i>: file jar.
* [ConwayLife Sprint2](ConwayLife/Sprint2/conway26Java): evoluzione del primo prototipo con un dispositivo di output realizzato in Swing. <i>Distribuzione</i>: file jar.

### Sistema ConwayLife con pagine HTML

* [ConwayLife Sprint3](ConwayLife/Sprint3/conway26GuiHtml): evoluzione del sistema usando una pagina HTML come dispositivo di I/O. <i>Distribuzione</i>: Docker.

### Sistemi come servizi

* [SistemaSJavalin](SistemaSJavalin): servizio WebSocket in Java che calcola sin(x) + cos(√3·x). <i>Distribuzione</i>: Docker.

### Sistemi basati su Protoattori

* [SistemaSProtoactor](SistemaSProtoactor): refactoring di SistemaSJavalin usando il modello a protoattori. Il calcolo è delegato a un pattore con coda FIFO. <i>Distribuzione</i>: locale.
* [Conway26Protoactors](Conway26Protoactors): evoluzione di ConwayLife con architettura a protoattori. Il LifeController è un pattore proattivo (genera le epoche) e reattivo (riceve comandi START/STOP/CLEAR dal browser via WebSocket). <i>Distribuzione</i>: locale.