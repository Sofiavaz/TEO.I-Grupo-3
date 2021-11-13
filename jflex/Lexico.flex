/* ------------------------------------------------------------------ */
/* Importaciones */
/* ------------------------------------------------------------------ */

package modelo; 
import java.util.ArrayList;
import vista.Vista;
import java_cup.runtime.*;


/* ------------------------------------------------------------------ */
%% /* Opciones, código del usuario, y declaraciones */
/* ------------------------------------------------------------------ */

/* Opciones */

%cup // Brinda compatibilidad con CUP, y permite utilizar la functión next_token().
%public // Hace que la clase generada sea pública.
%class Lexico // Nombre de la clase generada.
%line // Permite utilizar la variable this.yyline para obtener el número de línea en que comienza el lexema que se está analizando actualmente.
%column // Permite utilizar la variable this.yycolumn para obtener el número de columna que se está analizando actualmente.

/* Código de usuario */

%{
	// Valores máximos.
	private final int STR_MAX_LEN = 32;  // Son 32 porque contamos las doble comillas de apertura y cierre.
	private final int INT_MAX_LEN = 65536;
	private ArrayList<Token> listaTokens = new ArrayList<Token>();
	private Vista vista;
	
	// Tabla de símbolos.
	// private List<Map<Columna, String>> symtbl;
	
	// Verifica la cantidad de bits del entero recibido como String.
	private boolean checkInt(String s) {
	
		// Verifico que s no esté vacía, o tenga más de 5 dígitos.
		if (s.isEmpty() || s.length() > 5) {
			return false;
		}
		
		try {
		
			// Convierto a integer.
			Integer number = Integer.valueOf(s);
			
			// Verifico que no exceda el máximo valor.
			if (number > INT_MAX_LEN) {
				return false;
			}
			
		} catch(Exception e) {
			vista.agregarLinea("Error parseando lexema " + yytext() + ".");
			vista.agregarLinea(e.toString());
			return false;
		}
		
		return true;
	}

	// Verifica la cantidad de bits del float recibido como String.
	private boolean checkFloat(String s) {
	
		// Verifico que el string no esté vacío.
		if (s.isEmpty()) {
			return false;
		}
		
		try {
		
			// Convierto a float. Si se convierte, el valor está dentro
			// de los valores aceptables para el tipo float de Java.
			float numero = Float.valueOf(s);
			
			if(
				numero == Float.POSITIVE_INFINITY
				||
				numero == Float.NEGATIVE_INFINITY
				||
				Math.abs(numero) < Float.MIN_VALUE
			) return false;  
			
		} catch(Exception e) {
			vista.agregarLinea("Error parseando lexema " + yytext() + ".");
			vista.agregarLinea(e.toString());
			return false;
		}
		
		return true;
	}
	
	// Verifica que el String no tenga más de 30 caracteres.
	private boolean checkStr(String s) {
		if (s.isEmpty() || (s.length() > STR_MAX_LEN)) {
			return false;
		}
		
		return true;
	}
	
	// Imprime cada par token:lexema hallado.
	private void anuncio(String token) {
		vista.agregarLinea("*** Nuevo hallazgo ***");
		if(token.equals("CONST_STR"))
			vista.agregarLinea("\tToken = " + token + "\n\tLexema = '" + yytext() + "'\n");
		else
			vista.agregarLinea("\tToken = " + token + "\n\tLexema = " + yytext() + "\n");	
	}
	
	// Devuelve el valor de símbolo apropiado.
	private Symbol nuevoSimbolo(int codigoSimbolo) {
		anuncio(sym.terminalNames[codigoSimbolo]);
		return new Symbol(codigoSimbolo, yytext());
	}
	
	// Comunica que se encontró un lexema inválido.
	private void anunciarError(String mensaje) {
		vista.limpiarSalida();
		listaTokens.clear();
		vista.agregarLinea("¡Lexema inválido!");
		vista.agregarLinea("\t" + mensaje + "\n");
		throw new Error(mensaje);
	}
	
	// Guarda el par token:lexema en la lista de Tokens interna,
	// si no está duplicado.
	private void guardoToken(String token) {
		String lexema = yytext();
		
		switch(token) {
			case "CONST_STR":
				// Si es String recorta las comillas para
				// que no sean parte del lexema.
				lexema = lexema.substring(1, lexema.length() - 1);
			case "CONST_INT":
			case "CONST_FLOAT":
			case "ID_VAR":
				// Si es una constante o un identificador:
				
				boolean hayDuplicado = false;
				int indice = 0;
				while(!hayDuplicado && indice < listaTokens.size()) {
					if(
						listaTokens.get(indice).getNombreToken().equals(token)
						&&
						listaTokens.get(indice).getLexema().equals(lexema)
					) hayDuplicado = true;
					else indice++;
				} 

				// Si no hay duplicado, guarda el token.
				if(!hayDuplicado) listaTokens.add(new Token(token, lexema));

				break;
			default:
				// Cualquier otro token, lo agrega.
				listaTokens.add(new Token(token, lexema));
								
				break;
		}
	}
	
	// Permite obtener la lista de pares token:lexema.
	public ArrayList<Token> getListaTokens() {
		return listaTokens;
	}
	
	// Permite vincular una vista.
	public void agregarVista(Vista actual) {
		vista = actual;
	}
%}


