package conway.html;

import io.javalin.Javalin;
import main.java.conway.domain.IGrid;
import main.java.conway.devices.IOutDev;

public class OutdevHtml implements IOutDev {
    private volatile String currentPage = "<h2>In attesa della prima generazione...</h2>";

    public OutdevHtml() {
        Javalin.create()
            .get("/grid", ctx -> ctx.html(currentPage))
            .start(7000);

        System.out.println("Server avviato → http://localhost:7000/grid");
    }

    @Override
    public void display(IGrid grid, int generation) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head>")
          .append("<meta http-equiv='refresh' content='1'>")
          .append("</head><body>");
        sb.append("<h2>Generazione ").append(generation).append("</h2>");
        sb.append("<table style='font-family:monospace; font-size:24px; border-collapse:collapse;'>");

        for (int r = 0; r < grid.getRowsNum(); r++) {
            sb.append("<tr>");
            for (int c = 0; c < grid.getColsNum(); c++) {
                sb.append("<td style='padding:6px;'>")
                  .append(grid.getCellValue(r, c) ? "O" : ".")
                  .append("<meta http-equiv='refresh' content='0.5'>");
            }
            sb.append("</tr>");
        }

        sb.append("</table></body></html>");
        currentPage = sb.toString();
    }
}