package org.syno.sync.redo.parsing.ast;

public class Equation {
	private final Pattern pattern;
	private final Expression expression;
	
	public Equation(Pattern patt, Expression expr) {
		pattern = patt;
		expression = expr;
	}
	
	public Pattern getPattern() {
		return pattern;
	}
	
	public Expression getExpression() {
		return expression;
	}
}
