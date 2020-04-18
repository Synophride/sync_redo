package org.syno.sync.redo.ast.programstructure;

import org.syno.sync.redo.ast.expressions.Expression;
import org.syno.sync.redo.ast.types.Type;
import org.syno.sync.redo.typing.Environment;
import org.syno.sync.redo.typing.NodeNotFoundException;
import org.syno.sync.redo.typing.TypingException;
import org.syno.sync.redo.typing.VariableNotFoundException;

public class Equation {
	private final Expression expression;
	private final Pattern pattern;

	public Equation(final Pattern patt, final Expression expr) {
		pattern = patt;
		expression = expr;
	}

	public Expression getExpression() {
		return expression;
	}

	public Pattern getPattern() {
		return pattern;
	}

	public void type(final Environment e) throws TypingException, VariableNotFoundException, NodeNotFoundException {
		Type patternType = pattern.getType(e);
		Type exprType = expression.getType(e);
		if (!patternType.equals(exprType))
			throw new TypingException(patternType, exprType);
	}

	@Override
	public String toString() {
		return pattern + " = " + expression;
	}
}
