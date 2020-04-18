package org.syno.sync.redo.ast.expressions;

import java.util.ArrayList;
import java.util.List;

import org.syno.sync.redo.ast.types.CompoundType;
import org.syno.sync.redo.ast.types.Type;
import org.syno.sync.redo.typing.Environment;
import org.syno.sync.redo.typing.NodeNotFoundException;
import org.syno.sync.redo.typing.TypingException;
import org.syno.sync.redo.typing.VariableNotFoundException;

public class Tuple extends Expression {
	List<Expression> subExpressions;

	public Tuple(final List<Expression> expressions) {
		subExpressions = expressions;
	}

	List<Expression> getSubExpressions() {
		return subExpressions;
	}

	@Override
	public Type getType(final Environment e) throws TypingException {
		List<Type> subExprTypes = new ArrayList<>();

		for (Expression expr : subExpressions) {
			subExprTypes.add(expr.getType(e));
		}
		return new CompoundType(subExprTypes);
	}

	@Override
	public void preprocessing(Environment e) throws VariableNotFoundException, NodeNotFoundException {
		for(Expression subExp : subExpressions)
			subExp.preprocessing(e);
	}
}
