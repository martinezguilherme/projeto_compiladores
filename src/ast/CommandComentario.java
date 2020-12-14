package ast;

import java.util.ArrayList;

public class CommandComentario extends AbstractCommand{
	
	private String comentario;
	
	public CommandComentario(String comentario) {
		this.comentario = comentario;
	}
	
	@Override
	public String generateJavaCode() {
		StringBuilder str = new StringBuilder();
		str.append("//");
		str.append(comentario.substring(1, comentario.length() -1));
		return str.toString();
	}

	@Override
	public String toString() {
		return "CommandComentario [comentario=" + comentario + "]";
	}	
}
