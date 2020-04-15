package org.syno.sync.redo.parsing.ast;

public class UnaryOperatorApplication extends Expression {
	private UnaryOperator op;
	private Expression subExpr;
	
	public UnaryOperatorApplication(UnaryOperator operator, Expression subExpression) {
		op = operator;
		subExpr=subExpression;
	}
	
	public String toString() {
		return op  + "(" + subExpr + ")";
	}
}
