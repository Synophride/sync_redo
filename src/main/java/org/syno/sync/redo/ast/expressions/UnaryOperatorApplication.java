package org.syno.sync.redo.ast.expressions;

import org.syno.sync.redo.ast.types.Type;
import org.syno.sync.redo.typing.Environment;
import org.syno.sync.redo.typing.NodeNotFoundException;
import org.syno.sync.redo.typing.TypingException;
import org.syno.sync.redo.typing.VariableNotFoundException;

public class UnaryOperatorApplication extends Expression {
	private final UnaryOperator op;
	private final Expression subExpr;

	public UnaryOperatorApplication(final UnaryOperator operator, final Expression subExpression) {
		op = operator;
		subExpr = subExpression;
	}

	@Override
	public Type getType(final Environment e) throws TypingException {
		Type subExpressionType = subExpr.getType(e);
		if (op.isLegitInputType(subExpressionType)) {
			return subExpressionType;
		} else {
			throw new TypingException();
		}
	}

	@Override
	public String toString() {
		return op + "(" + subExpr + ")";
	}

	@Override
	public void preprocessing(Environment e) throws VariableNotFoundException, NodeNotFoundException {
		subExpr.preprocessing(e);
	}
}
