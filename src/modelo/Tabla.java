package modelo;

import java.util.ArrayList;
import java.util.TreeMap;

public class Tabla  {
	private String[] columnas;
	private String[][] registros;
	
	public Tabla (ArrayList<Token> listaTokens) {
		// Creación de la tabla.
		columnas = new String[] {
			"Nombre", // Columna 0.
	        "Token", // Columna 1.
	        "Tipo", // Columna 2.
	        "Valor", // Columna 3.
	        "Longitud" // Columan 4.
        };
		
		ArrayList<Token> listaTokensFinal = new ArrayList<Token>();
		for(Token t: listaTokens) {
			switch(t.getNombreToken()) {
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
		
		registros = new String[listaTokensFinal.size()][5];
		for(int i = 0; i < listaTokensFinal.size(); i++) {
			registros[i][0] = listaTokensFinal.get(i).getNombreSimbolo(); // Columna Nombre.
			registros[i][1] = listaTokensFinal.get(i).getNombreToken(); // Columna Token. 
			registros[i][2] = "-"; // Columna Tipo.
			switch(listaTokensFinal.get(i).getNombreToken()) {
			case "ID_VAR":
				registros[i][3] = "-"; // Columna Valor.
				registros[i][4] = "-"; // Columna Longitud.
				break;
			case "CONST_STR":
				registros[i][3] = listaTokensFinal.get(i).getLexema(); // Columna Valor.
				registros[i][4] =String.valueOf(listaTokensFinal.get(i).getLexema().length()); // Columna Longitud.
				break;
			default:
				registros[i][3] = listaTokensFinal.get(i).getLexema(); // Columna Valor.
				registros[i][4] = "-"; // Columna Longitud.
			}
		}
	}
	
	// Carga en la tabla existente los tipos de las variables.
	public void cargarTiposDeVariables(TreeMap paresIdTipo) {
		String token, lexema;
		for(int fila = 0; fila < registros.length; fila++) {
			token = (String) registros[fila][1];
			if(token.equals("ID_VAR")) {
				lexema = ((String) registros[fila][0]).substring(1);
				registros[fila][2] =paresIdTipo.get(lexema)==null? "Error": (String) paresIdTipo.get(lexema);
			}
		}
	}
	
	public String[] getColumnas() {
		return columnas;
	}
	
	public String[][] getRegistros() {
		return registros;
	}
	
	public boolean idEstaDeclarado(String identificador) {
		String token, lexema;
		boolean estaDeclarado = false;
		
		for(int fila = 0; fila < registros.length; fila++) {
			token = (String) registros[fila][1];
			if(token.equals("ID_VAR")) {
				lexema = ((String) registros[fila][0]).substring(1);
				if(lexema.equals(identificador) && registros[fila][2] != null)
				 estaDeclarado = true;
			}
		}
		
		return estaDeclarado;
	}
}