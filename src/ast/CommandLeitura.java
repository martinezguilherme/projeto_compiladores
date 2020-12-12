package ast;

import datastructures.IsiVariable;

public class CommandLeitura extends AbstractCommand {

	private String id;
	private IsiVariable var;
	
	public CommandLeitura (String id, IsiVariable var) {
		this.id = id;
		this.var = var;
	}
	
	@Override
	public String generateJavaCode() {
		String str;
		
		if(var.getType() == IsiVariable.INT) {
			str = "nextInt();";
		} else if (var.getType() == IsiVariable.TEXT) {
			str = "nextLine();";
		} else {
			str = "nextFloat();";
		}
		
		return id +"= _key." + str;
	}
	
	@Override
	public String toString() {
		return "CommandLeitura [id=" + id + "]";
	}
	
}
