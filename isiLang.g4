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
	import java.util.ArrayList;
	import java.util.Stack;
}

@members{
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
}

prog	: 'programa' decl bloco  'fimprog;'
           {  
           	  program.setVarTable(symbolTable);
           	  program.setComandos(stack.pop());   	 
           } 
		;
		
decl    :  (declaravar)+
        ;
        
        
declaravar :  tipo ID  {
	                  		_varName = _input.LT(-1).getText();
	                  		_varValue = null;
	                  		symbol = new IsiVariable(_varName, _tipo, _varValue);
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
	                  		symbol = new IsiVariable(_varName, _tipo, _varValue);
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
           
tipo       : 'numero' { _tipo = IsiVariable.NUMBER;  }
           | 'texto'  { _tipo = IsiVariable.TEXT;  }
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
                 		(	 TEXTO 
	             		|	 ID { 
	             					verificaID(_input.LT(-1).getText());
	                     	  		_readID = _input.LT(-1).getText();
	                    		} 
                 		) 
                 		FP 
                 		PR
               			{
               	  			CommandEscrita cmd = new CommandEscrita(_writeID);
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
               	 	stack.peek().add(cmd);
               }
			;	
			
cmdselecao  :  'se' 	AP
                    	expr    { _exprDecision = _input.LT(-1).getText(); }
                    	OPREL { _exprDecision += _input.LT(-1).getText(); }
                    	expr { _exprDecision += _input.LT(-1).getText(); }
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
                   			CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
                   			stack.peek().add(cmd);
                   		}
               )?
            ;
        
cmdenquanto : 'enquanto' AP expr OPREL expr FP ACH (cmd)+ FCH
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
              		 }
            | ID { 
            		verificaID(_input.LT(-1).getText());
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