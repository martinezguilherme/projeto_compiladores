// Generated from IsiLang.g4 by ANTLR 4.7.1
package parser;

	import datastructures.IsiSymbol;
	import datastructures.IsiVariable;
	import datastructures.IsiSymbolTable;
	import exceptions.SemanticException;
	import ast.GenerateJavaCode;
	import ast.AbstractCommand;
	import ast.CommandLeitura;
	import ast.CommandEscrita;
	import ast.CommandAtribuicao;
	import ast.CommandDecisao;
	import ast.CommandEnquanto;
	import ast.CommandComentario;
	import java.util.ArrayList;
	import java.util.Stack;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, OPREL=12, ID=13, TEXTO=14, BOOL=15, COMMENT=16, NUMBER=17, 
		WS=18, OP=19, AP=20, FP=21, PR=22, DQ=23, ATR=24, VIR=25, ACH=26, FCH=27, 
		SOM=28, MUL=29, DIV=30, SUB=31, CM=32;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "OPREL", "ID", "TEXTO", "BOOL", "COMMENT", "NUMBER", 
		"WS", "OP", "AP", "FP", "PR", "DQ", "ATR", "VIR", "ACH", "FCH", "SOM", 
		"MUL", "DIV", "SUB", "CM"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog.'", "'declare'", "'declarab'", "'texto'", 
		"'leia'", "'escreva'", "'se'", "'entao'", "'senao'", "'enquanto'", null, 
		null, null, null, null, null, null, null, "'('", "')'", "'.'", "'\"'", 
		"':='", "','", "'{'", "'}'", "'+'", "'*'", "'/'", "'-'", "'#'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"OPREL", "ID", "TEXTO", "BOOL", "COMMENT", "NUMBER", "WS", "OP", "AP", 
		"FP", "PR", "DQ", "ATR", "VIR", "ACH", "FCH", "SOM", "MUL", "DIV", "SUB", 
		"CM"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


		private String _varName;
		private String _varValue;
		private int _varType;
		private IsiSymbolTable symbolTable = new IsiSymbolTable();
		private IsiSymbol symbol;
		private GenerateJavaCode program = new GenerateJavaCode();
		private ArrayList<AbstractCommand> curThread;
		private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
		private String _readID;
		private String _writeID;
		private String _readTEXTO;
		private String _writeTEXTO;
		private String _exprID;
		private String _exprContent;
		private String _exprDecision;
		private String _exprEnquanto;
		private String _exprComentario;
		private ArrayList<AbstractCommand> listaComments;
		private ArrayList<AbstractCommand> listaTrue;
		private ArrayList<AbstractCommand> listaFalse;
		
		public void verificaID(String id){
			if (!symbolTable.exists(id)){
				throw new SemanticException("Symbol "+id+" not declared");
			}
		}
		
		public void exibeComandos(){
			for (AbstractCommand c: program.getComandos()){
				System.out.println(c);
			}
		}

		public String exibeInput(){
			String leitura = ((TokenStream) _input).LT(-1).getText();
			return (leitura.equals("True") || leitura.equals("False")? leitura.toLowerCase(): leitura);
		}

		public void variavelUti(String id){ 
			symbolTable.varUtilizada(id);
		 }
		
		public void generateCode(){
			program.generateTarget();
		}


	public IsiLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\"\u00ee\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\5\r\u009b\n\r\3\16\3\16\7\16\u009f\n\16\f\16\16\16\u00a2\13\16"+
		"\3\17\3\17\3\17\6\17\u00a7\n\17\r\17\16\17\u00a8\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00b6\n\20\3\21\3\21\3\21\6\21"+
		"\u00bb\n\21\r\21\16\21\u00bc\3\21\3\21\3\22\6\22\u00c2\n\22\r\22\16\22"+
		"\u00c3\3\22\3\22\6\22\u00c8\n\22\r\22\16\22\u00c9\5\22\u00cc\n\22\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31"+
		"\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37"+
		"\3 \3 \3!\3!\2\2\"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r"+
		"\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"\3\2\b\4\2>>@@\3\2c|\5\2\62;C\\c|\3\2\62;\5"+
		"\2\13\f\17\17\"\"\5\2,-//\61\61\2\u00fa\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\3C\3\2\2\2\5L\3\2\2\2\7U\3\2\2\2\t]\3\2\2\2\13f\3\2\2\2\rl\3"+
		"\2\2\2\17q\3\2\2\2\21y\3\2\2\2\23|\3\2\2\2\25\u0082\3\2\2\2\27\u0088\3"+
		"\2\2\2\31\u009a\3\2\2\2\33\u009c\3\2\2\2\35\u00a3\3\2\2\2\37\u00b5\3\2"+
		"\2\2!\u00b7\3\2\2\2#\u00c1\3\2\2\2%\u00cd\3\2\2\2\'\u00d1\3\2\2\2)\u00d3"+
		"\3\2\2\2+\u00d5\3\2\2\2-\u00d7\3\2\2\2/\u00d9\3\2\2\2\61\u00db\3\2\2\2"+
		"\63\u00de\3\2\2\2\65\u00e0\3\2\2\2\67\u00e2\3\2\2\29\u00e4\3\2\2\2;\u00e6"+
		"\3\2\2\2=\u00e8\3\2\2\2?\u00ea\3\2\2\2A\u00ec\3\2\2\2CD\7r\2\2DE\7t\2"+
		"\2EF\7q\2\2FG\7i\2\2GH\7t\2\2HI\7c\2\2IJ\7o\2\2JK\7c\2\2K\4\3\2\2\2LM"+
		"\7h\2\2MN\7k\2\2NO\7o\2\2OP\7r\2\2PQ\7t\2\2QR\7q\2\2RS\7i\2\2ST\7\60\2"+
		"\2T\6\3\2\2\2UV\7f\2\2VW\7g\2\2WX\7e\2\2XY\7n\2\2YZ\7c\2\2Z[\7t\2\2[\\"+
		"\7g\2\2\\\b\3\2\2\2]^\7f\2\2^_\7g\2\2_`\7e\2\2`a\7n\2\2ab\7c\2\2bc\7t"+
		"\2\2cd\7c\2\2de\7d\2\2e\n\3\2\2\2fg\7v\2\2gh\7g\2\2hi\7z\2\2ij\7v\2\2"+
		"jk\7q\2\2k\f\3\2\2\2lm\7n\2\2mn\7g\2\2no\7k\2\2op\7c\2\2p\16\3\2\2\2q"+
		"r\7g\2\2rs\7u\2\2st\7e\2\2tu\7t\2\2uv\7g\2\2vw\7x\2\2wx\7c\2\2x\20\3\2"+
		"\2\2yz\7u\2\2z{\7g\2\2{\22\3\2\2\2|}\7g\2\2}~\7p\2\2~\177\7v\2\2\177\u0080"+
		"\7c\2\2\u0080\u0081\7q\2\2\u0081\24\3\2\2\2\u0082\u0083\7u\2\2\u0083\u0084"+
		"\7g\2\2\u0084\u0085\7p\2\2\u0085\u0086\7c\2\2\u0086\u0087\7q\2\2\u0087"+
		"\26\3\2\2\2\u0088\u0089\7g\2\2\u0089\u008a\7p\2\2\u008a\u008b\7s\2\2\u008b"+
		"\u008c\7w\2\2\u008c\u008d\7c\2\2\u008d\u008e\7p\2\2\u008e\u008f\7v\2\2"+
		"\u008f\u0090\7q\2\2\u0090\30\3\2\2\2\u0091\u009b\t\2\2\2\u0092\u0093\7"+
		"@\2\2\u0093\u009b\7?\2\2\u0094\u0095\7>\2\2\u0095\u009b\7?\2\2\u0096\u0097"+
		"\7?\2\2\u0097\u009b\7?\2\2\u0098\u0099\7#\2\2\u0099\u009b\7?\2\2\u009a"+
		"\u0091\3\2\2\2\u009a\u0092\3\2\2\2\u009a\u0094\3\2\2\2\u009a\u0096\3\2"+
		"\2\2\u009a\u0098\3\2\2\2\u009b\32\3\2\2\2\u009c\u00a0\t\3\2\2\u009d\u009f"+
		"\t\4\2\2\u009e\u009d\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\34\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a6\5/\30"+
		"\2\u00a4\u00a7\t\4\2\2\u00a5\u00a7\5%\23\2\u00a6\u00a4\3\2\2\2\u00a6\u00a5"+
		"\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9"+
		"\u00aa\3\2\2\2\u00aa\u00ab\5/\30\2\u00ab\36\3\2\2\2\u00ac\u00ad\7V\2\2"+
		"\u00ad\u00ae\7t\2\2\u00ae\u00af\7w\2\2\u00af\u00b6\7g\2\2\u00b0\u00b1"+
		"\7H\2\2\u00b1\u00b2\7c\2\2\u00b2\u00b3\7n\2\2\u00b3\u00b4\7u\2\2\u00b4"+
		"\u00b6\7g\2\2\u00b5\u00ac\3\2\2\2\u00b5\u00b0\3\2\2\2\u00b6 \3\2\2\2\u00b7"+
		"\u00ba\5A!\2\u00b8\u00bb\t\4\2\2\u00b9\u00bb\5%\23\2\u00ba\u00b8\3\2\2"+
		"\2\u00ba\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd"+
		"\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\5A!\2\u00bf\"\3\2\2\2\u00c0\u00c2"+
		"\t\5\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3"+
		"\u00c4\3\2\2\2\u00c4\u00cb\3\2\2\2\u00c5\u00c7\7\60\2\2\u00c6\u00c8\t"+
		"\5\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9"+
		"\u00ca\3\2\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00c5\3\2\2\2\u00cb\u00cc\3\2"+
		"\2\2\u00cc$\3\2\2\2\u00cd\u00ce\t\6\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0"+
		"\b\23\2\2\u00d0&\3\2\2\2\u00d1\u00d2\t\7\2\2\u00d2(\3\2\2\2\u00d3\u00d4"+
		"\7*\2\2\u00d4*\3\2\2\2\u00d5\u00d6\7+\2\2\u00d6,\3\2\2\2\u00d7\u00d8\7"+
		"\60\2\2\u00d8.\3\2\2\2\u00d9\u00da\7$\2\2\u00da\60\3\2\2\2\u00db\u00dc"+
		"\7<\2\2\u00dc\u00dd\7?\2\2\u00dd\62\3\2\2\2\u00de\u00df\7.\2\2\u00df\64"+
		"\3\2\2\2\u00e0\u00e1\7}\2\2\u00e1\66\3\2\2\2\u00e2\u00e3\7\177\2\2\u00e3"+
		"8\3\2\2\2\u00e4\u00e5\7-\2\2\u00e5:\3\2\2\2\u00e6\u00e7\7,\2\2\u00e7<"+
		"\3\2\2\2\u00e8\u00e9\7\61\2\2\u00e9>\3\2\2\2\u00ea\u00eb\7/\2\2\u00eb"+
		"@\3\2\2\2\u00ec\u00ed\7%\2\2\u00edB\3\2\2\2\16\2\u009a\u009e\u00a0\u00a6"+
		"\u00a8\u00b5\u00ba\u00bc\u00c3\u00c9\u00cb\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}