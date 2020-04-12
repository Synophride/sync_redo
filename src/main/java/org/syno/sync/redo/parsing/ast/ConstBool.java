package org.syno.sync.redo.parsing.ast;

public class ConstBool extends Expression {
	private boolean value;
	
	public ConstBool(String s) {
		value = Boolean.getBoolean(s);
	}
	public boolean getValue() {
		return value;
	}
	
	public boolean equals(ConstBool other) {
		return this.value == other.value;
	}
	public String toString() {return String.valueOf(value);}
	
}
