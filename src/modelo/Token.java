package modelo;

public class Token {
	private String nombreToken;
	private String nombreSimbolo;
	private String lexema;
	
	public Token(String nombreToken, String lexema) {
		this.nombreToken = nombreToken;
		this.lexema = lexema;
		nombreSimbolo = "_" + lexema;
		
		if(nombreToken.equals("CONST_STR"))
			nombreSimbolo = nombreSimbolo.replace(' ', '_');
	}
	
	public String getNombreToken() {return nombreToken;}
	public String getNombreSimbolo() {return nombreSimbolo;}
	public String getLexema() {return lexema;}
}