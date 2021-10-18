/* ------------------------------------------------------------------ */
/* Importaciones */
/* ------------------------------------------------------------------ */

package modelo;
import jflex.core.sym; // Necesario para el método next_token(). 
/*
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
*/

// Para escribir el archivo de la tabla de símbolos.
//import compilador.TablaSimbolos.*;


/* ------------------------------------------------------------------ */
%% /* Opciones, código del usuario, y declaraciones */
/* ------------------------------------------------------------------ */

/* Opciones */

%public // Hace que la clase generada sea pública.
%class Lexico // Nombre de la clase generada.
%line // Permite utilizar la variable this.yyline para obtener el número de línea en que comienza el lexema que se está analizando actualmente.
%column // Permite utilizar la variable this.yycolumn para obtener el número de columna que se está analizando actualmente.
%int // Permite que la función yylex() devuelva un valor del tipo int, en vez de un valor del tipo Yytoken, cuya clase no está definida.


/* Código de usuario */

%{
	// Valores máximos.
	private final int STR_MAX_LEN = 32;  // Son 32 porque contamos las doble comillas de apertura y cierre.
	private final int INT_MAX_LEN = 65536;
	
	// Tabla de símbolos.
	// private List<Map<Columna, String>> symtbl;
	
	// Inicializa la tabla de símbolos.
	/*
	private void iniTable() {
		TablaSimbolos.escribirArchivo(null, null, false);
		this.symtbl = TablaSimbolos.leerArchivo(null);
		EscribeAnalisis.escribir("", false);
	}
	*/

	/*
	// Agrega un símbolo de ID de variable.
	public void addSym(String nombre, String token, String tipo) {
		boolean encontrado = false;
		int i = 0;
		
		while (!encontrado && i < symtbl.size()) {
			encontrado = symtbl.get(i).get(Columna.NOMBRE).equals(nombre);
			i++;
		}
		
		if (!encontrado) {
			Map<Columna, String> sym = new HashMap<Columna, String>();
			sym.put(Columna.NOMBRE, nombre);
			sym.put(Columna.TOKEN, token);
			sym.put(Columna.TIPO, tipo);
			this.symtbl.add(sym);
			TablaSimbolos.escribirArchivo(Arrays.asList(sym), null, true);
		}
	}
	*/
	
	/*
	// Agrega una constante.
	public void addSym(String nombre, String token, String valor, Integer len) {
		boolean encontrado = false;
		int i = 0;
		
		while (!encontrado && i < symtbl.size()) {
			encontrado = symtbl.get(i).get(Columna.NOMBRE).equals(nombre);
			i++;
		}
		
		if (!encontrado) {
			Map<Columna,String> sym = new HashMap<Columna, String>();
			sym.put(Columna.NOMBRE, nombre);
			sym.put(Columna.TOKEN, token);
			sym.put(Columna.VALOR, valor);
			if (len != null) sym.put(Columna.LEN, String.valueOf(len));
			this.symtbl.add(sym);
			TablaSimbolos.escribirArchivo(Arrays.asList(sym), null, true);
		}
	}
	*/
	
	// Verifica la cantidad de bits del entero recibido como String.
	public boolean checkInt(String s) {
	
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
			System.out.println("Error parseando lexema " + yytext() + ".");
			System.out.println(e.toString());
			return false;
		}
		
		return true;
	}

	// Verifica la cantidad de bits del float recibido como String.
	public boolean checkFloat(String s) {
	
		// Verifico que el string no esté vacío.
		if (s.isEmpty()) {
			return false;
		}
		
		try {
		
			// Convierto a float. Si se convierte, el valor está dentro
			// de los valores aceptables para el tipo float de Java.
			float numero = Float.valueOf(s);
			System.out.println(numero);
			
			if(
				numero == Float.POSITIVE_INFINITY
				||
				numero == Float.NEGATIVE_INFINITY
				||
				Math.abs(numero) < Float.MIN_VALUE
			) return false;  
			
		} catch(Exception e) {
			System.out.println("Error parseando lexema " + yytext() + ".");
			System.out.println(e.toString());
			return false;
		}
		
		return true;
	}
	
	// Verifica que el String no tenga más de 30 caracteres.
	public boolean checkStr(String s) {
		if (s.isEmpty() || (s.length() > STR_MAX_LEN)) {
			return false;
		}
		
		return true;
	}
	
	// Imprime cada par token:lexema hallado.
	public void anuncio(String token) {
		System.out.println("*** Nuevo hallazgo ***");
		System.out.println("\tToken = " + token + "\n\tLexema = '" + yytext() + "'\n");
		//EscribeAnalisis.escribir("*** Nuevo hallazgo ***", true);
		//EscribeAnalisis.escribir("\tToken = " + token + "\n\tLexema = '" + yytext() + "'\n", true);
	}
