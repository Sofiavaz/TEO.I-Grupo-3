package modelo;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
	public static void main(String[] args) {
		FileReader reader;
		
		try {
			// Carga el archivo de texto prueba.txt.
			reader = new FileReader("txt/prueba.txt");
			
			// Realiza el análisis lexicográfico.
			Lexico lexer = new Lexico(reader);
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