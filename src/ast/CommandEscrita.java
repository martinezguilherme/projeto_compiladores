package ast;

public class CommandEscrita extends AbstractCommand {

	private String id;
	private String texto;
	
	public CommandEscrita(String id, String texto) {
		this.id = id;
		this.texto = texto;
	}
	
	@Override
	public String generateJavaCode() {
		String str = (id == null)? texto : id; 
		return "      System.out.println("+str+");";
	}
	
	@Override
	public String toString() {
		return "CommandEscrita [id=" + id + " texto="+texto+"]";
	}
	
}
