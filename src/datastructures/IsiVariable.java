package datastructures;

public class IsiVariable extends IsiSymbol {
	
	public static final int INT = 2;
	public static final int DOUBLE  = 3;
	public static final int TEXT   = 1;
	
	private int type;
	private String value;
	
	public IsiVariable(String name, String value, int type) {
		super(name);
		this.type = type;
		this.value = value;
	}
	
	public int getType() {
		return type;
	}

	public void setType(String type) {
		try {
			Integer.parseInt(type);
			this.type = INT;
		} catch(NumberFormatException nfe) {				
			this.type = TEXT;
			try {
				Double.parseDouble(type);
				this.type = DOUBLE;
			} catch(NumberFormatException nfe1) {				
				this.type = TEXT;
				
			}
		}
		System.out.println(type+" "+this.type);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "IsiVariable [name=" + name + ", type=" + type + ", value=" + value + "]";
	}
	
	public String generateJavaCode() {
       String str;
       if (type == INT) {
    	   str = "int ";
       }
       else if(type == DOUBLE) {
    	   str = "double ";
       }
       else {
    	   str = "String ";
       }
       return str + " "+super.name+";";
	}
	
	

}
