package ast;

public class CommandTernario extends AbstractCommand {
	
	private String condition;
	private String expr1;
	private String expr2;
	
	public CommandTernario (String condition, String expr1, String expr2){
		this.condition = condition;
		this.expr1 = expr1;
		this.expr2 = expr2;
	}
	
	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		return "      " + condition + "?" + expr1 + ":" + expr2 + ";";
	}
	
	@Override
	public String toString() {
		return "CommandTernario [condition=" + condition + ", expr1=" + expr1 + ", expr2=" + expr2 +"]";
	}
	
}
