package org.syno.sync.redo.parsing.ast;

public class Parameter {
	private Type type;
	private String name;
	public Parameter(String name, Type type) {
		this.name = name;
		this.type = type;
	}
	
	public Type getType() {return type;}
	public String getName() {return name;}
	
	public String toString() {
		return name + ":" + type;
	}
}