/* Declaraciones */

ESPACIO = [\r\n\t\f ]

CONST_INT = [0-9]+
CONST_FLOAT = ([0-9]*\.[0-9]+|[0-9]+\.[0-9]*)(e(\+|-)?[0-9][0-9]?)?
//	(
//		[0-9]*\.[0-9]+ -> Permite que el float detectado no tenga dígitos en la parte entera.
//	|
//		[0-9]+\.[0-9]* -> Permite que el float detectado no tenga dígitos en la parte decimal.
//	)
//	(e(\+|-)?[0-9][0-9]?)? -> Opción de utilizar la notación científica como postfijo.
CONST_STR = \"[^\"]*\"

INT = [Ii][Nn][Tt]
FLOAT = [Ff][Ll][Oo][Aa][Tt]
STRING =  [Ss][Tt][Rr][Ii][Nn][Gg]
TIPO_DATO = {INT}|{FLOAT}|{STRING}

ELSE = [Ee][Ll][Ss][Ee]
WHILE = [Ww][Hh][Ii][Ll][Ee]
IF = [Ii][Ff]
WRITE = [Ww][Rr][Ii][Tt][Ee]

COMENTARIO_SIMPLE = \/\/\*[^(\*\/\/)]*\*\/\/
//	\/\/\* -> //*
//	[^(\*\/\/)]* -> Cualquier carácter excepto el conjunto *//
//	\*\/\/ -> *//

COMENTARIO_DOBLE = \/\/\*(\(|\)|\/|[^(\*\/\/)])*\/\/\*(\(|\)|\/|[^(\*\/\/)])*\*\/\/(\(|\)|\/|[^(\*\/\/)])*\*\/\/
//	\/\/\* -> //*
//		(\(|\)|\/|[^(\*\/\/)])* -> Cualquier carácter excepto el conjunto *//, incluyendo los caracteres '(', ')', '/'.
//			\/\/\* -> //*
//			(\(|\)|\/|[^(\*\/\/)])* -> Cualquier carácter excepto el conjunto *//, incluyendo los caracteres '(', ')', '/'.
//			\*\/\/ -> *//
//		(\(|\)|\/|[^(\*\/\/)])* -> Cualquier carácter excepto el conjunto *//, incluyendo los caracteres '(', ')', '/'.
//	\*\/\/ -> *//

COMENTARIO_SIMPLE = \/\/\*(\(|\)|\/|[^(\*\/\/)])*\*\/\/
//	\/\/\* -> //*
//	(\(|\)|\/|[^(\*\/\/)])* -> Cualquier carácter excepto el conjunto *//, incluyendo los caracteres '(', ')', '/'.
//	\*\/\/ -> *//

ID_VAR = [a-zA-Z]([a-zA-Z]|[0-9]|\_)*

POSITION = [Pp][Oo][Ss][Ii][Tt][Ii][Oo][Nn]

DECLARE = [Dd][Ee][Cc][Ll][Aa][Rr][Ee]\.[Ss][Ee][Cc][Tt][Ii][Oo][Nn]
ENDDECLARE = [Ee][Nn][Dd][Dd][Ee][Cc][Ll][Aa][Rr][Ee]\.[Ss][Ee][Cc][Tt][Ii][Oo][Nn]
PROGRAM = [Pp][Rr][Oo][Gg][Rr][Aa][Mm]\.[Ss][Ee][Cc][Tt][Ii][Oo][Nn]
ENDPROGRAM = [Ee][Nn][Dd][Pp][Rr][Oo][Gg][Rr][Aa][Mm]\.[Ss][Ee][Cc][Tt][Ii][Oo][Nn]

