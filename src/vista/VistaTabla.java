package vista;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.*;
import modelo.Token;
import modelo.Tabla;

public class VistaTabla extends JFrame {
	private JPanel panelCentral;
	
	public VistaTabla (Tabla tablaDeSimbolos) {
		super("Tabla de símbolos");
		
		JTable tabla = new JTable(tablaDeSimbolos.getRegistros(), tablaDeSimbolos.getColumnas());
		
		// Paneles y layouts.
		JScrollPane scroller = new JScrollPane(tabla);
		tabla.setFillsViewportHeight(true);
		tabla.setEnabled(false);
		panelCentral = new JPanel(new BorderLayout());
		panelCentral.add(scroller, BorderLayout.CENTER);
		this.setContentPane(panelCentral);
		
		// Configs del JFrame.
		this.setResizable(false);
        this.setDefaultCloseOperation (JFrame.HIDE_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		centrarVentana();
	}
	
	private void centrarVentana() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);
    }
}