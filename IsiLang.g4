grammar IsiLang;

@header{
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
	import ast.CommandTernario;
	import java.util.ArrayList;
	import java.util.Stack;
}

@members{
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
	private String _exprOpcaoTrue;
	private String _exprOpcaoFalse;
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
}

prog		: 'programa' (declara|declarab|texto)+ bloco 'fimprog.'
	           {  
	           	  program.setVarTable(symbolTable);
	           	  program.setComandos(stack.pop());   	 
	           } 
			;
		
declara    :  'declare'  ID  {
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
                   (  VIR 
              	 	  ID {
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
              		)* 
              		PR
           ;

declarab   : 'declarab'  ID  {
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
					(  VIR 
						ID {
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
						)* 
						PR
           ;

texto    :  'texto'  ID  {
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
                   (  VIR 
              	 	  ID {
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
              		)* 
              		PR
           ;

bloco	: { 
		       curThread = new ArrayList<AbstractCommand>(); 
	           stack.push(curThread);  
          }
          (cmd)+
		;
		

cmd		:  cmdleitura  
 		|  cmdescrita 
 		|  cmdexpr
 		|  cmdselecao
 		|  cmdenquanto
 		|  cmdcomentario
		|  cmdternario
		;
		
cmdleitura	: 'leia' AP
                     ID { 
                     		verificaID(exibeInput());
                     	  	_readID = exibeInput();
                        } 
                     FP 
                     PR 
                     {
		              	 IsiVariable var = (IsiVariable)symbolTable.get(_readID);
		              	 CommandLeitura cmd = new CommandLeitura(_readID, var);
		              	 stack.peek().add(cmd);
		             }   
			;
			
cmdescrita	: 'escreva' AP 
                 		(	 TEXTO 	{
                 						_writeID = null;
                 						_writeTEXTO = exibeInput();
                 				   	}
	             		|	 ID 	{ 
	             						verificaID(exibeInput());
	                     	  			_writeID = exibeInput();
										variavelUti(_writeID);
	                    			} 
                 		) 
                 		FP 
                 		PR
               			{
               	  			CommandEscrita cmd = new CommandEscrita(_writeID, _writeTEXTO);
               	  			stack.peek().add(cmd);
               			}
			;
			
cmdexpr		:  ID { 
						verificaID(exibeInput());
                    	_exprID = exibeInput();
                  } 
               ATR { _exprContent = ""; } 
               expr
               PR
               {	
				   	CommandAtribuicao cmd;
					cmd = new CommandAtribuicao(_exprID, _exprContent);             	 	
					// variavelUti(_exprID);
               	 	stack.peek().add(cmd);
               }
			;	
			
cmdselecao  :  'se' 	AP
                    	expr    { _exprDecision = exibeInput(); }
                    	OPREL 	{ _exprDecision += exibeInput(); }
                    	expr 	{ _exprDecision += exibeInput(); }
									
                    	FP
               'entao'  ACH 
                    	{ 
                    		curThread = new ArrayList<AbstractCommand>(); 
                      		stack.push(curThread);
                    	}
                    	(cmd)+ 
                    	FCH 
                    	{
                       		listaTrue = stack.pop();	
                    	} 
               ('senao' ACH
                   	 	{
                   	 		curThread = new ArrayList<AbstractCommand>();
                   	 		stack.push(curThread);
                   	 	} 
                   		(cmd+) 
                   		FCH
                   		{
                   			listaFalse = stack.pop();
                   		}
               )?
               {
               		CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
                   	stack.peek().add(cmd);
               }
            ;

cmdternario : ID { 
						verificaID(exibeInput());
                    	_exprID = exibeInput();
                  } 
              ATR { _exprContent = ""; }				
			  expr  { _exprDecision = exibeInput(); }
			  OPREL { _exprDecision += exibeInput(); }
			  expr 	{ _exprDecision += exibeInput(); }
			  '?'
			  expr  { _exprOpcaoTrue = exibeInput(); System.out.println("Teste dentro 1" + _exprOpcaoTrue);}
			  ':'
			  expr  { _exprOpcaoFalse = exibeInput(); System.out.println("Teste dentro 2" + _exprOpcaoFalse);}
			  {
				  	CommandTernario cmd;
					cmd = new CommandTernario (_exprID,_exprDecision, _exprOpcaoTrue, _exprOpcaoFalse);   
					stack.peek().add(cmd);
			  }
			  PR
			;

cmdenquanto : 'enquanto' AP 
						expr 	{ _exprEnquanto = exibeInput(); }
						OPREL 	{ _exprEnquanto += exibeInput(); }
						expr 	{ _exprEnquanto += exibeInput(); }
						FP 
						ACH 
                    	{ 
                    		curThread = new ArrayList<AbstractCommand>(); 
                      		stack.push(curThread);
                    	}
                    	(cmd)+ 
                    	FCH 
                    	{
                       		listaTrue = stack.pop();	
							CommandEnquanto cmd = new CommandEnquanto(_exprEnquanto, listaTrue);
                   			stack.peek().add(cmd);
                    	} 
			;
			
cmdcomentario :  COMMENT {
				 			curThread = new ArrayList<AbstractCommand>();
                   	   		stack.push(curThread);
							listaComments = stack.pop();
               	  			CommandComentario cmd = new CommandComentario(exibeInput());
               	  			stack.peek().add(cmd); 
						 }
		      ;
			
expr		: termo
			  ( 
	          		OP  { _exprContent += exibeInput();}
	            	termo
	          )*
			;
			
termo		: fator
			  (
			  		OP { _exprContent += exibeInput();}
			  		fator
			  )*
			;
			
fator 		: NUMBER {
              			_exprContent += exibeInput();
              			IsiVariable var = (IsiVariable)symbolTable.get(_readID);
              			var.setType(exibeInput());
              		 }
             | ID 	 { 
            			verificaID(exibeInput());
						variavelUti(exibeInput());
	                	_exprContent += exibeInput();
                     } 
             | TEXTO {
              			_exprContent += exibeInput();
              		 }
			 | BOOL {
				 		_exprContent += exibeInput();
						IsiVariable var = (IsiVariable)symbolTable.get(_readID);
						var.setType(exibeInput());
			 }
             | AP expr FP
             ;
			
OPREL 	: '>' | '<' | '>=' | '<=' | '==' | '!='
      	;
      
ID		: ([a-z]) ([a-z] | [A-Z] | [0-9])*
		;

TEXTO   : DQ ([a-z] | [A-Z] | [0-9] | WS )+ DQ
		;

BOOL	: 'True' | 'False'
		;

COMMENT : CM ([a-z] | [A-Z] | [0-9] | WS )+ CM
		;
	
NUMBER	: [0-9]+ ('.' [0-9]+)?
		;
		
WS		: (' ' | '\t' | '\n' | '\r') -> skip
		;
		
OP	: '+' | '-' | '*' | '/'
	;

AP	: '('
	;
	
FP	: ')'
	;
	
PR	: '.'
	;
	
DQ	: '"'
	;	
	
ATR : ':='
	;
	 
VIR : ','
    ;
     
ACH : '{'
    ;
     
FCH : '}'
    ;
     
SOM : '+'
    ;

MUL : '*'
    ;

DIV : '/'
    ;

SUB : '-'
	;

CM  : '#'
	;