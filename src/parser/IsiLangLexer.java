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
		OPREL=10, ID=11, TEXTO=12, NUMBER=13, WS=14, AP=15, FP=16, PR=17, DQ=18, 
		ATR=19, VIR=20, ACH=21, FCH=22, SOM=23, MUL=24, DIV=25, SUB=26;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"OPREL", "ID", "TEXTO", "NUMBER", "WS", "AP", "FP", "PR", "DQ", "ATR", 
		"VIR", "ACH", "FCH", "SOM", "MUL", "DIV", "SUB"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog.'", "'declare'", "'leia'", "'escreva'", 
		"'se'", "'entao'", "'senao'", "'enquanto'", null, null, null, null, null, 
		"'('", "')'", "'.'", "'\"'", "':='", "','", "'{'", "'}'", "'+'", "'*'", 
		"'/'", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "OPREL", "ID", 
		"TEXTO", "NUMBER", "WS", "AP", "FP", "PR", "DQ", "ATR", "VIR", "ACH", 
		"FCH", "SOM", "MUL", "DIV", "SUB"
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


		private int _tipo;
		private String _varName;
		private String _varValue;
		private IsiSymbolTable symbolTable = new IsiSymbolTable();
		private IsiSymbol symbol;
		private GenerateJavaCode program = new GenerateJavaCode();
		private ArrayList<AbstractCommand> curThread;
		private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
		private String _readID;
		private String _writeID;
		private String _exprID;
		private String _exprContent;
		private String _exprDecision;
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\34\u00bd\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0080\n\13\3\f\5\f\u0083"+
		"\n\f\3\f\7\f\u0086\n\f\f\f\16\f\u0089\13\f\3\r\3\r\3\r\6\r\u008e\n\r\r"+
		"\r\16\r\u008f\3\r\3\r\3\16\6\16\u0095\n\16\r\16\16\16\u0096\3\16\3\16"+
		"\6\16\u009b\n\16\r\16\16\16\u009c\5\16\u009f\n\16\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\2\2\34\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\3\2\7\4\2>>@@\4\2C\\c"+
		"|\5\2\62;C\\c|\3\2\62;\5\2\13\f\17\17\"\"\2\u00c6\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\3\67\3\2\2\2\5@\3\2\2\2\7I\3\2\2\2\tQ\3\2\2\2\13V"+
		"\3\2\2\2\r^\3\2\2\2\17a\3\2\2\2\21g\3\2\2\2\23m\3\2\2\2\25\177\3\2\2\2"+
		"\27\u0082\3\2\2\2\31\u008a\3\2\2\2\33\u0094\3\2\2\2\35\u00a0\3\2\2\2\37"+
		"\u00a4\3\2\2\2!\u00a6\3\2\2\2#\u00a8\3\2\2\2%\u00aa\3\2\2\2\'\u00ac\3"+
		"\2\2\2)\u00af\3\2\2\2+\u00b1\3\2\2\2-\u00b3\3\2\2\2/\u00b5\3\2\2\2\61"+
		"\u00b7\3\2\2\2\63\u00b9\3\2\2\2\65\u00bb\3\2\2\2\678\7r\2\289\7t\2\29"+
		":\7q\2\2:;\7i\2\2;<\7t\2\2<=\7c\2\2=>\7o\2\2>?\7c\2\2?\4\3\2\2\2@A\7h"+
		"\2\2AB\7k\2\2BC\7o\2\2CD\7r\2\2DE\7t\2\2EF\7q\2\2FG\7i\2\2GH\7\60\2\2"+
		"H\6\3\2\2\2IJ\7f\2\2JK\7g\2\2KL\7e\2\2LM\7n\2\2MN\7c\2\2NO\7t\2\2OP\7"+
		"g\2\2P\b\3\2\2\2QR\7n\2\2RS\7g\2\2ST\7k\2\2TU\7c\2\2U\n\3\2\2\2VW\7g\2"+
		"\2WX\7u\2\2XY\7e\2\2YZ\7t\2\2Z[\7g\2\2[\\\7x\2\2\\]\7c\2\2]\f\3\2\2\2"+
		"^_\7u\2\2_`\7g\2\2`\16\3\2\2\2ab\7g\2\2bc\7p\2\2cd\7v\2\2de\7c\2\2ef\7"+
		"q\2\2f\20\3\2\2\2gh\7u\2\2hi\7g\2\2ij\7p\2\2jk\7c\2\2kl\7q\2\2l\22\3\2"+
		"\2\2mn\7g\2\2no\7p\2\2op\7s\2\2pq\7w\2\2qr\7c\2\2rs\7p\2\2st\7v\2\2tu"+
		"\7q\2\2u\24\3\2\2\2v\u0080\t\2\2\2wx\7@\2\2x\u0080\7?\2\2yz\7>\2\2z\u0080"+
		"\7?\2\2{|\7?\2\2|\u0080\7?\2\2}~\7#\2\2~\u0080\7?\2\2\177v\3\2\2\2\177"+
		"w\3\2\2\2\177y\3\2\2\2\177{\3\2\2\2\177}\3\2\2\2\u0080\26\3\2\2\2\u0081"+
		"\u0083\t\3\2\2\u0082\u0081\3\2\2\2\u0083\u0087\3\2\2\2\u0084\u0086\t\4"+
		"\2\2\u0085\u0084\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087"+
		"\u0088\3\2\2\2\u0088\30\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008d\5%\23"+
		"\2\u008b\u008e\t\4\2\2\u008c\u008e\5\35\17\2\u008d\u008b\3\2\2\2\u008d"+
		"\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2"+
		"\2\2\u0090\u0091\3\2\2\2\u0091\u0092\5%\23\2\u0092\32\3\2\2\2\u0093\u0095"+
		"\t\5\2\2\u0094\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0094\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097\u009e\3\2\2\2\u0098\u009a\7\60\2\2\u0099\u009b\t"+
		"\5\2\2\u009a\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009a\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u0098\3\2\2\2\u009e\u009f\3\2"+
		"\2\2\u009f\34\3\2\2\2\u00a0\u00a1\t\6\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3"+
		"\b\17\2\2\u00a3\36\3\2\2\2\u00a4\u00a5\7*\2\2\u00a5 \3\2\2\2\u00a6\u00a7"+
		"\7+\2\2\u00a7\"\3\2\2\2\u00a8\u00a9\7\60\2\2\u00a9$\3\2\2\2\u00aa\u00ab"+
		"\7$\2\2\u00ab&\3\2\2\2\u00ac\u00ad\7<\2\2\u00ad\u00ae\7?\2\2\u00ae(\3"+
		"\2\2\2\u00af\u00b0\7.\2\2\u00b0*\3\2\2\2\u00b1\u00b2\7}\2\2\u00b2,\3\2"+
		"\2\2\u00b3\u00b4\7\177\2\2\u00b4.\3\2\2\2\u00b5\u00b6\7-\2\2\u00b6\60"+
		"\3\2\2\2\u00b7\u00b8\7,\2\2\u00b8\62\3\2\2\2\u00b9\u00ba\7\61\2\2\u00ba"+
		"\64\3\2\2\2\u00bb\u00bc\7/\2\2\u00bc\66\3\2\2\2\f\2\177\u0082\u0085\u0087"+
		"\u008d\u008f\u0096\u009c\u009e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}