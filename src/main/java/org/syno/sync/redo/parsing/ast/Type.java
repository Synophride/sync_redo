package org.syno.sync.redo.parsing.ast;

public enum Type {
	INT("int"), BOOL("bool"), REAL("float");
	String msg;
	private Type(String s) {
		msg = s;
	}
	
	public String toString() {
		return msg;
	}
}
