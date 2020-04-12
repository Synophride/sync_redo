package org.syno.sync.redo.parsing.ast;

public class ConstFloat extends Expression {
	private double value;
	
	public ConstFloat(String s) {
		value = Double.parseDouble(s);
	}
	public double getValue() {
		return value;
	}
	public boolean equals(ConstFloat other) {
		return this.value == other.value;
	}
	
	public String toString() {
		return String.valueOf(value);
	}
	
}
