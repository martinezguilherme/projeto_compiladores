package ast;

import datastructures.IsiVariable;

public class CommandAtribuicao extends AbstractCommand{
	private String id;
	private String expr;
	
	public CommandAtribuicao(String id, String expr) {
		this.id = id;
		this.expr = expr;
		//System.out.println("Esta eh a express: " + expr);
	}
	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		if(expr.equals("True") || expr.equals("True")){
			return id + " = "+expr.toLowerCase()+";";
		}
		return id + " = "+expr+";";
	}
	@Override
	public String toString() {
		return "CommandAtribuicao [id=" + id + ", expr=" + expr + "]";
	}
}
