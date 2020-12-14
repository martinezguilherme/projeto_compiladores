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

	public void variavelUti(String id){ 
		symbolTable.varUtilizada(id);
	 }
	
	public void generateCode(){
		program.generateTarget();
	}
}

prog		: 'programa' (declara|texto)+ bloco 'fimprog.'
	           {  
	           	  program.setVarTable(symbolTable);
	           	  program.setComandos(stack.pop());   	 
	           } 
			;
		
declara    :  'declare'  ID  {
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
                   (  VIR 
              	 	  ID {
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
              		)* 
              		PR
           ;
        
texto    :  'texto'  ID  {
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
                   (  VIR 
              	 	  ID {
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
		;
		
cmdleitura	: 'leia' AP
                     ID { 
                     		verificaID(_input.LT(-1).getText());
                     	  	_readID = _input.LT(-1).getText();
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
                 						_writeTEXTO = _input.LT(-1).getText();
                 				   	}
	             		|	 ID 	{ 
	             						verificaID(_input.LT(-1).getText());
	                     	  			_writeID = _input.LT(-1).getText();
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
						verificaID(_input.LT(-1).getText());
                    	_exprID = _input.LT(-1).getText();
                  } 
               ATR { _exprContent = ""; } 
               expr 
               PR
               {
               	 	CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
					// variavelUti(_exprID);
               	 	stack.peek().add(cmd);
               }
			;	
			
cmdselecao  :  'se' 	AP
                    	expr    { _exprDecision = _input.LT(-1).getText(); }
                    	OPREL 	{ _exprDecision += _input.LT(-1).getText(); }
                    	expr 	{ _exprDecision += _input.LT(-1).getText(); }
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
        
cmdenquanto : 'enquanto' AP 
						expr 	{ _exprEnquanto = _input.LT(-1).getText(); }
						OPREL 	{ _exprEnquanto += _input.LT(-1).getText(); }
						expr 	{ _exprEnquanto += _input.LT(-1).getText(); }
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
               	  			CommandComentario cmd = new CommandComentario(_input.LT(-1).getText());
               	  			stack.peek().add(cmd); 
						}
		   ;
			
expr		: termo 
			  ( 
	          		OP  { _exprContent += _input.LT(-1).getText();}
	            	termo
	          )*
			;
			
termo		: fator 
			  (
			  		OP { _exprContent += _input.LT(-1).getText();}
			  		fator
			  )*
			;
			
fator 		: NUMBER {
              			_exprContent += _input.LT(-1).getText();
              			IsiVariable var = (IsiVariable)symbolTable.get(_readID);
              			var.setType(_input.LT(-1).getText());
              		 }
             | ID 	 { 
            			verificaID(_input.LT(-1).getText());
						variavelUti(_input.LT(-1).getText());
	                	_exprContent += _input.LT(-1).getText();
                     } 
             | TEXTO {
              			_exprContent += _input.LT(-1).getText();
              		 }
             | AP expr FP
             ;
			
OPREL 	: '>' | '<' | '>=' | '<=' | '==' | '!='
      	;
      
ID		: ([a-z]|[A-Z]) ([a-z] | [A-Z] | [0-9])*
		;
	
TEXTO   : DQ ([a-z] | [A-Z] | [0-9] | WS )+ DQ
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
	
DP  : ':'
	;