%}


/* Declaraciones */

ESPACIO = [\r\n\t\f ]

CONST_INT = [0-9]+
CONST_FLOAT = -?([0-9]*\.[0-9]+|[0-9]+\.[0-9]*)(e(\+|-)?[0-9][0-9]?)?
//	-? -> Signo menos opcional al comienzo.
//	(
//		[0-9]*\.[0-9]+ -> Permite que el float detectado no tenga dígitos en la parte entera.
//	|
//		[0-9]+\.[0-9]* -> Permite que el float detectado no tenga dígitos en la parte decimal.
//	)
//		(e(\+|-)?[0-9][0-9]?)? -> Opción de utilizar la notación científica como postfijo.
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


/* ------------------------------------------------------------------ */
%% /* Reglas léxicas */
/* ------------------------------------------------------------------ */

<YYINITIAL> {
	{COMENTARIO_DOBLE}		{anuncio("COMENTARIO_DOBLE");}
	{COMENTARIO_SIMPLE}		{anuncio("COMENTARIO_SIMPLE");}
    "DECLARE\.SECTION"		{anuncio("SEC_COMIENZO");}
    "ENDDECLARE\.SECTION"	{anuncio("SEC_FIN");}
    "PROGRAM\.SECTION"		{anuncio("PROG_COMIENZO");}
    "ENDPROGRAM\.SECTION"	{anuncio("PROG_FIN");}
    {POSITION}				{anuncio("POSITION");}
    {WRITE}					{anuncio("WRITE");}
    {IF}					{anuncio("IF");}
    {ELSE}					{anuncio("ELSE");}
    {WHILE}					{anuncio("WHILE");}
    {TIPO_DATO}				{anuncio("TIPO_DATO");}
	"::="					{anuncio("ASIGNA");}
    "=="					{anuncio("IGUAL");}
    "<>"					{anuncio("DISTINTO");} 
    "<"						{anuncio("MENOR");}
    "<="					{anuncio("MENOR_IGUAL");}
    ">"						{anuncio("MAYOR");}
    ">="					{anuncio("MAYOR_IGUAL");}
    "&&"					{anuncio("AND");}
    "||"					{anuncio("OR");}
    "+"						{anuncio("SUMA");}
    "-"						{anuncio("RESTA");}
    "("						{anuncio("PAR_ABRE");}
	")"						{anuncio("PAR_CIERRA");}
    "{"						{anuncio("LLAVE_ABRE");}
    "}"						{anuncio("LLAVE_CIERRA");}  
    "["						{anuncio("COR_ABRE");}  
    "]"						{anuncio("COR_CIERRA");}  
    ";"						{anuncio("PUNTO_COMA");}
    ","						{anuncio("COMA");}
	{ID_VAR}				{anuncio("ID_VAR"); /* addSym(yytext(), "ID_VAR", null); */ }
	{CONST_INT}				{
								anuncio("CONST_INT");					
								if (!checkInt(yytext())) {
									System.out.println("Lexema " + yytext() + " excede el valor máximo de un Integer (" + INT_MAX_LEN + ").\n");	
								} else {
									//addSym("_" + yytext(), "CONST_INT", yytext(), null);
								}
							}
	{CONST_FLOAT}			{
								anuncio("CONST_FLOAT");
								if (!checkFloat(yytext())) {
									System.out.println("Lexema " + yytext() + " está fuera de los rangos permitidos para un float.\n");	
								} else {
									//addSym("_" + yytext(), "CONST_FLOAT", yytext(), null);
								}
							}
	{CONST_STR}				{
								anuncio("CONST_STR");
								if (!checkStr(yytext())) {
									System.out.println("Lexema " + yytext() + " excede la longitud máxima de un String (" + STR_MAX_LEN + ").\n");		
								} else {
									//addSym("_" + yytext(), "CONST_STR", yytext(), yytext().length());
								}
							}
	{ESPACIO}				{/* no hacer nada */}
	"/"						{anuncio("DIVIDE");}
	"*"						{anuncio("MULTIPLICA");}
} // Fin <YYINITIAL>.

[^]	{throw new Error("Carácter '" + yytext() + "' no permitido, en la línea " + this.yyline + ", y columna " + this.yycolumn + ".");}
