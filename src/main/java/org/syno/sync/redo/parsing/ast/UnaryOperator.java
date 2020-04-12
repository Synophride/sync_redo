package org.syno.sync.redo.parsing.ast;

public enum UnaryOperator {
	NOT("!"), MINUS("-"), PRE("pre");

	private String repr;

	private UnaryOperator(String s) {
		repr = s;
	}

	public String toString() {
		return repr;
	}
}
