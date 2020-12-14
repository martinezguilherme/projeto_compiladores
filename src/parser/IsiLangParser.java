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
		T__9=10, T__10=11, OPREL=12, ID=13, TEXTO=14, BOOL=15, COMMENT=16, NUMBER=17, 
		WS=18, OP=19, AP=20, FP=21, PR=22, DQ=23, ATR=24, VIR=25, ACH=26, FCH=27, 
		SOM=28, MUL=29, DIV=30, SUB=31, CM=32;
	public static final int
		RULE_prog = 0, RULE_declara = 1, RULE_declarab = 2, RULE_texto = 3, RULE_bloco = 4, 
		RULE_cmd = 5, RULE_cmdleitura = 6, RULE_cmdescrita = 7, RULE_cmdexpr = 8, 
		RULE_cmdselecao = 9, RULE_cmdenquanto = 10, RULE_cmdcomentario = 11, RULE_expr = 12, 
		RULE_termo = 13, RULE_fator = 14;
	public static final String[] ruleNames = {
		"prog", "declara", "declarab", "texto", "bloco", "cmd", "cmdleitura", 
		"cmdescrita", "cmdexpr", "cmdselecao", "cmdenquanto", "cmdcomentario", 
		"expr", "termo", "fator"
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
		public List<DeclarabContext> declarab() {
			return getRuleContexts(DeclarabContext.class);
		}
		public DeclarabContext declarab(int i) {
			return getRuleContext(DeclarabContext.class,i);
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
			setState(30);
			match(T__0);
			setState(34); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(34);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__2:
					{
					setState(31);
					declara();
					}
					break;
				case T__3:
					{
					setState(32);
					declarab();
					}
					break;
				case T__4:
					{
					setState(33);
					texto();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4))) != 0) );
			setState(38);
			bloco();
			setState(39);
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
			setState(42);
			match(T__2);
			setState(43);
			match(ID);

				                  		_varName = exibeInput();
				                  		_varValue = null;
				                  		_varType = 2;
				                  		symbol = new IsiVariable(_varName, _varValue, _varType);
				                  		if (!symbolTable.exists(_varName)){
				                     		symbolTable.add(symbol);	
				                  		}
				                  		else{
				                  	 		throw new SemanticException("Symbol "+_varName+" already declared");
				                  	  	}
			                    	  
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(45);
				match(VIR);
				setState(46);
				match(ID);

					                  		_varName = exibeInput();
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
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(53);
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

	public static class DeclarabContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode PR() { return getToken(IsiLangParser.PR, 0); }
		public List<TerminalNode> VIR() { return getTokens(IsiLangParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(IsiLangParser.VIR, i);
		}
		public DeclarabContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarab; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterDeclarab(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitDeclarab(this);
		}
	}

	public final DeclarabContext declarab() throws RecognitionException {
		DeclarabContext _localctx = new DeclarabContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declarab);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(T__3);
			setState(56);
			match(ID);

											_varName = exibeInput();
											_varValue = null;
											_varType = 4;
											symbol = new IsiVariable(_varName, _varValue, _varType);
											if (!symbolTable.exists(_varName)){
												symbolTable.add(symbol);
											}
											else{
												throw new SemanticException("Symbol "+_varName+" already declared");
											}
			                    	    
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(58);
				match(VIR);
				setState(59);
				match(ID);

												_varName = exibeInput();
												_varValue = null;
												_varType = 4;
												symbol = new IsiVariable(_varName, _varValue, _varType);
												if (!symbolTable.exists(_varName)){
													symbolTable.add(symbol);	
												}
												else{
													throw new SemanticException("Symbol "+_varName+" already declared");
												}
											
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66);
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
		enterRule(_localctx, 6, RULE_texto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(T__4);
			setState(69);
			match(ID);

				                  		_varName = exibeInput();
				                  		_varValue = null;
				                  		_varType = 1;
				                  		symbol = new IsiVariable(_varName, _varValue, _varType);
				                  		if (!symbolTable.exists(_varName)){
				                     		symbolTable.add(symbol);	
				                  		}
				                  		else{
				                  	 		throw new SemanticException("Symbol "+_varName+" already declared");
				                  	  	}
			                    	  
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(71);
				match(VIR);
				setState(72);
				match(ID);

					                  		_varName = exibeInput();
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
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(79);
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
		enterRule(_localctx, 8, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 
					       curThread = new ArrayList<AbstractCommand>(); 
				           stack.push(curThread);  
			          
			setState(83); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(82);
				cmd();
				}
				}
				setState(85); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__10) | (1L << ID) | (1L << COMMENT))) != 0) );
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
		enterRule(_localctx, 10, RULE_cmd);
		try {
			setState(93);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				cmdleitura();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				cmdescrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(89);
				cmdexpr();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(90);
				cmdselecao();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 5);
				{
				setState(91);
				cmdenquanto();
				}
				break;
			case COMMENT:
				enterOuterAlt(_localctx, 6);
				{
				setState(92);
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
		enterRule(_localctx, 12, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(T__5);
			setState(96);
			match(AP);
			setState(97);
			match(ID);
			 
			                     		verificaID(exibeInput());
			                     	  	_readID = exibeInput();
			                        
			setState(99);
			match(FP);
			setState(100);
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
		enterRule(_localctx, 14, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(T__6);
			setState(104);
			match(AP);
			setState(109);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEXTO:
				{
				setState(105);
				match(TEXTO);

				                 						_writeID = null;
				                 						_writeTEXTO = exibeInput();
				                 				   	
				}
				break;
			case ID:
				{
				setState(107);
				match(ID);
				 
					             						verificaID(exibeInput());
					                     	  			_writeID = exibeInput();
														variavelUti(_writeID);
					                    			
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(111);
			match(FP);
			setState(112);
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
		enterRule(_localctx, 16, RULE_cmdexpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(ID);
			 
									verificaID(exibeInput());
			                    	_exprID = exibeInput();
			                  
			setState(117);
			match(ATR);
			 _exprContent = ""; 
			setState(119);
			expr();
			setState(120);
			match(PR);
				
							   	CommandAtribuicao cmd;
								cmd = new CommandAtribuicao(_exprID, _exprContent);             	 	
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
		enterRule(_localctx, 18, RULE_cmdselecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(T__7);
			setState(124);
			match(AP);
			setState(125);
			expr();
			 _exprDecision = exibeInput(); 
			setState(127);
			match(OPREL);
			 _exprDecision += exibeInput(); 
			setState(129);
			expr();
			 _exprDecision += exibeInput(); 
			setState(131);
			match(FP);
			setState(132);
			match(T__8);
			setState(133);
			match(ACH);
			 
			                    		curThread = new ArrayList<AbstractCommand>(); 
			                      		stack.push(curThread);
			                    	
			setState(136); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(135);
				cmd();
				}
				}
				setState(138); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__10) | (1L << ID) | (1L << COMMENT))) != 0) );
			setState(140);
			match(FCH);

			                       		listaTrue = stack.pop();	
			                    	
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(142);
				match(T__9);
				setState(143);
				match(ACH);

				                   	 		curThread = new ArrayList<AbstractCommand>();
				                   	 		stack.push(curThread);
				                   	 	
				{
				setState(146); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(145);
					cmd();
					}
					}
					setState(148); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__10) | (1L << ID) | (1L << COMMENT))) != 0) );
				}
				setState(150);
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
		enterRule(_localctx, 20, RULE_cmdenquanto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(T__10);
			setState(158);
			match(AP);
			setState(159);
			expr();
			 _exprEnquanto = exibeInput(); 
			setState(161);
			match(OPREL);
			 _exprEnquanto += exibeInput(); 
			setState(163);
			expr();
			 _exprEnquanto += exibeInput(); 
			setState(165);
			match(FP);
			setState(166);
			match(ACH);
			 
			                    		curThread = new ArrayList<AbstractCommand>(); 
			                      		stack.push(curThread);
			                    	
			setState(169); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(168);
				cmd();
				}
				}
				setState(171); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__10) | (1L << ID) | (1L << COMMENT))) != 0) );
			setState(173);
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
		enterRule(_localctx, 22, RULE_cmdcomentario);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(COMMENT);

							 			curThread = new ArrayList<AbstractCommand>();
			                   	   		stack.push(curThread);
										listaComments = stack.pop();
			               	  			CommandComentario cmd = new CommandComentario(exibeInput());
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
		enterRule(_localctx, 24, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			termo();
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(180);
				match(OP);
				 _exprContent += exibeInput();
				setState(182);
				termo();
				}
				}
				setState(187);
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
		enterRule(_localctx, 26, RULE_termo);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			fator();
			setState(194);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(189);
					match(OP);
					 _exprContent += exibeInput();
					setState(191);
					fator();
					}
					} 
				}
				setState(196);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		public TerminalNode BOOL() { return getToken(IsiLangParser.BOOL, 0); }
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
		enterRule(_localctx, 28, RULE_fator);
		try {
			setState(209);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				match(NUMBER);

				              			_exprContent += exibeInput();
				              			IsiVariable var = (IsiVariable)symbolTable.get(_readID);
				              			var.setType(exibeInput());
				              		 
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				match(ID);
				 
				            			verificaID(exibeInput());
										variavelUti(exibeInput());
					                	_exprContent += exibeInput();
				                     
				}
				break;
			case TEXTO:
				enterOuterAlt(_localctx, 3);
				{
				setState(201);
				match(TEXTO);

				              			_exprContent += exibeInput();
				              		 
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 4);
				{
				setState(203);
				match(BOOL);

								 		_exprContent += exibeInput();
										IsiVariable var = (IsiVariable)symbolTable.get(_readID);
										var.setType(exibeInput());
							 
				}
				break;
			case AP:
				enterOuterAlt(_localctx, 5);
				{
				setState(205);
				match(AP);
				setState(206);
				expr();
				setState(207);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u00d6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\6\2"+
		"%\n\2\r\2\16\2&\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3\63\n\3\f\3"+
		"\16\3\66\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4@\n\4\f\4\16\4C\13\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\7\5M\n\5\f\5\16\5P\13\5\3\5\3\5\3\6\3"+
		"\6\6\6V\n\6\r\6\16\6W\3\7\3\7\3\7\3\7\3\7\3\7\5\7`\n\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\5\tp\n\t\3\t\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\6\13\u008b\n\13\r\13\16\13\u008c\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\6\13\u0095\n\13\r\13\16\13\u0096\3\13\3\13\3\13\5\13\u009c"+
		"\n\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\6\f\u00ac"+
		"\n\f\r\f\16\f\u00ad\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\7\16\u00ba"+
		"\n\16\f\16\16\16\u00bd\13\16\3\17\3\17\3\17\3\17\7\17\u00c3\n\17\f\17"+
		"\16\17\u00c6\13\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\5\20\u00d4\n\20\3\20\2\2\21\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36\2\2\2\u00dd\2 \3\2\2\2\4,\3\2\2\2\69\3\2\2\2\bF\3\2\2\2\nS\3\2"+
		"\2\2\f_\3\2\2\2\16a\3\2\2\2\20i\3\2\2\2\22u\3\2\2\2\24}\3\2\2\2\26\u009f"+
		"\3\2\2\2\30\u00b2\3\2\2\2\32\u00b5\3\2\2\2\34\u00be\3\2\2\2\36\u00d3\3"+
		"\2\2\2 $\7\3\2\2!%\5\4\3\2\"%\5\6\4\2#%\5\b\5\2$!\3\2\2\2$\"\3\2\2\2$"+
		"#\3\2\2\2%&\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'(\3\2\2\2()\5\n\6\2)*\7\4\2"+
		"\2*+\b\2\1\2+\3\3\2\2\2,-\7\5\2\2-.\7\17\2\2.\64\b\3\1\2/\60\7\33\2\2"+
		"\60\61\7\17\2\2\61\63\b\3\1\2\62/\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2"+
		"\64\65\3\2\2\2\65\67\3\2\2\2\66\64\3\2\2\2\678\7\30\2\28\5\3\2\2\29:\7"+
		"\6\2\2:;\7\17\2\2;A\b\4\1\2<=\7\33\2\2=>\7\17\2\2>@\b\4\1\2?<\3\2\2\2"+
		"@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2CA\3\2\2\2DE\7\30\2\2E\7\3\2\2"+
		"\2FG\7\7\2\2GH\7\17\2\2HN\b\5\1\2IJ\7\33\2\2JK\7\17\2\2KM\b\5\1\2LI\3"+
		"\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2OQ\3\2\2\2PN\3\2\2\2QR\7\30\2\2R\t"+
		"\3\2\2\2SU\b\6\1\2TV\5\f\7\2UT\3\2\2\2VW\3\2\2\2WU\3\2\2\2WX\3\2\2\2X"+
		"\13\3\2\2\2Y`\5\16\b\2Z`\5\20\t\2[`\5\22\n\2\\`\5\24\13\2]`\5\26\f\2^"+
		"`\5\30\r\2_Y\3\2\2\2_Z\3\2\2\2_[\3\2\2\2_\\\3\2\2\2_]\3\2\2\2_^\3\2\2"+
		"\2`\r\3\2\2\2ab\7\b\2\2bc\7\26\2\2cd\7\17\2\2de\b\b\1\2ef\7\27\2\2fg\7"+
		"\30\2\2gh\b\b\1\2h\17\3\2\2\2ij\7\t\2\2jo\7\26\2\2kl\7\20\2\2lp\b\t\1"+
		"\2mn\7\17\2\2np\b\t\1\2ok\3\2\2\2om\3\2\2\2pq\3\2\2\2qr\7\27\2\2rs\7\30"+
		"\2\2st\b\t\1\2t\21\3\2\2\2uv\7\17\2\2vw\b\n\1\2wx\7\32\2\2xy\b\n\1\2y"+
		"z\5\32\16\2z{\7\30\2\2{|\b\n\1\2|\23\3\2\2\2}~\7\n\2\2~\177\7\26\2\2\177"+
		"\u0080\5\32\16\2\u0080\u0081\b\13\1\2\u0081\u0082\7\16\2\2\u0082\u0083"+
		"\b\13\1\2\u0083\u0084\5\32\16\2\u0084\u0085\b\13\1\2\u0085\u0086\7\27"+
		"\2\2\u0086\u0087\7\13\2\2\u0087\u0088\7\34\2\2\u0088\u008a\b\13\1\2\u0089"+
		"\u008b\5\f\7\2\u008a\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008a\3\2"+
		"\2\2\u008c\u008d\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\7\35\2\2\u008f"+
		"\u009b\b\13\1\2\u0090\u0091\7\f\2\2\u0091\u0092\7\34\2\2\u0092\u0094\b"+
		"\13\1\2\u0093\u0095\5\f\7\2\u0094\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096"+
		"\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\7\35"+
		"\2\2\u0099\u009a\b\13\1\2\u009a\u009c\3\2\2\2\u009b\u0090\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\b\13\1\2\u009e\25\3\2\2"+
		"\2\u009f\u00a0\7\r\2\2\u00a0\u00a1\7\26\2\2\u00a1\u00a2\5\32\16\2\u00a2"+
		"\u00a3\b\f\1\2\u00a3\u00a4\7\16\2\2\u00a4\u00a5\b\f\1\2\u00a5\u00a6\5"+
		"\32\16\2\u00a6\u00a7\b\f\1\2\u00a7\u00a8\7\27\2\2\u00a8\u00a9\7\34\2\2"+
		"\u00a9\u00ab\b\f\1\2\u00aa\u00ac\5\f\7\2\u00ab\u00aa\3\2\2\2\u00ac\u00ad"+
		"\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af"+
		"\u00b0\7\35\2\2\u00b0\u00b1\b\f\1\2\u00b1\27\3\2\2\2\u00b2\u00b3\7\22"+
		"\2\2\u00b3\u00b4\b\r\1\2\u00b4\31\3\2\2\2\u00b5\u00bb\5\34\17\2\u00b6"+
		"\u00b7\7\25\2\2\u00b7\u00b8\b\16\1\2\u00b8\u00ba\5\34\17\2\u00b9\u00b6"+
		"\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc"+
		"\33\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00c4\5\36\20\2\u00bf\u00c0\7\25"+
		"\2\2\u00c0\u00c1\b\17\1\2\u00c1\u00c3\5\36\20\2\u00c2\u00bf\3\2\2\2\u00c3"+
		"\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\35\3\2\2"+
		"\2\u00c6\u00c4\3\2\2\2\u00c7\u00c8\7\23\2\2\u00c8\u00d4\b\20\1\2\u00c9"+
		"\u00ca\7\17\2\2\u00ca\u00d4\b\20\1\2\u00cb\u00cc\7\20\2\2\u00cc\u00d4"+
		"\b\20\1\2\u00cd\u00ce\7\21\2\2\u00ce\u00d4\b\20\1\2\u00cf\u00d0\7\26\2"+
		"\2\u00d0\u00d1\5\32\16\2\u00d1\u00d2\7\27\2\2\u00d2\u00d4\3\2\2\2\u00d3"+
		"\u00c7\3\2\2\2\u00d3\u00c9\3\2\2\2\u00d3\u00cb\3\2\2\2\u00d3\u00cd\3\2"+
		"\2\2\u00d3\u00cf\3\2\2\2\u00d4\37\3\2\2\2\21$&\64ANW_o\u008c\u0096\u009b"+
		"\u00ad\u00bb\u00c4\u00d3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}