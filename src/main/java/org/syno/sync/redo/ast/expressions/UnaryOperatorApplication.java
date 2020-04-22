package org.syno.sync.redo.ast.expressions;

import org.syno.sync.redo.ast.types.Type;
import org.syno.sync.redo.typing.Environment;
import org.syno.sync.redo.typing.NodeNotFoundException;
import org.syno.sync.redo.typing.TypingException;
import org.syno.sync.redo.typing.VariableNotFoundException;

/**
 * Opération unaire.
 * @author jguyot2
 *
 */
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
			throw new TypingException(op.getExpectedType(subExpressionType), subExpressionType);
		}
	}

	@Override
	public void preprocessing(final Environment e) throws VariableNotFoundException, NodeNotFoundException {
		subExpr.preprocessing(e);
	}

	@Override
	public String toString() {
		return op + "(" + subExpr + ")";
	}
}
