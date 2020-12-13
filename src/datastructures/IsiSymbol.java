package datastructures;

public abstract class IsiSymbol {
	
	protected String name;

	public int qtdUsos;
	
	public abstract String generateJavaCode();
	
	public IsiSymbol(String name) {
		this.name = name;
		this.qtdUsos = 0;
	}

	public void variavelUtilizada(){
		this.qtdUsos++;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "IsiSymbol [name=" + name + "]";
	}

}
