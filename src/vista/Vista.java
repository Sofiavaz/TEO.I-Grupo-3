package vista;

import modelo.Lexico;
import modelo.Token;
import modelo.parser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.io.IOException;
import java.util.ArrayList;

public class Vista extends JFrame {
    private JTextArea textoSalida, editor;
    private JTextField textoUrl;
    private JButton botonCargar, botonAnalizar, botonMostrarTabla;
    private JLabel labelUrl, labelResult, labelEditor;
    private JScrollPane scrollerSalida, scrollerEditor;
    private JPanel panelFlow, panelArriba, panelMedio, panelAbajo, panelPrincipal;
    private JFrame vistaTabla;
    Lexico lexer;

    public Vista(String nombre) {
    	super(nombre);
    	
    	// Panel de arriba.
    	panelArriba = new JPanel(new BorderLayout());
	    	panelFlow = new JPanel(new FlowLayout());
	    		labelUrl = new JLabel("Ingrese el URL del texto a analizar:");
	    		textoUrl = new JTextField(15);
	    		botonCargar = new JButton("Cargar archivo");
	    		panelFlow.add(labelUrl);
	    		panelFlow.add(textoUrl);
	    		panelFlow.add(botonCargar);
	    	labelEditor = new JLabel("  Editor:");
	    	panelArriba.add(panelFlow, BorderLayout.CENTER);
	    	panelArriba.add(labelEditor, BorderLayout.PAGE_END);	
	    
        // Panel del medio. 
	    panelMedio = new JPanel(new BorderLayout());
	    	botonAnalizar = new JButton("Analizar desde editor");
	    	editor = new JTextArea();
	    	scrollerEditor = new JScrollPane(editor);
	    	panelMedio.add(scrollerEditor, BorderLayout.CENTER);
	    	panelMedio.add(botonAnalizar, BorderLayout.PAGE_END);

        // Panel de abajo.
	    panelAbajo = new JPanel(new BorderLayout());
	    	labelResult = new JLabel ("  Resultados:");
	    	textoSalida = new JTextArea();
	    	textoSalida.setEnabled(false);
	    	scrollerSalida = new JScrollPane(textoSalida);
	    	scrollerSalida.setPreferredSize(new Dimension(100, 200));
	    	botonMostrarTabla = new JButton("Mostrar tabla de símbolos");
	    	panelAbajo.add(labelResult, BorderLayout.PAGE_START);
	    	panelAbajo.add(scrollerSalida, BorderLayout.CENTER);
	    	panelAbajo.add(botonMostrarTabla, BorderLayout.PAGE_END);
        
        // Panel principal.
        panelPrincipal = new JPanel(new BorderLayout());
    	panelPrincipal.add(panelArriba, BorderLayout.PAGE_START);
    	panelPrincipal.add(panelMedio, BorderLayout.CENTER);
    	panelPrincipal.add(panelAbajo, BorderLayout.PAGE_END);
    	
    	// Se agregan los manejadores de eventos.
    	botonCargar.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarArchivo();
            }
        }));
    	botonAnalizar.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                start();
            }
        }));
    	botonMostrarTabla.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarTablaDeSimbolos();
            }
        }));
        
        // Configs del JFrame.
    	this.setResizable(false);
        this.setContentPane(panelPrincipal);
        this.setPreferredSize(new Dimension(600, 500));
        this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        centrarVentana();
    }
    
    public void agregarLinea(String linea){
        textoSalida.append(linea+'\n');
    }
    
    public void limpiarSalida() {
    	textoSalida.setText("");
    }

    private void cargarArchivo() {
        if(!textoUrl.getText().isEmpty()) {
    	
	    	FileReader reader;
	        editor.setText("");
	        try {
	            // Carga el archivo de texto desde url.
	            reader = new FileReader(textoUrl.getText());
	            editor.read(reader, null);
	            
	        } catch (FileNotFoundException e) {
	            textoSalida.setText("");
	        	agregarLinea("Archivo no encontrado");
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.exit(-1);
	        }
        }
    }
    
    private void start() {
        if(!editor.getText().isEmpty()) {
    	
        	StringReader reader = new StringReader(editor.getText()); 
	        textoSalida.setText("");
        	
            // Realiza el análisis lexicográfico.
            lexer = new Lexico(reader);
            lexer.agregarVista(this);
            
            @SuppressWarnings("deprecation")
			parser miParser = new parser(lexer);
            try {
				miParser.parse();
			} catch (Exception e) {
				e.printStackTrace();
			}
            
            /*
            try {
				lexer.next_token();
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(-1);
			}
			*/
        }
    }
    
    private void mostrarTablaDeSimbolos() {
    	if(lexer != null) {
	    	javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
		            ArrayList<Token> listaTokens = lexer.getListaTokens();
	            	vistaTabla = new Tabla(listaTokens);
	            }
	        });
    	}
    }
    
    private void centrarVentana() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);
    }
}