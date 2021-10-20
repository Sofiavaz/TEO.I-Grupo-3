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
    private JTextArea urkPath;
    private JTextField textoSalida;
    private JButton botonAceptar;
    private JLabel labelUrl;
    private JLabel labelResult;


    public Vista() {
        //construct components
        urkPath = new JTextArea (5, 5);
        textoSalida = new JTextField (5);
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
        add(urkPath);
        add(textoSalida);
        add(botonAceptar);
        add (labelUrl);
        add (labelResult);

        //set component bounds (only needed by Absolute Positioning)
        urkPath.setBounds (75, 140, 750, 330);
        textoSalida.setBounds (80, 65, 635, 30);
        botonAceptar.setBounds (725, 65, 100, 30);
        labelUrl.setBounds (80, 35, 260, 25);
        labelResult.setBounds (75, 110, 750, 25);
    }

    public void agregarLinea(float linea){
        urkPath.append(String.valueOf(linea) +'\n');
    }
    public void agregarLinea(String linea){
        urkPath.append(linea+'\n');
    }

    public void start(){
        FileReader reader;
        try {
            // Carga el archivo de texto desde url
            reader = new FileReader(textoSalida.getText());

            // Realiza el análisis lexicográfico.
            Lexico lexer = new Lexico(reader);
            lexer.agregarVista(this);
            lexer.yylex();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
