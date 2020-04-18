package org.syno.sync.redo.ast.expressions;

import java.util.Objects;

import org.syno.sync.redo.ast.types.Type;
import org.syno.sync.redo.typing.Environment;
import org.syno.sync.redo.typing.NodeNotFoundException;
import org.syno.sync.redo.typing.TypingException;
import org.syno.sync.redo.typing.VariableNotFoundException;

public class BinaryOperatorApplication extends Expression {
	private final BinaryOperator op;
	private final Expression subExprLeft;
	private final Expression subExprRight;

	public BinaryOperatorApplication(final BinaryOperator operator, final Expression exp1, final Expression exp2) {

		op = operator;
		subExprLeft = exp1;
		subExprRight = exp2;
	}

	public boolean equals(final BinaryOperatorApplication other) {
		return Objects.equals(subExprLeft, other.subExprLeft) && Objects.equals(subExprRight, other.subExprRight)
				&& Objects.equals(op, other.op);
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

	@Override
	public Type getType(final Environment e) throws TypingException {
		Type typeSubExpLeft = subExprLeft.getType(e);
		Type typeSubExpRight = subExprRight.getType(e);

		if (!op.isCorrectCall(typeSubExpLeft, typeSubExpRight)) {
			throw new TypingException();
		} else {
			return op.getReturnType(typeSubExpLeft, typeSubExpRight);
		}
	}

	@Override
	public String toString() {
		return "(" + subExprLeft + op + " " + subExprRight + ")";
	}

	@Override
	public void preprocessing(Environment e) throws VariableNotFoundException, NodeNotFoundException {
		subExprLeft.preprocessing(e);
		subExprRight.preprocessing(e);
	}
}
