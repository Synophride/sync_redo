package org.syno.sync.redo.parsing.ast;

public class Identifier extends Expression {
	private String identifier;
	
	public Identifier(String s) {
		identifier = s;
	}
}
