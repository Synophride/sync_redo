package org.syno.sync.redo.parsing.ast;

public enum BinaryOperator {
	PLUS("+"), MINUS("-"), MULT("*"), DIV("/"), MOD("%"),
	AND("&&"), OR("||"),
	EQ("=="), NEQ("!="),
	GREATER_THAN(">"), GREATER_OR_EQUAL(">="), 
	LESSER_THAN("<"), LESSER_OR_EQUAL("<="),
	FOLLOWED_BY("->");// Impl = pour la construction WHEN, aucun sens de le mettre là

	private String s;
	private BinaryOperator(String str) {
		s = str;
	}
	
	public String toString() {
		return s;
	}
	
}

