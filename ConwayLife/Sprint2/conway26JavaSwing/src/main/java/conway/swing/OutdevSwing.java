package conway.swing;

import javax.swing.*;
import java.awt.*;
// Importiamo le interfacce direttamente dal JAR dello Sprint 1!
import main.java.conway.domain.IGrid;
import main.java.conway.devices.IOutDev;

public class OutdevSwing extends JFrame implements IOutDev {
    private JTextArea textArea;

    public OutdevSwing() {
        super("Conway's Game of Life - Swing View");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        textArea = new JTextArea();
        // Usiamo un font "Monospaced" affinché le lettere O e i punti occupino lo stesso spazio, mantenendo la griglia allineata
        textArea.setFont(new Font("Monospaced", Font.BOLD, 24)); 
        textArea.setEditable(false);
        
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        
        setLocationRelativeTo(null); // Centra la finestra nello schermo
        setVisible(true);
    }

    @Override
    public void display(IGrid grid, int generation) {
        StringBuilder sb = new StringBuilder();
        sb.append(" Generazione ").append(generation).append(":\n\n");
        
        int rows = grid.getRowsNum();
        int cols = grid.getColsNum();
        
        for (int r = 0; r < rows; r++) {
            sb.append("  "); // Margine sinistro
            for (int c = 0; c < cols; c++) {
                // Se la cella è viva stampiamo 'O', altrimenti '.'
                sb.append(grid.getCellValue(r, c) ? "O  " : ".  ");
            }
            sb.append("\n");
        }
        
        // Aggiorna l'interfaccia grafica
        textArea.setText(sb.toString());
    }
}