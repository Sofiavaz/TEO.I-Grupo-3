package vista;

import modelo.Lexico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Vista extends JPanel{
    private JTextArea textoSalida;
    private JTextField textoUrl;
    private JButton botonAceptar;
    private JLabel labelUrl;
    private JLabel labelResult;


    public Vista() {
        //construct components
        textoSalida = new JTextArea (5, 5);
        textoUrl = new JTextField (5);
        botonAceptar = new JButton ("Aceptar");
        labelUrl = new JLabel ("Ingrese el URl de el texto a analizar");
        labelResult = new JLabel ("Resultados");

        //adjust size and set layout
        setPreferredSize(new Dimension(944, 563));
        setLayout(null);
        botonAceptar.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                start();
            }}));

            //add components
        add(textoSalida);
        add(textoUrl);
        add(botonAceptar);
        add (labelUrl);
        add (labelResult);

        //set component bounds (only needed by Absolute Positioning)
        textoSalida.setBounds (75, 140, 750, 330);
        textoUrl.setBounds (80, 65, 635, 30);
        botonAceptar.setBounds (725, 65, 100, 30);
        labelUrl.setBounds (80, 35, 260, 25);
        labelResult.setBounds (75, 110, 750, 25);
    }

    public void agregarLinea(float linea){
        textoSalida.append(String.valueOf(linea) +'\n');
    }
    public void agregarLinea(String linea){
        textoSalida.append(linea+'\n');
    }

    public void start(){
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
            e.printStackTrace();
            agregarLinea("Archivo no encontrado");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
