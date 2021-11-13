package modelo;

import vista.VistaPrincipal;

public class Main {
	private Main() {};
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new VistaPrincipal("Analizador lexicográfico");
            }
        });
	}
}