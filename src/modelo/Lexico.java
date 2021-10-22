// DO NOT EDIT
// Generated by JFlex 1.8.2 http://jflex.de/
// source: ../jflex/Lexico.flex

/* ------------------------------------------------------------------ */
/* Importaciones */
/* ------------------------------------------------------------------ */

package modelo;
import jflex.core.sym; // Necesario para el método next_token(). 
import java.util.ArrayList;
import vista.Vista;


/* ------------------------------------------------------------------ */

// See https://github.com/jflex-de/jflex/issues/222
@SuppressWarnings("FallThrough")
public class Lexico implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\u10ff\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\2\1\1\0\2\1\22\0\1\1\1\0\1\2"+
    "\3\0\1\3\1\0\1\4\1\5\1\6\1\7\1\10"+
    "\1\11\1\12\1\13\12\14\1\15\1\16\1\17\1\20"+
    "\1\21\2\0\1\22\1\23\1\24\1\25\1\26\1\27"+
    "\1\30\1\31\1\32\2\23\1\33\1\34\1\35\1\36"+
    "\1\37\1\23\1\40\1\41\1\42\2\23\1\43\3\23"+
    "\1\44\1\0\1\45\1\0\1\46\1\0\1\47\3\23"+
    "\1\50\1\27\1\51\1\31\1\52\2\23\1\53\1\23"+
    "\1\54\1\55\1\56\1\23\1\57\1\60\1\61\2\23"+
    "\1\43\3\23\1\62\1\63\1\64\u0182\0";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[512];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\2\1\1\3\1\4\1\5\1\6"+
    "\1\7\1\10\1\1\1\11\1\12\1\1\1\13\1\14"+
    "\1\1\1\15\10\16\1\17\1\20\2\16\1\21\1\1"+
    "\1\22\1\0\1\23\1\24\2\0\1\25\2\0\1\26"+
    "\1\27\1\30\1\31\4\16\1\32\6\16\1\33\2\0"+
    "\1\34\4\16\1\35\5\16\1\0\1\25\2\0\1\16"+
    "\1\36\7\16\1\25\2\0\6\16\1\37\1\40\1\41"+
    "\1\0\5\16\3\0\5\16\1\0\1\41\1\0\2\16"+
    "\1\42\3\0\2\16\3\0\2\16\6\0\1\43\14\0"+
    "\1\44\2\0\1\45\4\0\1\46\1\47";

  private static int [] zzUnpackAction() {
    int [] result = new int[155];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\65\0\65\0\152\0\237\0\65\0\65\0\65"+
    "\0\65\0\65\0\324\0\u0109\0\u013e\0\u0173\0\u01a8\0\65"+
    "\0\u01dd\0\u0212\0\u0247\0\u027c\0\u02b1\0\u02e6\0\u031b\0\u0350"+
    "\0\u0385\0\u03ba\0\u03ef\0\65\0\65\0\u0424\0\u0459\0\65"+
    "\0\u048e\0\65\0\152\0\65\0\65\0\u0109\0\u04c3\0\u04f8"+
    "\0\u052d\0\u0562\0\65\0\65\0\65\0\65\0\u0597\0\u05cc"+
    "\0\u0601\0\u0636\0\u027c\0\u066b\0\u06a0\0\u06d5\0\u070a\0\u073f"+
    "\0\u0774\0\65\0\u07a9\0\u07de\0\65\0\u0813\0\u0848\0\u087d"+
    "\0\u08b2\0\u027c\0\u08e7\0\u091c\0\u0951\0\u0986\0\u09bb\0\u09f0"+
    "\0\u0a25\0\u0a5a\0\u0a8f\0\u0ac4\0\u027c\0\u0af9\0\u0b2e\0\u0b63"+
    "\0\u0b98\0\u0bcd\0\u0c02\0\u0c37\0\65\0\u0c6c\0\u0ca1\0\u0cd6"+
    "\0\u0d0b\0\u0d40\0\u0d75\0\u0daa\0\u0ddf\0\u027c\0\u027c\0\65"+
    "\0\u0e14\0\u0e49\0\u0e7e\0\u0eb3\0\u0ee8\0\u0f1d\0\u0f52\0\u0f87"+
    "\0\u0fbc\0\u0ff1\0\u1026\0\u105b\0\u1090\0\u10c5\0\u10fa\0\u0f52"+
    "\0\u112f\0\u1164\0\u1199\0\u027c\0\u11ce\0\u1203\0\u1238\0\u126d"+
    "\0\u12a2\0\u12d7\0\u130c\0\u1341\0\u1376\0\u13ab\0\u13e0\0\u1415"+
    "\0\u144a\0\u147f\0\u14b4\0\u14e9\0\65\0\u151e\0\u1553\0\u1588"+
    "\0\u15bd\0\u15f2\0\u1627\0\u165c\0\u1691\0\u16c6\0\u16fb\0\u1730"+
    "\0\u1765\0\65\0\u179a\0\u17cf\0\65\0\u1804\0\u1839\0\u186e"+
    "\0\u18a3\0\65\0\65";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[155];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21"+
    "\1\22\1\23\3\24\1\25\1\26\1\27\2\24\1\30"+
    "\4\24\1\31\1\24\1\32\1\24\1\33\1\34\1\35"+
    "\1\2\1\24\1\36\1\24\1\30\3\24\1\37\1\24"+
    "\1\32\1\24\1\40\1\41\1\42\65\0\2\43\1\44"+
    "\62\43\3\0\1\45\73\0\1\46\1\0\1\47\64\0"+
    "\1\50\63\0\1\51\63\0\1\50\1\0\1\16\65\0"+
    "\1\52\67\0\1\53\1\54\63\0\1\55\64\0\1\56"+
    "\60\0\1\24\5\0\22\24\2\0\14\24\17\0\1\24"+
    "\5\0\4\24\1\57\15\24\2\0\14\24\17\0\1\24"+
    "\5\0\11\24\1\60\1\24\1\61\6\24\2\0\5\24"+
    "\1\60\6\24\17\0\1\24\5\0\11\24\1\62\10\24"+
    "\2\0\5\24\1\62\6\24\17\0\1\24\5\0\5\24"+
    "\1\63\5\24\1\64\6\24\2\0\6\24\1\64\5\24"+
    "\17\0\1\24\5\0\14\24\1\65\1\24\1\66\3\24"+
    "\2\0\7\24\1\65\4\24\17\0\1\24\5\0\20\24"+
    "\1\67\1\24\2\0\13\24\1\67\17\0\1\24\5\0"+
    "\7\24\1\70\6\24\1\71\3\24\2\0\11\24\1\71"+
    "\2\24\17\0\1\24\5\0\11\24\1\60\10\24\2\0"+
    "\5\24\1\60\6\24\17\0\1\24\5\0\14\24\1\65"+
    "\5\24\2\0\7\24\1\65\4\24\66\0\1\72\13\0"+
    "\1\50\1\0\1\47\64\0\1\50\33\0\1\73\22\0"+
    "\1\74\76\0\1\75\60\0\1\24\5\0\2\24\1\76"+
    "\17\24\2\0\14\24\17\0\1\24\5\0\17\24\1\77"+
    "\2\24\2\0\12\24\1\77\1\24\17\0\1\24\5\0"+
    "\3\24\1\100\16\24\2\0\14\24\17\0\1\24\5\0"+
    "\14\24\1\101\5\24\2\0\7\24\1\101\4\24\17\0"+
    "\1\24\5\0\20\24\1\102\1\24\2\0\13\24\1\102"+
    "\17\0\1\24\5\0\17\24\1\103\2\24\2\0\12\24"+
    "\1\103\1\24\17\0\1\24\5\0\14\24\1\104\5\24"+
    "\2\0\14\24\17\0\1\24\5\0\16\24\1\105\3\24"+
    "\2\0\11\24\1\105\2\24\17\0\1\24\5\0\10\24"+
    "\1\106\11\24\2\0\4\24\1\106\7\24\17\0\1\24"+
    "\5\0\10\24\1\107\11\24\2\0\4\24\1\107\7\24"+
    "\12\0\1\110\1\0\1\110\2\0\1\111\50\0\6\74"+
    "\1\112\4\74\1\113\51\74\14\0\1\24\5\0\11\24"+
    "\1\114\10\24\2\0\14\24\17\0\1\24\5\0\4\24"+
    "\1\115\15\24\2\0\2\24\1\115\11\24\17\0\1\24"+
    "\5\0\3\24\1\116\11\24\1\117\4\24\2\0\14\24"+
    "\17\0\1\24\5\0\1\64\21\24\2\0\1\24\1\64"+
    "\12\24\17\0\1\24\5\0\10\24\1\120\11\24\2\0"+
    "\4\24\1\120\7\24\17\0\1\24\5\0\6\24\1\121"+
    "\13\24\2\0\14\24\17\0\1\24\5\0\10\24\1\122"+
    "\11\24\2\0\4\24\1\122\7\24\17\0\1\24\5\0"+
    "\11\24\1\123\10\24\2\0\5\24\1\123\6\24\17\0"+
    "\1\24\5\0\20\24\1\124\1\24\2\0\13\24\1\124"+
    "\17\0\1\111\64\0\1\125\63\0\1\126\51\0\6\74"+
    "\1\112\4\74\1\127\51\74\14\0\1\24\5\0\1\130"+
    "\21\24\2\0\14\24\17\0\1\24\5\0\4\24\1\131"+
    "\15\24\2\0\14\24\17\0\1\24\5\0\16\24\1\132"+
    "\3\24\2\0\14\24\17\0\1\24\5\0\20\24\1\133"+
    "\1\24\2\0\13\24\1\133\17\0\1\24\5\0\16\24"+
    "\1\134\3\24\2\0\14\24\17\0\1\24\5\0\13\24"+
    "\1\135\6\24\2\0\6\24\1\135\5\24\17\0\1\24"+
    "\5\0\4\24\1\136\15\24\2\0\2\24\1\136\11\24"+
    "\17\0\1\24\5\0\4\24\1\137\15\24\2\0\2\24"+
    "\1\137\11\24\16\0\1\140\51\0\6\74\1\141\4\74"+
    "\1\127\51\74\14\0\1\24\5\0\16\24\1\142\3\24"+
    "\2\0\14\24\17\0\1\24\5\0\2\24\1\143\17\24"+
    "\2\0\14\24\17\0\1\24\5\0\14\24\1\144\5\24"+
    "\2\0\14\24\17\0\1\24\5\0\10\24\1\145\11\24"+
    "\2\0\4\24\1\145\7\24\17\0\1\24\5\0\1\146"+
    "\21\24\2\0\14\24\17\0\1\24\5\0\6\24\1\102"+
    "\13\24\2\0\3\24\1\102\10\24\3\0\6\147\1\150"+
    "\4\147\1\151\51\147\14\0\1\24\5\0\4\24\1\152"+
    "\15\24\2\0\14\24\17\0\1\24\5\0\11\24\1\153"+
    "\10\24\2\0\14\24\17\0\1\24\5\0\6\24\1\154"+
    "\13\24\2\0\14\24\17\0\1\24\5\0\14\24\1\155"+
    "\5\24\2\0\7\24\1\155\4\24\17\0\1\24\5\0"+
    "\12\24\1\156\7\24\2\0\14\24\3\0\6\147\1\150"+
    "\56\147\13\0\1\157\51\0\6\147\1\150\4\147\1\160"+
    "\51\147\12\0\1\161\1\0\1\24\5\0\22\24\2\0"+
    "\14\24\17\0\1\24\5\0\1\162\21\24\2\0\14\24"+
    "\17\0\1\24\5\0\16\24\1\163\3\24\2\0\14\24"+
    "\17\0\1\24\5\0\13\24\1\164\6\24\2\0\6\24"+
    "\1\164\5\24\15\0\1\165\1\0\1\24\5\0\22\24"+
    "\2\0\14\24\16\0\1\166\112\0\1\167\37\0\1\24"+
    "\5\0\16\24\1\170\3\24\2\0\14\24\17\0\1\24"+
    "\5\0\1\171\21\24\2\0\14\24\44\0\1\172\23\0"+
    "\6\166\1\173\56\166\26\0\1\174\52\0\1\24\5\0"+
    "\4\24\1\175\15\24\2\0\14\24\17\0\1\24\5\0"+
    "\12\24\1\176\7\24\2\0\14\24\31\0\1\177\51\0"+
    "\1\200\75\0\1\201\52\0\1\202\1\0\1\24\5\0"+
    "\22\24\2\0\14\24\15\0\1\203\1\0\1\24\5\0"+
    "\22\24\2\0\14\24\27\0\1\204\53\0\1\205\113\0"+
    "\1\206\63\0\1\207\64\0\1\210\65\0\1\211\54\0"+
    "\1\212\60\0\1\213\64\0\1\214\70\0\1\215\70\0"+
    "\1\216\52\0\1\217\64\0\1\220\76\0\1\221\63\0"+
    "\1\222\71\0\1\223\64\0\1\224\57\0\1\225\61\0"+
    "\1\226\64\0\1\227\70\0\1\230\64\0\1\231\63\0"+
    "\1\232\64\0\1\233\27\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[6360];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\2\11\2\1\5\11\5\1\1\11\13\1\2\11"+
    "\2\1\1\11\1\1\1\11\1\0\2\11\2\0\1\1"+
    "\2\0\4\11\13\1\1\11\2\0\1\11\12\1\1\0"+
    "\1\1\2\0\11\1\1\11\2\0\10\1\1\11\1\0"+
    "\5\1\3\0\5\1\1\0\1\1\1\0\3\1\3\0"+
    "\2\1\3\0\2\1\6\0\1\11\14\0\1\11\2\0"+
    "\1\11\4\0\2\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[155];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */
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


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexico(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length * 2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException(
          "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE) {
      zzBuffer = new char[ZZ_BUFFERSIZE];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  @Override  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { return new java_cup.runtime.Symbol(sym.EOF); }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { anunciarError("Lexema '" + yytext() + "' no permitido, en la línea " + this.yyline + ", y columna " + this.yycolumn + ".");
            }
            // fall through
          case 40: break;
          case 2:
            { /* no hacer nada */
            }
            // fall through
          case 41: break;
          case 3:
            { anuncio("PAR_ABRE"); guardoToken("PAR_ABRE");
            }
            // fall through
          case 42: break;
          case 4:
            { anuncio("PAR_CIERRA"); guardoToken("PAR_CIERRA");
            }
            // fall through
          case 43: break;
          case 5:
            { anuncio("MULTIPLICA"); guardoToken("MULTIPLICA");
            }
            // fall through
          case 44: break;
          case 6:
            { anuncio("SUMA"); guardoToken("SUMA");
            }
            // fall through
          case 45: break;
          case 7:
            { anuncio("COMA"); guardoToken("COMA");
            }
            // fall through
          case 46: break;
          case 8:
            { anuncio("RESTA"); guardoToken("RESTA");
            }
            // fall through
          case 47: break;
          case 9:
            { anuncio("DIVIDE"); guardoToken("DIVIDE");
            }
            // fall through
          case 48: break;
          case 10:
            { anuncio("CONST_INT");					
								if (!checkInt(yytext())) {
									vista.agregarLinea("Lexema " + yytext() + " excede el valor máximo de un Integer (" + INT_MAX_LEN + ").\n");	
								} else {
									guardoToken("CONST_INT");
								}
            }
            // fall through
          case 49: break;
          case 11:
            { anuncio("PUNTO_COMA"); guardoToken("PUNTO_COMA");
            }
            // fall through
          case 50: break;
          case 12:
            { anuncio("MENOR"); guardoToken("MENOR");
            }
            // fall through
          case 51: break;
          case 13:
            { anuncio("MAYOR"); guardoToken("MAYOR");
            }
            // fall through
          case 52: break;
          case 14:
            { anuncio("ID_VAR"); guardoToken("ID_VAR");
            }
            // fall through
          case 53: break;
          case 15:
            { anuncio("COR_ABRE"); guardoToken("COR_ABRE");
            }
            // fall through
          case 54: break;
          case 16:
            { anuncio("COR_CIERRA"); guardoToken("COR_CIERRA");
            }
            // fall through
          case 55: break;
          case 17:
            { anuncio("LLAVE_ABRE"); guardoToken("LLAVE_ABRE");
            }
            // fall through
          case 56: break;
          case 18:
            { anuncio("LLAVE_CIERRA"); guardoToken("LLAVE_CIERRA");
            }
            // fall through
          case 57: break;
          case 19:
            { anuncio("CONST_STR");
								if (!checkStr(yytext())) {
									vista.agregarLinea("Lexema " + yytext() + " excede la longitud máxima de un String (" + STR_MAX_LEN + ").\n");		
								} else {
									guardoToken("CONST_STR");
								}
            }
            // fall through
          case 58: break;
          case 20:
            { anuncio("AND"); guardoToken("AND");
            }
            // fall through
          case 59: break;
          case 21:
            { anuncio("CONST_FLOAT");
								if (!checkFloat(yytext())) {
									vista.agregarLinea("Lexema " + yytext() + " está fuera de los rangos permitidos para un float.\n");	
								} else {
									guardoToken("CONST_FLOAT");
								}
            }
            // fall through
          case 60: break;
          case 22:
            { anuncio("MENOR_IGUAL"); guardoToken("MENOR_IGUAL");
            }
            // fall through
          case 61: break;
          case 23:
            { anuncio("DISTINTO"); guardoToken("DISTINTO");
            }
            // fall through
          case 62: break;
          case 24:
            { anuncio("IGUAL"); guardoToken("IGUAL");
            }
            // fall through
          case 63: break;
          case 25:
            { anuncio("MAYOR_IGUAL"); guardoToken("MAYOR_IGUAL");
            }
            // fall through
          case 64: break;
          case 26:
            { anuncio("IF"); guardoToken("IF");
            }
            // fall through
          case 65: break;
          case 27:
            { anuncio("OR"); guardoToken("OR");
            }
            // fall through
          case 66: break;
          case 28:
            { anuncio("ASIGNA"); guardoToken("ASIGNA");
            }
            // fall through
          case 67: break;
          case 29:
            { anuncio("TIPO_DATO"); guardoToken("TIPO_DATO");
            }
            // fall through
          case 68: break;
          case 30:
            { anuncio("ELSE"); guardoToken("ELSE");
            }
            // fall through
          case 69: break;
          case 31:
            { anuncio("WHILE"); guardoToken("WHILE");
            }
            // fall through
          case 70: break;
          case 32:
            { anuncio("WRITE"); guardoToken("WRITE");
            }
            // fall through
          case 71: break;
          case 33:
            { anuncio("COMENTARIO_SIMPLE"); guardoToken("COMENTARIO_SIMPLE");
            }
            // fall through
          case 72: break;
          case 34:
            { anuncio("POSITION"); guardoToken("POSITION");
            }
            // fall through
          case 73: break;
          case 35:
            { anuncio("COMENTARIO_DOBLE"); guardoToken("COMENTARIO_DOBLE");
            }
            // fall through
          case 74: break;
          case 36:
            { anuncio("SEC_COMIENZO"); guardoToken("SEC_COMIENZO");
            }
            // fall through
          case 75: break;
          case 37:
            { anuncio("PROG_COMIENZO"); guardoToken("PROG_COMIENZO");
            }
            // fall through
          case 76: break;
          case 38:
            { anuncio("SEC_FIN"); guardoToken("SEC_FIN");
            }
            // fall through
          case 77: break;
          case 39:
            { anuncio("PROG_FIN"); guardoToken("PROG_FIN");
            }
            // fall through
          case 78: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
