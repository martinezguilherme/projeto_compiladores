package ast;

import java.util.ArrayList;

public class CommandEnquanto extends AbstractCommand {
	private String condition;
	private ArrayList<AbstractCommand> listaTrue;
	private ArrayList<AbstractCommand> listaFalse;
	
	public CommandEnquanto(String condition, ArrayList<AbstractCommand> lt) {
		this.condition = condition;
		this.listaTrue = lt;
	}
	
	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		str.append("while ("+condition+") {\n");
		for (AbstractCommand cmd: listaTrue) {
			str.append(cmd.generateJavaCode());
		}
		str.append("\n}");
		return str.toString();
	}
	@Override
	public String toString() {
		return "CommandEnquanto [condition=" + condition + ", listaTrue=" + listaTrue 
				+ "]";
	}
}
