package vista;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.*;
import modelo.Token;

public class Tabla extends JFrame {
	private JPanel panelCentral;
	
	public Tabla (ArrayList<Token> listaTokens) {
		super("Tabla de símbolos");
	
		// Creación de la tabla.
		String[] columnas = {
			"Nombre",
	        "Token",
	        "Valor",
	        "Longitud"
        };
		
		ArrayList<Token> listaTokensFinal = new ArrayList<Token>();
		for(Token t: listaTokens) {
			switch(t.getNombre()) {
				case "ID_VAR":
				case "CONST_INT":
				case "CONST_FLOAT":
				case "CONST_STR":
					listaTokensFinal.add(t);
					break;
				default:
					break;
			}
		}
		
		Object[][] registros = new Object[listaTokensFinal.size()][4];
		for(int i = 0; i < listaTokensFinal.size(); i++) {
			registros[i][0] = listaTokensFinal.get(i).getLexema();
			registros[i][1] = listaTokensFinal.get(i).getNombre();
			switch(listaTokensFinal.get(i).getNombre()) {
			case "ID_VAR": 
				registros[i][2] = "-";
				registros[i][3] = "-";
				break;
			case "CONST_STR":
				registros[i][0] = "_" + registros[i][0];
				registros[i][0] = ((String) registros[i][0]).replace(' ', '_');
				registros[i][2] = listaTokensFinal.get(i).getLexema();
				registros[i][3] = listaTokensFinal.get(i).getLexema().length();
				break;
			default:
				registros[i][0] = "_" + registros[i][0];
				registros[i][2] = listaTokensFinal.get(i).getLexema();
				registros[i][3] = "-";
			}
		}
		
		JTable tabla = new JTable(registros, columnas);
		
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