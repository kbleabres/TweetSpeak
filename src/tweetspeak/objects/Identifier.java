package tweetspeak.objects;

import tweetspeak.collections.TokenName;
import tweetspeak.collections.TokenType;

public class Identifier extends Token {
	private String dataType, value;
	private int intVal = -1;
	private float floatVal = -1;
	private char charVal = ' ';
	private String stringVal = "";
	private boolean boolVal = false;
	private boolean voidFlag = false;
	
	//constructors	
	public Identifier(String lexeme, String dataType) {
		super(lexeme, TokenName.VAR.toString(), TokenType.IDENTIFIER.toString());
		setDataType(dataType);
		setValue("");
	}
	
	public Identifier(String lexeme, String dataType, String value) {
		this(lexeme, dataType);
		setValue(value);
		
		if (dataType.equals(TokenName.DATATYPE_BOOL.toString())) setBoolVal(Boolean.parseBoolean(value));
		else if (dataType.equals(TokenName.DATATYPE_CHAR.toString())) setCharVal(value.charAt(0));
		else if (dataType.equals(TokenName.DATATYPE_FLOAT.toString())) setFloatVal(Float.parseFloat(value));
		else if (dataType.equals(TokenName.DATATYPE_INT.toString())) setIntVal(Integer.parseInt(value));
		else if (dataType.equals(TokenName.DATATYPE_STRING.toString())) setStringVal(value);
		else if (dataType.equals(TokenName.DATATYPE_VOID.toString())) setVoidFlag(true);
	}
	
	public Identifier(String lexeme, String dataType, String value, int lineNumber, int nextIndex) {
		this(lexeme, dataType, value);
		setLineNumber(lineNumber);
		setNextIndex(nextIndex);
	}
	
	//setters
	public void setDataType(String datatype) { this.dataType = datatype; }
	public void setValue(String value) { this.value = value; }
	public void setIntVal(int intVal) { this.intVal = intVal; }
	public void setCharVal(char charVal) { this.charVal = charVal; }
	public void setFloatVal(float floatVal) { this.floatVal = floatVal; }
	public void setStringVal(String stringVal) { this.stringVal = stringVal; }
	public void setBoolVal(boolean boolVal) { this.boolVal = boolVal; }
	public void setVoidFlag(boolean voidFlag) { this.voidFlag = voidFlag; }

	//getters
	public String getDataType() { return dataType; }
	public String getValue() { return value; }
	public int getIntVal() { return intVal; }
	public float getFloatVal() { return floatVal; }
	public char getCharVal() { return charVal; }
	public String getStringVal() { return stringVal; }
	public boolean isBoolean() { return boolVal; }
	public boolean isVoid() { return voidFlag; }

}
