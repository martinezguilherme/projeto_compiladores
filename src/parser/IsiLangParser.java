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
		T__9=10, OPREL=11, ID=12, TEXTO=13, NUMBER=14, WS=15, OP=16, AP=17, FP=18, 
		PR=19, DQ=20, ATR=21, VIR=22, ACH=23, FCH=24, SOM=25, MUL=26, DIV=27, 
		SUB=28;
	public static final int
		RULE_prog = 0, RULE_declara = 1, RULE_texto = 2, RULE_bloco = 3, RULE_cmd = 4, 
		RULE_cmdleitura = 5, RULE_cmdescrita = 6, RULE_cmdexpr = 7, RULE_cmdselecao = 8, 
		RULE_cmdenquanto = 9, RULE_expr = 10, RULE_termo = 11, RULE_fator = 12;
	public static final String[] ruleNames = {
		"prog", "declara", "texto", "bloco", "cmd", "cmdleitura", "cmdescrita", 
		"cmdexpr", "cmdselecao", "cmdenquanto", "expr", "termo", "fator"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog.'", "'declare'", "'texto'", "'leia'", "'escreva'", 
		"'se'", "'entao'", "'senao'", "'enquanto'", null, null, null, null, null, 
		null, "'('", "')'", "'.'", "'\"'", "':='", "','", "'{'", "'}'", "'+'", 
		"'*'", "'/'", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "OPREL", 
		"ID", "TEXTO", "NUMBER", "WS", "OP", "AP", "FP", "PR", "DQ", "ATR", "VIR", 
		"ACH", "FCH", "SOM", "MUL", "DIV", "SUB"
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

		public void variavelUti(String id){ 
			symbolTable.varUtilizada(id);
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
			setState(26);
			match(T__0);
			setState(29); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(29);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__2:
					{
					setState(27);
					declara();
					}
					break;
				case T__3:
					{
					setState(28);
					texto();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(31); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 || _la==T__3 );
			setState(33);
			bloco();
			setState(34);
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
			setState(37);
			match(T__2);
			setState(38);
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
			                    	  
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(40);
				match(VIR);
				setState(41);
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
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48);
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
			setState(50);
			match(T__3);
			setState(51);
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
			                    	  
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(53);
				match(VIR);
				setState(54);
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
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61);
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
			          
			setState(65); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(64);
				cmd();
				}
				}
				setState(67); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__9) | (1L << ID))) != 0) );
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
			setState(74);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				cmdleitura();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				cmdescrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
				cmdexpr();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 4);
				{
				setState(72);
				cmdselecao();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 5);
				{
				setState(73);
				cmdenquanto();
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
			setState(76);
			match(T__4);
			setState(77);
			match(AP);
			setState(78);
			match(ID);
			 
			                     		verificaID(_input.LT(-1).getText());
			                     	  	_readID = _input.LT(-1).getText();
			                        
			setState(80);
			match(FP);
			setState(81);
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
			setState(84);
			match(T__5);
			setState(85);
			match(AP);
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEXTO:
				{
				setState(86);
				match(TEXTO);

				                 						_writeID = null;
				                 						_writeTEXTO = _input.LT(-1).getText();
				                 				   	
				}
				break;
			case ID:
				{
				setState(88);
				match(ID);
				 
					             						verificaID(_input.LT(-1).getText());
					                     	  			_writeID = _input.LT(-1).getText();
														variavelUti(_writeID);
					                    			
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(92);
			match(FP);
			setState(93);
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
			setState(96);
			match(ID);
			 
									verificaID(_input.LT(-1).getText());
			                    	_exprID = _input.LT(-1).getText();
			                  
			setState(98);
			match(ATR);
			 _exprContent = ""; 
			setState(100);
			expr();
			setState(101);
			match(PR);

			               	 	CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
								// variavelUti(_exprID);
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
			setState(104);
			match(T__6);
			setState(105);
			match(AP);
			setState(106);
			expr();
			 _exprDecision = _input.LT(-1).getText(); 
			setState(108);
			match(OPREL);
			 _exprDecision += _input.LT(-1).getText(); 
			setState(110);
			expr();
			 _exprDecision += _input.LT(-1).getText(); 
			setState(112);
			match(FP);
			setState(113);
			match(T__7);
			setState(114);
			match(ACH);
			 
			                    		curThread = new ArrayList<AbstractCommand>(); 
			                      		stack.push(curThread);
			                    	
			setState(117); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(116);
				cmd();
				}
				}
				setState(119); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__9) | (1L << ID))) != 0) );
			setState(121);
			match(FCH);

			                       		listaTrue = stack.pop();	
			                    	
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(123);
				match(T__8);
				setState(124);
				match(ACH);

				                   	 		curThread = new ArrayList<AbstractCommand>();
				                   	 		stack.push(curThread);
				                   	 	
				{
				setState(127); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(126);
					cmd();
					}
					}
					setState(129); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__9) | (1L << ID))) != 0) );
				}
				setState(131);
				match(FCH);

				                   			listaFalse = stack.pop();
				                   			
				                   		
				}
			}


			               		CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
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
			setState(138);
			match(T__9);
			setState(139);
			match(AP);
			setState(140);
			expr();
			 _exprEnquanto = _input.LT(-1).getText(); 
			setState(142);
			match(OPREL);
			 _exprEnquanto += _input.LT(-1).getText(); 
			setState(144);
			expr();
			 _exprEnquanto += _input.LT(-1).getText(); 
			setState(146);
			match(FP);
			setState(147);
			match(ACH);
			 
			                    		curThread = new ArrayList<AbstractCommand>(); 
			                      		stack.push(curThread);
			                    	
			setState(150); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(149);
				cmd();
				}
				}
				setState(152); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__9) | (1L << ID))) != 0) );
			setState(154);
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
		enterRule(_localctx, 20, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			termo();
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(158);
				match(OP);
				 _exprContent += _input.LT(-1).getText();
				setState(160);
				termo();
				}
				}
				setState(165);
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
		enterRule(_localctx, 22, RULE_termo);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			fator();
			setState(172);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(167);
					match(OP);
					 _exprContent += _input.LT(-1).getText();
					setState(169);
					fator();
					}
					} 
				}
				setState(174);
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
		enterRule(_localctx, 24, RULE_fator);
		try {
			setState(185);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				match(NUMBER);

				              			_exprContent += _input.LT(-1).getText();
				              			IsiVariable var = (IsiVariable)symbolTable.get(_readID);
				              			var.setType(_input.LT(-1).getText());
				              		 
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				match(ID);
				 
				            			verificaID(_input.LT(-1).getText());
										variavelUti(_input.LT(-1).getText());
					                	_exprContent += _input.LT(-1).getText();
				                     
				}
				break;
			case TEXTO:
				enterOuterAlt(_localctx, 3);
				{
				setState(179);
				match(TEXTO);

				              			_exprContent += _input.LT(-1).getText();
				              		 
				}
				break;
			case AP:
				enterOuterAlt(_localctx, 4);
				{
				setState(181);
				match(AP);
				setState(182);
				expr();
				setState(183);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\36\u00be\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\6\2 \n\2\r\2\16\2!\3\2\3\2"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3.\n\3\f\3\16\3\61\13\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\7\4;\n\4\f\4\16\4>\13\4\3\4\3\4\3\5\3\5\6\5D\n\5"+
		"\r\5\16\5E\3\6\3\6\3\6\3\6\3\6\5\6M\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b]\n\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\6\n"+
		"x\n\n\r\n\16\ny\3\n\3\n\3\n\3\n\3\n\3\n\6\n\u0082\n\n\r\n\16\n\u0083\3"+
		"\n\3\n\3\n\5\n\u0089\n\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\6\13\u0099\n\13\r\13\16\13\u009a\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\7\f\u00a4\n\f\f\f\16\f\u00a7\13\f\3\r\3\r\3\r\3\r\7\r"+
		"\u00ad\n\r\f\r\16\r\u00b0\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\5\16\u00bc\n\16\3\16\2\2\17\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\2\2\2\u00c3\2\34\3\2\2\2\4\'\3\2\2\2\6\64\3\2\2\2\bA\3\2\2\2\nL\3\2\2"+
		"\2\fN\3\2\2\2\16V\3\2\2\2\20b\3\2\2\2\22j\3\2\2\2\24\u008c\3\2\2\2\26"+
		"\u009f\3\2\2\2\30\u00a8\3\2\2\2\32\u00bb\3\2\2\2\34\37\7\3\2\2\35 \5\4"+
		"\3\2\36 \5\6\4\2\37\35\3\2\2\2\37\36\3\2\2\2 !\3\2\2\2!\37\3\2\2\2!\""+
		"\3\2\2\2\"#\3\2\2\2#$\5\b\5\2$%\7\4\2\2%&\b\2\1\2&\3\3\2\2\2\'(\7\5\2"+
		"\2()\7\16\2\2)/\b\3\1\2*+\7\30\2\2+,\7\16\2\2,.\b\3\1\2-*\3\2\2\2.\61"+
		"\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\62\3\2\2\2\61/\3\2\2\2\62\63\7\25\2"+
		"\2\63\5\3\2\2\2\64\65\7\6\2\2\65\66\7\16\2\2\66<\b\4\1\2\678\7\30\2\2"+
		"89\7\16\2\29;\b\4\1\2:\67\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=?\3\2"+
		"\2\2><\3\2\2\2?@\7\25\2\2@\7\3\2\2\2AC\b\5\1\2BD\5\n\6\2CB\3\2\2\2DE\3"+
		"\2\2\2EC\3\2\2\2EF\3\2\2\2F\t\3\2\2\2GM\5\f\7\2HM\5\16\b\2IM\5\20\t\2"+
		"JM\5\22\n\2KM\5\24\13\2LG\3\2\2\2LH\3\2\2\2LI\3\2\2\2LJ\3\2\2\2LK\3\2"+
		"\2\2M\13\3\2\2\2NO\7\7\2\2OP\7\23\2\2PQ\7\16\2\2QR\b\7\1\2RS\7\24\2\2"+
		"ST\7\25\2\2TU\b\7\1\2U\r\3\2\2\2VW\7\b\2\2W\\\7\23\2\2XY\7\17\2\2Y]\b"+
		"\b\1\2Z[\7\16\2\2[]\b\b\1\2\\X\3\2\2\2\\Z\3\2\2\2]^\3\2\2\2^_\7\24\2\2"+
		"_`\7\25\2\2`a\b\b\1\2a\17\3\2\2\2bc\7\16\2\2cd\b\t\1\2de\7\27\2\2ef\b"+
		"\t\1\2fg\5\26\f\2gh\7\25\2\2hi\b\t\1\2i\21\3\2\2\2jk\7\t\2\2kl\7\23\2"+
		"\2lm\5\26\f\2mn\b\n\1\2no\7\r\2\2op\b\n\1\2pq\5\26\f\2qr\b\n\1\2rs\7\24"+
		"\2\2st\7\n\2\2tu\7\31\2\2uw\b\n\1\2vx\5\n\6\2wv\3\2\2\2xy\3\2\2\2yw\3"+
		"\2\2\2yz\3\2\2\2z{\3\2\2\2{|\7\32\2\2|\u0088\b\n\1\2}~\7\13\2\2~\177\7"+
		"\31\2\2\177\u0081\b\n\1\2\u0080\u0082\5\n\6\2\u0081\u0080\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2"+
		"\2\2\u0085\u0086\7\32\2\2\u0086\u0087\b\n\1\2\u0087\u0089\3\2\2\2\u0088"+
		"}\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\b\n\1\2"+
		"\u008b\23\3\2\2\2\u008c\u008d\7\f\2\2\u008d\u008e\7\23\2\2\u008e\u008f"+
		"\5\26\f\2\u008f\u0090\b\13\1\2\u0090\u0091\7\r\2\2\u0091\u0092\b\13\1"+
		"\2\u0092\u0093\5\26\f\2\u0093\u0094\b\13\1\2\u0094\u0095\7\24\2\2\u0095"+
		"\u0096\7\31\2\2\u0096\u0098\b\13\1\2\u0097\u0099\5\n\6\2\u0098\u0097\3"+
		"\2\2\2\u0099\u009a\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\u009d\7\32\2\2\u009d\u009e\b\13\1\2\u009e\25\3\2"+
		"\2\2\u009f\u00a5\5\30\r\2\u00a0\u00a1\7\22\2\2\u00a1\u00a2\b\f\1\2\u00a2"+
		"\u00a4\5\30\r\2\u00a3\u00a0\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3"+
		"\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\27\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8"+
		"\u00ae\5\32\16\2\u00a9\u00aa\7\22\2\2\u00aa\u00ab\b\r\1\2\u00ab\u00ad"+
		"\5\32\16\2\u00ac\u00a9\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2"+
		"\u00ae\u00af\3\2\2\2\u00af\31\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b2"+
		"\7\20\2\2\u00b2\u00bc\b\16\1\2\u00b3\u00b4\7\16\2\2\u00b4\u00bc\b\16\1"+
		"\2\u00b5\u00b6\7\17\2\2\u00b6\u00bc\b\16\1\2\u00b7\u00b8\7\23\2\2\u00b8"+
		"\u00b9\5\26\f\2\u00b9\u00ba\7\24\2\2\u00ba\u00bc\3\2\2\2\u00bb\u00b1\3"+
		"\2\2\2\u00bb\u00b3\3\2\2\2\u00bb\u00b5\3\2\2\2\u00bb\u00b7\3\2\2\2\u00bc"+
		"\33\3\2\2\2\20\37!/<EL\\y\u0083\u0088\u009a\u00a5\u00ae\u00bb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}