AND = [Aa][Nn][Dd]
OR = [Oo][Rr]

/* ------------------------------------------------------------------ */
%% /* Reglas léxicas */
/* ------------------------------------------------------------------ */

<YYINITIAL> {
	{COMENTARIO_DOBLE}		{/* No hace nada. */}
	{COMENTARIO_SIMPLE}		{/* No hace nada. */}
    {DECLARE}				{return nuevoSimbolo(sym.SEC_COMIENZO);}
    {ENDDECLARE}			{return nuevoSimbolo(sym.SEC_FIN);}
    {PROGRAM}				{return nuevoSimbolo(sym.PROG_COMIENZO);}
    {ENDPROGRAM}			{return nuevoSimbolo(sym.PROG_FIN);}
    {POSITION}				{return nuevoSimbolo(sym.POSITION);}
    {WRITE}					{return nuevoSimbolo(sym.WRITE);}
    {IF}					{return nuevoSimbolo(sym.IF);}
    {ELSE}					{return nuevoSimbolo(sym.ELSE);}
    {WHILE}					{return nuevoSimbolo(sym.WHILE);}
    {TIPO_DATO}				{return nuevoSimbolo(sym.TIPO_DATO);}
	"::="					{return nuevoSimbolo(sym.ASIGNA_VAR);}
	":="					{return nuevoSimbolo(sym.ASIGNA_TIPO);}
    "=="					{return nuevoSimbolo(sym.IGUAL);}
    "<>"					{return nuevoSimbolo(sym.DISTINTO);}
    "<"						{return nuevoSimbolo(sym.MENOR);}
    "<="					{return nuevoSimbolo(sym.MENOR_IGUAL);}
    ">"						{return nuevoSimbolo(sym.MAYOR);}
    ">="					{return nuevoSimbolo(sym.MAYOR_IGUAL);}
    {AND}					{return nuevoSimbolo(sym.AND);}
    {OR}					{return nuevoSimbolo(sym.OR);}
    "+"						{return nuevoSimbolo(sym.SUMA);}
    "-"						{return nuevoSimbolo(sym.RESTA);}
    "("						{return nuevoSimbolo(sym.PAR_ABRE);}
	")"						{return nuevoSimbolo(sym.PAR_CIERRA);}
    "{"						{return nuevoSimbolo(sym.LLAVE_ABRE);}
    "}"						{return nuevoSimbolo(sym.LLAVE_CIERRA);}
    "["						{return nuevoSimbolo(sym.COR_ABRE);}
    "]"						{return nuevoSimbolo(sym.COR_CIERRA);}
    ";"						{return nuevoSimbolo(sym.PUNTO_COMA);}
    ","						{return nuevoSimbolo(sym.COMA);}
	{ID_VAR}				{return nuevoSimbolo(sym.ID_VAR);}
	{CONST_INT}				{
								if (!checkInt(yytext())) {
									anunciarError("Lexer: Lexema " + yytext() + " excede el valor máximo de un Integer (" + INT_MAX_LEN + ").\n");	
								} else {
									return nuevoSimbolo(sym.CONST_INT);
								}
							}
	{CONST_FLOAT}			{
								anuncio("CONST_FLOAT");
								if (!checkFloat(yytext())) {
									anunciarError("Lexer: Lexema " + yytext() + " está fuera de los rangos permitidos para un float.\n");	
								} else {
									return nuevoSimbolo(sym.CONST_FLOAT);
								}
							}
	{CONST_STR}				{
								anuncio("CONST_STR");
								if (!checkStr(yytext())) {
									anunciarError("Lexer: Lexema " + yytext() + " excede la longitud máxima de un String (" + (STR_MAX_LEN - 2) + ").\n");		
								} else {
									return nuevoSimbolo(sym.CONST_STR);
								}
							}
	{ESPACIO}				{/* No hace nada. */}
	"/"						{return nuevoSimbolo(sym.DIVIDE);}
	"*"						{return nuevoSimbolo(sym.MULTIPLICA);}
} // Fin <YYINITIAL>.

[^]	{anunciarError("Lexer: Lexema '" + yytext() + "' no permitido, en la línea " + this.yyline + ", y columna " + this.yycolumn + ".");}
