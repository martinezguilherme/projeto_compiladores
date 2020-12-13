package main;
//java -cp antlr-4.7.1-complete.jar org.antlr.v4.Tool IsiLang.g4 -package parser -o ./src/parser/


import parser.IsiLangLexer;
import parser.IsiLangParser;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import exceptions.SemanticException;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			IsiLangLexer lexer;
			IsiLangParser parser;
			
			// leio o arquivo "input.isi" e isso � entrada para o Analisador Lexico
			lexer = new IsiLangLexer(CharStreams.fromFileName("input.isi"));
			
			// crio um "fluxo de tokens" para passar para o PARSER
			CommonTokenStream tokenStream = new CommonTokenStream(lexer);
			
			// crio meu parser a partir desse tokenStream
			parser = new IsiLangParser(tokenStream);
			
			parser.prog();
			
			parser.exibeComandos();
			
			parser.generateCode();
			
			System.out.println("Compilation Successful");
		}
		catch(SemanticException ex) {
			System.err.println("Semantic error - "+ex.getMessage());
		}
		catch(Exception ex) {
			ex.printStackTrace();
			System.err.println("ERROR "+ex.getMessage());
		}
	}

}
