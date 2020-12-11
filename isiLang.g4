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

prog		: 'programa' declara bloco  'fimprog.'
	           	{  	program.setVarTable(symbolTable);
	           	  	program.setComandos(stack.pop()); 
	           	} 
			;
		
declara     :  'declare' ID (VIR ID)* PR
        	;
        
bloco		: { curThread = new ArrayList<AbstractCommand>(); 
	        	stack.push(curThread);  
          	  }
          	  (cmd.)+
			;
		

cmd			:  cmdLeitura  
 			|  cmdEscrita 
 			|  cmdExpr
 			|  cmdIf
 			|  cmdEnquanto  
			;
		
cmdLeitura	: 'leia' AP
                     ID { verificaID(_input.LT(-1).getText());
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
			
cmdEscrita	: 'escreva' 
                 AP 
                 ( 
                 	ID { 
                 			verificaID(_input.LT(-1).getText());
	                    	_writeID = _input.LT(-1).getText();
                       }
                 | 	TEXTO
                 
                 ) 
                 FP 
                 PR
               {
               	  CommandEscrita cmd = new CommandEscrita(_writeID);
               	  stack.peek().add(cmd);
               }
			;
			
cmdIf	  	:  'se' 	AP
                    	expr  { _exprDecision = _input.LT(-1).getText(); }
                    	OPREL { _exprDecision += _input.LT(-1).getText(); }
                    	expr  { _exprDecision += _input.LT(-1).getText(); }
                    	FP
               'entao' 	ACH 
                    	{ 
                    		curThread = new ArrayList<AbstractCommand>(); 
                      	  	stack.push(curThread);
                    	}
                    	(cmd)+ 
                    	FCH 
                    	{
                       		listaTrue = stack.pop();	
                    	} 
              ('senao' 	ACH
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

cmdExpr		:  ID { 
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
			
cmdEnquanto : 'enquanto' AP expr OPREL expr FP ACH (cmd)+ FCH
			;
			
expr		: termo ( ( SOM | SUB) termo )*
			;
			
termo		: fator ( ( MUL | DIV ) fator)*
			;

fator 		: NUMBER 
            | ID 
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