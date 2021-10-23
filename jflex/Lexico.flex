/* ------------------------------------------------------------------ */
/* Importaciones */
/* ------------------------------------------------------------------ */

package modelo;
import jflex.core.sym; // Necesario para el método next_token(). 
import java.util.ArrayList;
import vista.Vista;


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
		vista.agregarLinea("\tToken = " + token + "\n\tLexema = '" + yytext() + "'\n");	
	}
	
	// Comunica que se encontró un lexema inválido.
	private void anunciarError(String mensaje) {
		vista.agregarLinea("¡Lexema inválido!");
		vista.agregarLinea("\t" + mensaje + "\n");	
	}
	
	// Guarda el par token:lexema en la lista de Tokens interna.
	private void guardoToken(String token) {
		if(token.equals("CONST_STR"))
			listaTokens.add(
				new Token(
					token,
					yytext().substring(1, yytext().length() - 1)
				)
			);
		else
			listaTokens.add(new Token(token, yytext()));
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
	{COMENTARIO_DOBLE}		{anuncio("COMENTARIO_DOBLE"); guardoToken("COMENTARIO_DOBLE");}
	{COMENTARIO_SIMPLE}		{anuncio("COMENTARIO_SIMPLE"); guardoToken("COMENTARIO_SIMPLE");}
    {DECLARE}				{anuncio("SEC_COMIENZO"); guardoToken("SEC_COMIENZO");}
    {ENDDECLARE}			{anuncio("SEC_FIN"); guardoToken("SEC_FIN");}
    {PROGRAM}				{anuncio("PROG_COMIENZO"); guardoToken("PROG_COMIENZO");}
    {ENDPROGRAM}			{anuncio("PROG_FIN"); guardoToken("PROG_FIN");}
    {POSITION}				{anuncio("POSITION"); guardoToken("POSITION");}
    {WRITE}					{anuncio("WRITE"); guardoToken("WRITE");}
    {IF}					{anuncio("IF"); guardoToken("IF");}
    {ELSE}					{anuncio("ELSE"); guardoToken("ELSE");}
    {WHILE}					{anuncio("WHILE"); guardoToken("WHILE");}
    {TIPO_DATO}				{anuncio("TIPO_DATO"); guardoToken("TIPO_DATO");}
	"::="					{anuncio("ASIGNA_VAR"); guardoToken("ASIGNA_VAR");}
	":="					{anuncio("ASIGNA_TIPO"); guardoToken("ASIGNA_TIPO");}
    "=="					{anuncio("IGUAL"); guardoToken("IGUAL");}
    "<>"					{anuncio("DISTINTO"); guardoToken("DISTINTO");}
    "<"						{anuncio("MENOR"); guardoToken("MENOR");}
    "<="					{anuncio("MENOR_IGUAL"); guardoToken("MENOR_IGUAL");}
    ">"						{anuncio("MAYOR"); guardoToken("MAYOR");}
    ">="					{anuncio("MAYOR_IGUAL"); guardoToken("MAYOR_IGUAL");}
    {AND}					{anuncio("AND"); guardoToken("AND");}
    {OR}					{anuncio("OR"); guardoToken("OR");}
    "+"						{anuncio("SUMA"); guardoToken("SUMA");}
    "-"						{anuncio("RESTA"); guardoToken("RESTA");}
    "("						{anuncio("PAR_ABRE"); guardoToken("PAR_ABRE");}
	")"						{anuncio("PAR_CIERRA"); guardoToken("PAR_CIERRA");}
    "{"						{anuncio("LLAVE_ABRE"); guardoToken("LLAVE_ABRE");}
    "}"						{anuncio("LLAVE_CIERRA"); guardoToken("LLAVE_CIERRA");}
    "["						{anuncio("COR_ABRE"); guardoToken("COR_ABRE");}
    "]"						{anuncio("COR_CIERRA"); guardoToken("COR_CIERRA");}
    ";"						{anuncio("PUNTO_COMA"); guardoToken("PUNTO_COMA");}
    ","						{anuncio("COMA"); guardoToken("COMA");}
	{ID_VAR}				{anuncio("ID_VAR"); guardoToken("ID_VAR");}
	{CONST_INT}				{
								anuncio("CONST_INT");					
								if (!checkInt(yytext())) {
									vista.agregarLinea("Lexema " + yytext() + " excede el valor máximo de un Integer (" + INT_MAX_LEN + ").\n");	
								} else {
									guardoToken("CONST_INT");
								}
							}
	{CONST_FLOAT}			{
								anuncio("CONST_FLOAT");
								if (!checkFloat(yytext())) {
									vista.agregarLinea("Lexema " + yytext() + " está fuera de los rangos permitidos para un float.\n");	
								} else {
									guardoToken("CONST_FLOAT");
								}
							}
	{CONST_STR}				{
								anuncio("CONST_STR");
								if (!checkStr(yytext())) {
									vista.agregarLinea("Lexema " + yytext() + " excede la longitud máxima de un String (" + STR_MAX_LEN + ").\n");		
								} else {
									guardoToken("CONST_STR");
								}
							}
	{ESPACIO}				{/* no hacer nada */}
	"/"						{anuncio("DIVIDE"); guardoToken("DIVIDE");}
	"*"						{anuncio("MULTIPLICA"); guardoToken("MULTIPLICA");}
} // Fin <YYINITIAL>.

[^]	{anunciarError("Lexema '" + yytext() + "' no permitido, en la línea " + this.yyline + ", y columna " + this.yycolumn + ".");}
