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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, OPREL=11, ID=12, TEXTO=13, COMMENT=14, NUMBER=15, WS=16, OP=17, 
		AP=18, FP=19, PR=20, DQ=21, ATR=22, VIR=23, ACH=24, FCH=25, SOM=26, MUL=27, 
		DIV=28, SUB=29, CM=30, DP=31;
	public static final int
		RULE_prog = 0, RULE_declara = 1, RULE_texto = 2, RULE_bloco = 3, RULE_cmd = 4, 
		RULE_cmdleitura = 5, RULE_cmdescrita = 6, RULE_cmdexpr = 7, RULE_cmdselecao = 8, 
		RULE_cmdenquanto = 9, RULE_cmdcomentario = 10, RULE_expr = 11, RULE_termo = 12, 
		RULE_fator = 13;
	public static final String[] ruleNames = {
		"prog", "declara", "texto", "bloco", "cmd", "cmdleitura", "cmdescrita", 
		"cmdexpr", "cmdselecao", "cmdenquanto", "cmdcomentario", "expr", "termo", 
		"fator"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog.'", "'declare'", "'texto'", "'leia'", "'escreva'", 
		"'se'", "'entao'", "'senao'", "'enquanto'", null, null, null, null, null, 
		null, null, "'('", "')'", "'.'", "'\"'", "':='", "','", "'{'", "'}'", 
		"'+'", "'*'", "'/'", "'-'", "'#'", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "OPREL", 
		"ID", "TEXTO", "COMMENT", "NUMBER", "WS", "OP", "AP", "FP", "PR", "DQ", 
		"ATR", "VIR", "ACH", "FCH", "SOM", "MUL", "DIV", "SUB", "CM", "DP"
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

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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
		
		public void generateCode(){
			program.generateTarget();
		}

	public IsiLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public List<DeclaraContext> declara() {
			return getRuleContexts(DeclaraContext.class);
		}
		public DeclaraContext declara(int i) {
			return getRuleContext(DeclaraContext.class,i);
		}
		public List<TextoContext> texto() {
			return getRuleContexts(TextoContext.class);
		}
		public TextoContext texto(int i) {
			return getRuleContext(TextoContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(T__0);
			setState(31); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(31);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__2:
					{
					setState(29);
					declara();
					}
					break;
				case T__3:
					{
					setState(30);
					texto();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(33); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 || _la==T__3 );
			setState(35);
			bloco();
			setState(36);
			match(T__1);
			  
				           	  program.setVarTable(symbolTable);
				           	  program.setComandos(stack.pop());   	 
				           
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaraContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode PR() { return getToken(IsiLangParser.PR, 0); }
		public List<TerminalNode> VIR() { return getTokens(IsiLangParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(IsiLangParser.VIR, i);
		}
		public DeclaraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declara; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterDeclara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitDeclara(this);
		}
	}

	public final DeclaraContext declara() throws RecognitionException {
		DeclaraContext _localctx = new DeclaraContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(T__2);
			setState(40);
			match(ID);

				                  		_varName = _input.LT(-1).getText();
				                  		_varValue = null;
				                  		_varType = 2;
				                  		symbol = new IsiVariable(_varName, _varValue, _varType);
				                  		if (!symbolTable.exists(_varName)){
				                     		symbolTable.add(symbol);	
				                  		}
				                  		else{
				                  	 		throw new SemanticException("Symbol "+_varName+" already declared");
				                  	  	}
			                    	  
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(42);
				match(VIR);
				setState(43);
				match(ID);

					                  		_varName = _input.LT(-1).getText();
					                  		_varValue = null;
					                  		_varType = 2;
					                  		symbol = new IsiVariable(_varName, _varValue, _varType);
					                  		if (!symbolTable.exists(_varName)){
					                     		symbolTable.add(symbol);	
					                  		}
					                  		else{
					                  	 		throw new SemanticException("Symbol "+_varName+" already declared");
					                  		}
				                     	  
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50);
			match(PR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TextoContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode PR() { return getToken(IsiLangParser.PR, 0); }
		public List<TerminalNode> VIR() { return getTokens(IsiLangParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(IsiLangParser.VIR, i);
		}
		public TextoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_texto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTexto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTexto(this);
		}
	}

	public final TextoContext texto() throws RecognitionException {
		TextoContext _localctx = new TextoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_texto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(T__3);
			setState(53);
			match(ID);

				                  		_varName = _input.LT(-1).getText();
				                  		_varValue = null;
				                  		_varType = 1;
				                  		symbol = new IsiVariable(_varName, _varValue, _varType);
				                  		if (!symbolTable.exists(_varName)){
				                     		symbolTable.add(symbol);	
				                  		}
				                  		else{
				                  	 		throw new SemanticException("Symbol "+_varName+" already declared");
				                  	  	}
			                    	  
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(55);
				match(VIR);
				setState(56);
				match(ID);

					                  		_varName = _input.LT(-1).getText();
					                  		_varValue = null;
					                  		_varType = 1;
					                  		symbol = new IsiVariable(_varName, _varValue, _varType);
					                  		if (!symbolTable.exists(_varName)){
					                     		symbolTable.add(symbol);	
					                  		}
					                  		else{
					                  	 		throw new SemanticException("Symbol "+_varName+" already declared");
					                  		}
				                     	  
				}
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(63);
			match(PR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 
					       curThread = new ArrayList<AbstractCommand>(); 
				           stack.push(curThread);  
			          
			setState(67); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(66);
				cmd();
				}
				}
				setState(69); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__9) | (1L << ID) | (1L << COMMENT))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdContext extends ParserRuleContext {
		public CmdleituraContext cmdleitura() {
			return getRuleContext(CmdleituraContext.class,0);
		}
		public CmdescritaContext cmdescrita() {
			return getRuleContext(CmdescritaContext.class,0);
		}
		public CmdexprContext cmdexpr() {
			return getRuleContext(CmdexprContext.class,0);
		}
		public CmdselecaoContext cmdselecao() {
			return getRuleContext(CmdselecaoContext.class,0);
		}
		public CmdenquantoContext cmdenquanto() {
			return getRuleContext(CmdenquantoContext.class,0);
		}
		public CmdcomentarioContext cmdcomentario() {
			return getRuleContext(CmdcomentarioContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cmd);
		try {
			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				cmdleitura();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				cmdescrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				cmdexpr();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 4);
				{
				setState(74);
				cmdselecao();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 5);
				{
				setState(75);
				cmdenquanto();
				}
				break;
			case COMMENT:
				enterOuterAlt(_localctx, 6);
				{
				setState(76);
				cmdcomentario();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdleituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode PR() { return getToken(IsiLangParser.PR, 0); }
		public CmdleituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdleitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdleitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdleitura(this);
		}
	}

	public final CmdleituraContext cmdleitura() throws RecognitionException {
		CmdleituraContext _localctx = new CmdleituraContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(T__4);
			setState(80);
			match(AP);
			setState(81);
			match(ID);
			 
			                     		verificaID(_input.LT(-1).getText());
			                     	  	_readID = _input.LT(-1).getText();
			                        
			setState(83);
			match(FP);
			setState(84);
			match(PR);

			              	IsiVariable var = (IsiVariable)symbolTable.get(_readID);
			              	CommandLeitura cmd = new CommandLeitura(_readID, var);
			              	stack.peek().add(cmd);
			              
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdescritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode PR() { return getToken(IsiLangParser.PR, 0); }
		public TerminalNode TEXTO() { return getToken(IsiLangParser.TEXTO, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public CmdescritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdescrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdescrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdescrita(this);
		}
	}

	public final CmdescritaContext cmdescrita() throws RecognitionException {
		CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(T__5);
			setState(88);
			match(AP);
			setState(93);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEXTO:
				{
				setState(89);
				match(TEXTO);

				                 						_writeID = null;
				                 						_writeTEXTO = _input.LT(-1).getText();
				                 				   	
				}
				break;
			case ID:
				{
				setState(91);
				match(ID);
				 
					             						verificaID(_input.LT(-1).getText());
					                     	  			_writeID = _input.LT(-1).getText();
					                    			
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(95);
			match(FP);
			setState(96);
			match(PR);

			               	  			CommandEscrita cmd = new CommandEscrita(_writeID, _writeTEXTO);
			               	  			stack.peek().add(cmd);
			               			
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdexprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode ATR() { return getToken(IsiLangParser.ATR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PR() { return getToken(IsiLangParser.PR, 0); }
		public CmdexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdexpr(this);
		}
	}

	public final CmdexprContext cmdexpr() throws RecognitionException {
		CmdexprContext _localctx = new CmdexprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdexpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(ID);
			 
									verificaID(_input.LT(-1).getText());
			                    	_exprID = _input.LT(-1).getText();
			                  
			setState(101);
			match(ATR);
			 _exprContent = ""; 
			setState(103);
			expr();
			setState(104);
			match(PR);

			               	 	CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
			               	 	stack.peek().add(cmd);
			               
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdselecaoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OPREL() { return getToken(IsiLangParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public List<TerminalNode> ACH() { return getTokens(IsiLangParser.ACH); }
		public TerminalNode ACH(int i) {
			return getToken(IsiLangParser.ACH, i);
		}
		public List<TerminalNode> FCH() { return getTokens(IsiLangParser.FCH); }
		public TerminalNode FCH(int i) {
			return getToken(IsiLangParser.FCH, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdselecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdselecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdselecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdselecao(this);
		}
	}

	public final CmdselecaoContext cmdselecao() throws RecognitionException {
		CmdselecaoContext _localctx = new CmdselecaoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdselecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(T__6);
			setState(108);
			match(AP);
			setState(109);
			expr();
			 _exprDecision = _input.LT(-1).getText(); 
			setState(111);
			match(OPREL);
			 _exprDecision += _input.LT(-1).getText(); 
			setState(113);
			expr();
			 _exprDecision += _input.LT(-1).getText(); 
			setState(115);
			match(FP);
			setState(116);
			match(T__7);
			setState(117);
			match(ACH);
			 
			                    		curThread = new ArrayList<AbstractCommand>(); 
			                      		stack.push(curThread);
			                    	
			setState(120); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(119);
				cmd();
				}
				}
				setState(122); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__9) | (1L << ID) | (1L << COMMENT))) != 0) );
			setState(124);
			match(FCH);

			                       		listaTrue = stack.pop();	
			                    	
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(126);
				match(T__8);
				setState(127);
				match(ACH);

				                   	 		curThread = new ArrayList<AbstractCommand>();
				                   	 		stack.push(curThread);
				                   	 	
				{
				setState(130); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(129);
					cmd();
					}
					}
					setState(132); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__9) | (1L << ID) | (1L << COMMENT))) != 0) );
				}
				setState(134);
				match(FCH);

				                   			listaFalse = stack.pop();
				                   			CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
				                   			stack.peek().add(cmd);
				                   		
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdenquantoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OPREL() { return getToken(IsiLangParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode ACH() { return getToken(IsiLangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(IsiLangParser.FCH, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdenquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdenquanto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdenquanto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdenquanto(this);
		}
	}

	public final CmdenquantoContext cmdenquanto() throws RecognitionException {
		CmdenquantoContext _localctx = new CmdenquantoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdenquanto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(T__9);
			setState(140);
			match(AP);
			setState(141);
			expr();
			 _exprEnquanto = _input.LT(-1).getText(); 
			setState(143);
			match(OPREL);
			 _exprEnquanto += _input.LT(-1).getText(); 
			setState(145);
			expr();
			 _exprEnquanto += _input.LT(-1).getText(); 
			setState(147);
			match(FP);
			setState(148);
			match(ACH);
			 
			                    		curThread = new ArrayList<AbstractCommand>(); 
			                      		stack.push(curThread);
			                    	
			setState(151); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(150);
				cmd();
				}
				}
				setState(153); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__9) | (1L << ID) | (1L << COMMENT))) != 0) );
			setState(155);
			match(FCH);

			                       		listaTrue = stack.pop();	
										CommandEnquanto cmd = new CommandEnquanto(_exprEnquanto, listaTrue);
			                   			stack.peek().add(cmd);
			                    	
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdcomentarioContext extends ParserRuleContext {
		public TerminalNode COMMENT() { return getToken(IsiLangParser.COMMENT, 0); }
		public CmdcomentarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdcomentario; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdcomentario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdcomentario(this);
		}
	}

	public final CmdcomentarioContext cmdcomentario() throws RecognitionException {
		CmdcomentarioContext _localctx = new CmdcomentarioContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdcomentario);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(COMMENT);

							 			curThread = new ArrayList<AbstractCommand>();
			                   	   		stack.push(curThread);
										listaComments = stack.pop();
			               	  			CommandComentario cmd = new CommandComentario(_input.LT(-1).getText());
			               	  			stack.peek().add(cmd); 
									
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> OP() { return getTokens(IsiLangParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(IsiLangParser.OP, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			termo();
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(162);
				match(OP);
				 _exprContent += _input.LT(-1).getText();
				setState(164);
				termo();
				}
				}
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermoContext extends ParserRuleContext {
		public List<FatorContext> fator() {
			return getRuleContexts(FatorContext.class);
		}
		public FatorContext fator(int i) {
			return getRuleContext(FatorContext.class,i);
		}
		public List<TerminalNode> OP() { return getTokens(IsiLangParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(IsiLangParser.OP, i);
		}
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_termo);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			fator();
			setState(176);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(171);
					match(OP);
					 _exprContent += _input.LT(-1).getText();
					setState(173);
					fator();
					}
					} 
				}
				setState(178);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FatorContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode TEXTO() { return getToken(IsiLangParser.TEXTO, 0); }
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterFator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitFator(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_fator);
		try {
			setState(189);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				match(NUMBER);

				              			_exprContent += _input.LT(-1).getText();
				              			IsiVariable var = (IsiVariable)symbolTable.get(_readID);
				              			var.setType(_input.LT(-1).getText());
				              		 
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				match(ID);
				 
				            			verificaID(_input.LT(-1).getText());
					                	_exprContent += _input.LT(-1).getText();
				                     
				}
				break;
			case TEXTO:
				enterOuterAlt(_localctx, 3);
				{
				setState(183);
				match(TEXTO);

				              			_exprContent += _input.LT(-1).getText();
				              		 
				}
				break;
			case AP:
				enterOuterAlt(_localctx, 4);
				{
				setState(185);
				match(AP);
				setState(186);
				expr();
				setState(187);
				match(FP);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u00c2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\6\2\"\n\2\r\2\16\2"+
		"#\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3\60\n\3\f\3\16\3\63\13\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4=\n\4\f\4\16\4@\13\4\3\4\3\4\3\5\3"+
		"\5\6\5F\n\5\r\5\16\5G\3\6\3\6\3\6\3\6\3\6\3\6\5\6P\n\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b`\n\b\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\6\n{\n\n\r\n\16\n|\3\n\3\n\3\n\3\n\3\n\3\n\6\n\u0085\n\n\r"+
		"\n\16\n\u0086\3\n\3\n\3\n\5\n\u008c\n\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\6\13\u009a\n\13\r\13\16\13\u009b\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\7\r\u00a8\n\r\f\r\16\r\u00ab\13\r"+
		"\3\16\3\16\3\16\3\16\7\16\u00b1\n\16\f\16\16\16\u00b4\13\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00c0\n\17\3\17\2\2\20\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\2\2\2\u00c7\2\36\3\2\2\2\4)\3\2\2\2"+
		"\6\66\3\2\2\2\bC\3\2\2\2\nO\3\2\2\2\fQ\3\2\2\2\16Y\3\2\2\2\20e\3\2\2\2"+
		"\22m\3\2\2\2\24\u008d\3\2\2\2\26\u00a0\3\2\2\2\30\u00a3\3\2\2\2\32\u00ac"+
		"\3\2\2\2\34\u00bf\3\2\2\2\36!\7\3\2\2\37\"\5\4\3\2 \"\5\6\4\2!\37\3\2"+
		"\2\2! \3\2\2\2\"#\3\2\2\2#!\3\2\2\2#$\3\2\2\2$%\3\2\2\2%&\5\b\5\2&\'\7"+
		"\4\2\2\'(\b\2\1\2(\3\3\2\2\2)*\7\5\2\2*+\7\16\2\2+\61\b\3\1\2,-\7\31\2"+
		"\2-.\7\16\2\2.\60\b\3\1\2/,\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3"+
		"\2\2\2\62\64\3\2\2\2\63\61\3\2\2\2\64\65\7\26\2\2\65\5\3\2\2\2\66\67\7"+
		"\6\2\2\678\7\16\2\28>\b\4\1\29:\7\31\2\2:;\7\16\2\2;=\b\4\1\2<9\3\2\2"+
		"\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?A\3\2\2\2@>\3\2\2\2AB\7\26\2\2B\7\3\2"+
		"\2\2CE\b\5\1\2DF\5\n\6\2ED\3\2\2\2FG\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\t\3"+
		"\2\2\2IP\5\f\7\2JP\5\16\b\2KP\5\20\t\2LP\5\22\n\2MP\5\24\13\2NP\5\26\f"+
		"\2OI\3\2\2\2OJ\3\2\2\2OK\3\2\2\2OL\3\2\2\2OM\3\2\2\2ON\3\2\2\2P\13\3\2"+
		"\2\2QR\7\7\2\2RS\7\24\2\2ST\7\16\2\2TU\b\7\1\2UV\7\25\2\2VW\7\26\2\2W"+
		"X\b\7\1\2X\r\3\2\2\2YZ\7\b\2\2Z_\7\24\2\2[\\\7\17\2\2\\`\b\b\1\2]^\7\16"+
		"\2\2^`\b\b\1\2_[\3\2\2\2_]\3\2\2\2`a\3\2\2\2ab\7\25\2\2bc\7\26\2\2cd\b"+
		"\b\1\2d\17\3\2\2\2ef\7\16\2\2fg\b\t\1\2gh\7\30\2\2hi\b\t\1\2ij\5\30\r"+
		"\2jk\7\26\2\2kl\b\t\1\2l\21\3\2\2\2mn\7\t\2\2no\7\24\2\2op\5\30\r\2pq"+
		"\b\n\1\2qr\7\r\2\2rs\b\n\1\2st\5\30\r\2tu\b\n\1\2uv\7\25\2\2vw\7\n\2\2"+
		"wx\7\32\2\2xz\b\n\1\2y{\5\n\6\2zy\3\2\2\2{|\3\2\2\2|z\3\2\2\2|}\3\2\2"+
		"\2}~\3\2\2\2~\177\7\33\2\2\177\u008b\b\n\1\2\u0080\u0081\7\13\2\2\u0081"+
		"\u0082\7\32\2\2\u0082\u0084\b\n\1\2\u0083\u0085\5\n\6\2\u0084\u0083\3"+
		"\2\2\2\u0085\u0086\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087"+
		"\u0088\3\2\2\2\u0088\u0089\7\33\2\2\u0089\u008a\b\n\1\2\u008a\u008c\3"+
		"\2\2\2\u008b\u0080\3\2\2\2\u008b\u008c\3\2\2\2\u008c\23\3\2\2\2\u008d"+
		"\u008e\7\f\2\2\u008e\u008f\7\24\2\2\u008f\u0090\5\30\r\2\u0090\u0091\b"+
		"\13\1\2\u0091\u0092\7\r\2\2\u0092\u0093\b\13\1\2\u0093\u0094\5\30\r\2"+
		"\u0094\u0095\b\13\1\2\u0095\u0096\7\25\2\2\u0096\u0097\7\32\2\2\u0097"+
		"\u0099\b\13\1\2\u0098\u009a\5\n\6\2\u0099\u0098\3\2\2\2\u009a\u009b\3"+
		"\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\u009e\7\33\2\2\u009e\u009f\b\13\1\2\u009f\25\3\2\2\2\u00a0\u00a1\7\20"+
		"\2\2\u00a1\u00a2\b\f\1\2\u00a2\27\3\2\2\2\u00a3\u00a9\5\32\16\2\u00a4"+
		"\u00a5\7\23\2\2\u00a5\u00a6\b\r\1\2\u00a6\u00a8\5\32\16\2\u00a7\u00a4"+
		"\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa"+
		"\31\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00b2\5\34\17\2\u00ad\u00ae\7\23"+
		"\2\2\u00ae\u00af\b\16\1\2\u00af\u00b1\5\34\17\2\u00b0\u00ad\3\2\2\2\u00b1"+
		"\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\33\3\2\2"+
		"\2\u00b4\u00b2\3\2\2\2\u00b5\u00b6\7\21\2\2\u00b6\u00c0\b\17\1\2\u00b7"+
		"\u00b8\7\16\2\2\u00b8\u00c0\b\17\1\2\u00b9\u00ba\7\17\2\2\u00ba\u00c0"+
		"\b\17\1\2\u00bb\u00bc\7\24\2\2\u00bc\u00bd\5\30\r\2\u00bd\u00be\7\25\2"+
		"\2\u00be\u00c0\3\2\2\2\u00bf\u00b5\3\2\2\2\u00bf\u00b7\3\2\2\2\u00bf\u00b9"+
		"\3\2\2\2\u00bf\u00bb\3\2\2\2\u00c0\35\3\2\2\2\20!#\61>GO_|\u0086\u008b"+
		"\u009b\u00a9\u00b2\u00bf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}