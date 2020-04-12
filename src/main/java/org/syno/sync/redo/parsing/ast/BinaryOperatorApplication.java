package org.syno.sync.redo.parsing.ast;

import java.util.Objects;

public class BinaryOperatorApplication extends Expression {
	private final BinaryOperator op;
	private final Expression subExprLeft;
	private final Expression subExprRight;

	public BinaryOperatorApplication(
			BinaryOperator operator,
			Expression exp1,
			Expression exp2) {
		
		op = operator;
		subExprLeft = exp1;
		subExprRight= exp2;
	}

	public BinaryOperator getOp() {
		return op;
	}

	public Expression getSubExprLeft() {
		return subExprLeft;
	}

	public Expression getSubExprRight() {
		return subExprRight;
	}
	
	public String toString() {
		return subExprLeft + " " 
				+ op
				+ " " + subExprRight; 
	}
	
	public boolean equals(BinaryOperatorApplication other) {
		return Objects.equals(subExprLeft, other.subExprLeft)
			&& Objects.equals(subExprRight, other.subExprRight)
			&& Objects.equals(op, other.op);
	}
}
