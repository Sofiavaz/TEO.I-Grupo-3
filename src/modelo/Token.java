package modelo;

public class Token {
	private String nombre;
	private String lexema;
	
	public Token(String nombre, String lexema) {
		this.nombre = nombre;
		this.lexema = lexema;
	}
	
	public String getNombre() {return nombre;}
	public String getLexema() {return lexema;}
}