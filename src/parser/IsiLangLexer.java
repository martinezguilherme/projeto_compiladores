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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, OPREL=9, 
		ID=10, TEXTO=11, NUMBER=12, WS=13, OP=14, AP=15, FP=16, PR=17, DQ=18, 
		ATR=19, VIR=20, ACH=21, FCH=22, SOM=23, MUL=24, DIV=25, SUB=26;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "OPREL", 
		"ID", "TEXTO", "NUMBER", "WS", "OP", "AP", "FP", "PR", "DQ", "ATR", "VIR", 
		"ACH", "FCH", "SOM", "MUL", "DIV", "SUB"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog;'", "'numero'", "'texto'", "'leia'", "'escreva'", 
		"'se'", "'senao'", null, null, null, null, null, null, "'('", "')'", "'.'", 
		"'\"'", "':='", "','", "'{'", "'}'", "'+'", "'*'", "'/'", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "OPREL", "ID", "TEXTO", 
		"NUMBER", "WS", "OP", "AP", "FP", "PR", "DQ", "ATR", "VIR", "ACH", "FCH", 
		"SOM", "MUL", "DIV", "SUB"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\34\u00b5\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nv"+
		"\n\n\3\13\5\13y\n\13\3\13\7\13|\n\13\f\13\16\13\177\13\13\3\f\3\f\3\f"+
		"\6\f\u0084\n\f\r\f\16\f\u0085\3\f\3\f\3\r\6\r\u008b\n\r\r\r\16\r\u008c"+
		"\3\r\3\r\6\r\u0091\n\r\r\r\16\r\u0092\5\r\u0095\n\r\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\2\2"+
		"\34\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\3\2\b\4\2"+
		">>@@\4\2C\\c|\5\2\62;C\\c|\3\2\62;\5\2\13\f\17\17\"\"\5\2,-//\61\61\2"+
		"\u00be\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\3\67\3\2\2\2\5@\3\2\2"+
		"\2\7I\3\2\2\2\tP\3\2\2\2\13V\3\2\2\2\r[\3\2\2\2\17c\3\2\2\2\21f\3\2\2"+
		"\2\23u\3\2\2\2\25x\3\2\2\2\27\u0080\3\2\2\2\31\u008a\3\2\2\2\33\u0096"+
		"\3\2\2\2\35\u009a\3\2\2\2\37\u009c\3\2\2\2!\u009e\3\2\2\2#\u00a0\3\2\2"+
		"\2%\u00a2\3\2\2\2\'\u00a4\3\2\2\2)\u00a7\3\2\2\2+\u00a9\3\2\2\2-\u00ab"+
		"\3\2\2\2/\u00ad\3\2\2\2\61\u00af\3\2\2\2\63\u00b1\3\2\2\2\65\u00b3\3\2"+
		"\2\2\678\7r\2\289\7t\2\29:\7q\2\2:;\7i\2\2;<\7t\2\2<=\7c\2\2=>\7o\2\2"+
		">?\7c\2\2?\4\3\2\2\2@A\7h\2\2AB\7k\2\2BC\7o\2\2CD\7r\2\2DE\7t\2\2EF\7"+
		"q\2\2FG\7i\2\2GH\7=\2\2H\6\3\2\2\2IJ\7p\2\2JK\7w\2\2KL\7o\2\2LM\7g\2\2"+
		"MN\7t\2\2NO\7q\2\2O\b\3\2\2\2PQ\7v\2\2QR\7g\2\2RS\7z\2\2ST\7v\2\2TU\7"+
		"q\2\2U\n\3\2\2\2VW\7n\2\2WX\7g\2\2XY\7k\2\2YZ\7c\2\2Z\f\3\2\2\2[\\\7g"+
		"\2\2\\]\7u\2\2]^\7e\2\2^_\7t\2\2_`\7g\2\2`a\7x\2\2ab\7c\2\2b\16\3\2\2"+
		"\2cd\7u\2\2de\7g\2\2e\20\3\2\2\2fg\7u\2\2gh\7g\2\2hi\7p\2\2ij\7c\2\2j"+
		"k\7q\2\2k\22\3\2\2\2lv\t\2\2\2mn\7@\2\2nv\7?\2\2op\7>\2\2pv\7?\2\2qr\7"+
		"?\2\2rv\7?\2\2st\7#\2\2tv\7?\2\2ul\3\2\2\2um\3\2\2\2uo\3\2\2\2uq\3\2\2"+
		"\2us\3\2\2\2v\24\3\2\2\2wy\t\3\2\2xw\3\2\2\2y}\3\2\2\2z|\t\4\2\2{z\3\2"+
		"\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\26\3\2\2\2\177}\3\2\2\2\u0080\u0083"+
		"\5%\23\2\u0081\u0084\t\4\2\2\u0082\u0084\5\33\16\2\u0083\u0081\3\2\2\2"+
		"\u0083\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086"+
		"\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\5%\23\2\u0088\30\3\2\2\2\u0089"+
		"\u008b\t\5\2\2\u008a\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008a\3\2"+
		"\2\2\u008c\u008d\3\2\2\2\u008d\u0094\3\2\2\2\u008e\u0090\7\60\2\2\u008f"+
		"\u0091\t\5\2\2\u0090\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0090\3\2"+
		"\2\2\u0092\u0093\3\2\2\2\u0093\u0095\3\2\2\2\u0094\u008e\3\2\2\2\u0094"+
		"\u0095\3\2\2\2\u0095\32\3\2\2\2\u0096\u0097\t\6\2\2\u0097\u0098\3\2\2"+
		"\2\u0098\u0099\b\16\2\2\u0099\34\3\2\2\2\u009a\u009b\t\7\2\2\u009b\36"+
		"\3\2\2\2\u009c\u009d\7*\2\2\u009d \3\2\2\2\u009e\u009f\7+\2\2\u009f\""+
		"\3\2\2\2\u00a0\u00a1\7\60\2\2\u00a1$\3\2\2\2\u00a2\u00a3\7$\2\2\u00a3"+
		"&\3\2\2\2\u00a4\u00a5\7<\2\2\u00a5\u00a6\7?\2\2\u00a6(\3\2\2\2\u00a7\u00a8"+
		"\7.\2\2\u00a8*\3\2\2\2\u00a9\u00aa\7}\2\2\u00aa,\3\2\2\2\u00ab\u00ac\7"+
		"\177\2\2\u00ac.\3\2\2\2\u00ad\u00ae\7-\2\2\u00ae\60\3\2\2\2\u00af\u00b0"+
		"\7,\2\2\u00b0\62\3\2\2\2\u00b1\u00b2\7\61\2\2\u00b2\64\3\2\2\2\u00b3\u00b4"+
		"\7/\2\2\u00b4\66\3\2\2\2\f\2ux{}\u0083\u0085\u008c\u0092\u0094\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}