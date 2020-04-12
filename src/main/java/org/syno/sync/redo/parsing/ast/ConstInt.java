package org.syno.sync.redo.parsing.ast;

public class ConstInt extends Expression{
	private long value;
	
	public ConstInt(String s) {
		value=Long.parseLong(s);
	}
	
	public long getValue() {return value;}
	
	public boolean equals(ConstInt other) {
		return this.value == other.value;
	}
	
	public String toString() {
		return String.valueOf(value);
	}
	
}
