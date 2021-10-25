package modelo;

public class Token {
	private String nombreToken;
	private String nombreSimbolo;
	private String lexema;
	private static int sigValor;
	
	public Token(String nombreToken, String lexema, boolean duplicado) {
		this.nombreToken = nombreToken;
		this.lexema = lexema;
		if(duplicado) {
			// Si hay duplicados, añade sigValor al nombre del símbolo
			// para que no haya duplicados.
			nombreSimbolo = "_" + lexema + "_" + sigValor++;
		} else nombreSimbolo = "_" + lexema;
		
		if(nombreToken.equals("CONST_STR"))
			nombreSimbolo = nombreSimbolo.replace(' ', '_');
	}
	
	public String getNombreToken() {return nombreToken;}
	public String getNombreSimbolo() {return nombreSimbolo;}
	public String getLexema() {return lexema;}
}