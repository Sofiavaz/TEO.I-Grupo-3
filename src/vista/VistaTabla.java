package vista;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import com.sun.deploy.util.StringUtils;
import modelo.Tabla;

public class VistaTabla extends JFrame {
    private JPanel panelCentral;
    private JButton botonCrearArchivo;

    public VistaTabla(Tabla tablaDeSimbolos) {
        super("Tabla de símbolos");
        botonCrearArchivo = new JButton("Generar archivo de tabla");

        JTable tabla = new JTable(tablaDeSimbolos.getRegistros(), tablaDeSimbolos.getColumnas());

        // Paneles y layouts.
        JScrollPane scroller = new JScrollPane(tabla);
        tabla.setFillsViewportHeight(true);
        tabla.setEnabled(false);
        panelCentral = new JPanel(new BorderLayout());
        panelCentral.add(scroller, BorderLayout.CENTER);
        panelCentral.add(botonCrearArchivo, BorderLayout.AFTER_LAST_LINE);
        this.setContentPane(panelCentral);

        botonCrearArchivo.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarArchivo(tablaDeSimbolos);
            }
        }));

        // Configs del JFrame.
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        centrarVentana();
    }

    private void generarArchivo(Tabla tablaDeSimbolos) {

        try {
            FileWriter myWriter = new FileWriter("ts.txt");
            String[][] registros = tablaDeSimbolos.getRegistros();
            int maxNombre = tablaDeSimbolos.getColumnas()[0].length();
            int maxToken = tablaDeSimbolos.getColumnas()[1].length();
            int maxTipo = tablaDeSimbolos.getColumnas()[2].length();
            int maxValor = tablaDeSimbolos.getColumnas()[3].length();
            int maxLongitud = tablaDeSimbolos.getColumnas()[4].length();
            String primerLinea = "";
            for (int i = 0; i < registros.length-1; i++) {
                maxNombre = Math.max(registros[i][0].length(), maxNombre);
                maxToken = Math.max(registros[i][1].length(), maxToken);
                maxTipo = Math.max(registros[i][2].length(), maxTipo);
                maxValor = Math.max(registros[i][3].length(), maxValor);
                maxLongitud = Math.max(registros[i][4].length(), maxLongitud);
            }
            maxNombre++;
            maxLongitud++;
            maxToken++;
            maxTipo++;
            maxValor++;
            myWriter.write(String.format("%-" + (maxNombre - tablaDeSimbolos.getColumnas()[0].length()) + "s", tablaDeSimbolos.getColumnas()[0]));
            myWriter.append(String.format("%-" + (maxToken - tablaDeSimbolos.getColumnas()[1].length()) + "s", tablaDeSimbolos.getColumnas()[1]));
            myWriter.append(String.format("%-" + (maxTipo - tablaDeSimbolos.getColumnas()[2].length()) + "s", tablaDeSimbolos.getColumnas()[2]));
            myWriter.append(String.format("%-" + (maxValor - tablaDeSimbolos.getColumnas()[3].length()) + "s", tablaDeSimbolos.getColumnas()[3]));
            myWriter.append(String.format("%-" + (maxLongitud - tablaDeSimbolos.getColumnas()[4].length()) + "s", tablaDeSimbolos.getColumnas()[4]));
            myWriter.append("\n");
            for (int i = 0; i < registros.length; i++) {
                myWriter.append(String.format("%-" + (maxNombre - registros[i][0].length()) + "s", registros[i][0]));
                myWriter.append(String.format("%-" + (maxToken - registros[i][1].length()) + "s", registros[i][1]));
                myWriter.append(String.format("%-" + (maxTipo - registros[i][2].length()) + "s", registros[i][2]));
                myWriter.append(String.format("%-" + (maxValor - registros[i][3].length()) + "s", registros[i][3]));
                myWriter.append(String.format("%-" + (maxLongitud - registros[i][4].length()) + "s", registros[i][4]));
                myWriter.append("\n");
            }

            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void centrarVentana() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);
    }
}