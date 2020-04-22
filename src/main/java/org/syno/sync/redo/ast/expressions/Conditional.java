package org.syno.sync.redo.ast.expressions;

import java.util.Objects;

import org.syno.sync.redo.ast.types.SimpleType;
import org.syno.sync.redo.ast.types.Type;
import org.syno.sync.redo.typing.Environment;
import org.syno.sync.redo.typing.NodeNotFoundException;
import org.syno.sync.redo.typing.TypingException;
import org.syno.sync.redo.typing.VariableNotFoundException;

/**
 * représente une expression conditionnelle, de la forme "if <exp> then <exp>
 * else <exp>"
 * 
 * @author jguyot2
 *
 */
public class Conditional extends Expression {
	private final Expression elseExpr;
	private final Expression ifExpr;
	private final Expression thenExpr;

	public Conditional(final Expression ifExp, final Expression thenExp, final Expression elseExp) {
		ifExpr = ifExp;
		thenExpr = thenExp;
		elseExpr = elseExp;
	}

	public boolean equals(final Conditional other) {
		return Objects.equals(ifExpr, other.ifExpr) && Objects.equals(thenExpr, other.thenExpr)
				&& Objects.equals(elseExpr, other.elseExpr);
	}

	@Override
	public Type getType(final Environment e) throws TypingException {
		Type boolExprType = ifExpr.getType(e);
		Type thenExprType = thenExpr.getType(e);
		Type elseExprType = elseExpr.getType(e);
		if (!boolExprType.isBoolean()) {
			throw new TypingException(SimpleType.getBool(), boolExprType);
		}

		if (!thenExprType.equals(elseExprType)) {
			throw new TypingException(thenExprType, elseExprType);
		}
		return thenExprType;
	}

	@Override
	public void preprocessing(final Environment e) throws VariableNotFoundException, NodeNotFoundException {
		ifExpr.preprocessing(e);
		thenExpr.preprocessing(e);
		elseExpr.preprocessing(e);
	}

	@Override
	public String toString() {
		return "if ( " + ifExpr + " ) then ( " + thenExpr + " ) else ( " + elseExpr + ")";
	}

}
