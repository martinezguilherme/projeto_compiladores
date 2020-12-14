package ast;

public class CommandTernario extends AbstractCommand {
	
	private String condition;
	private String expr1;
	private String expr2;
	private String id;
	
	public CommandTernario (String id, String condition, String expr1, String expr2){
		this.id = id;
		this.condition = condition;
		this.expr1 = expr1;
		this.expr2 = expr2;
	}
	
	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
//		System.out.println("Condition: " + condition);
//		System.out.println("Expression1: " + expr1);
//		System.out.println("Expression2: " + expr2);
		return "      " + id + " = " + condition + "?" + expr1 + ":" + expr2 + ";";
	}
	
	@Override
	public String toString() {
		return "CommandTernario [condition=" + condition + ", expr1=" + expr1 + ", expr2=" + expr2 +"]";
	}
	
}
