package vista;

import modelo.Lexico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Vista extends JFrame {
    private JTextArea textoSalida;
    private JTextField textoUrl;
    private JButton botonAceptar;
    private JLabel labelUrl;
    private JLabel labelResult;
    private JScrollPane panelScrolleable;
    private JPanel panelFlow, panelArriba, panelPrincipal;

    public Vista(String nombre) {
    	super(nombre);
    	
    	
    	// Panel de arriba.
    	panelArriba = new JPanel(new BorderLayout());
	    	panelFlow = new JPanel(new FlowLayout());
	    		labelUrl = new JLabel ("Ingrese el URL del texto a analizar:");
	    		textoUrl = new JTextField (15);
	    		botonAceptar = new JButton ("Aceptar");
	    		panelFlow.add(labelUrl);
	    		panelFlow.add(textoUrl);
	    		panelFlow.add(botonAceptar);
	    	labelResult = new JLabel ("Resultados");
	    	panelArriba.add(panelFlow, BorderLayout.CENTER);
	    	panelArriba.add(labelResult, BorderLayout.PAGE_END);
                
        // Panel scrolleable central. 
        textoSalida = new JTextArea ();
        panelScrolleable = new JScrollPane(textoSalida);

        // Panel principal.
        panelPrincipal = new JPanel(new BorderLayout());
    	panelPrincipal.add(panelArriba, BorderLayout.PAGE_START);
    	panelPrincipal.add(panelScrolleable, BorderLayout.CENTER);
    	
    	// Agrega handler del evento clic sobre el botón.
        botonAceptar.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                start();
            }
        }));
        
        // Configs del JFrame.
        this.setContentPane(panelPrincipal);
        this.setPreferredSize(new Dimension(600, 400));
        this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public void agregarLinea(float linea){
        textoSalida.append(String.valueOf(linea) +'\n');
    }
    public void agregarLinea(String linea){
        textoSalida.append(linea+'\n');
    }

    public void start(){
        if(!textoUrl.getText().isEmpty()) {
    	
	    	FileReader reader;
	        textoSalida.setText("");
	        try {
	            // Carga el archivo de texto desde url
	            reader = new FileReader(textoUrl.getText());
	
	            // Realiza el análisis lexicográfico.
	            Lexico lexer = new Lexico(reader);
	            lexer.agregarVista(this);
	            lexer.yylex();
	        } catch (FileNotFoundException e) {
	            //e.printStackTrace();
	            agregarLinea("Archivo no encontrado");
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.exit(-1);
	        }
        }
    }
}
