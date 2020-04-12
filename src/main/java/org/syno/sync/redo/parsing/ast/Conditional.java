package org.syno.sync.redo.parsing.ast;

import java.util.Objects;

public class Conditional extends Expression {
	private final Expression ifExpr;
	private final Expression thenExpr;
	private final Expression elseExpr;

	public Conditional(Expression ifExp, Expression thenExp, Expression elseExp) {
		ifExpr = ifExp;
		thenExpr = thenExp;
		elseExpr = elseExp;
	}

	public String toString() {
		return "if ( " + ifExpr + " ) then ( " + thenExpr + " ) else ( " + elseExpr + ")";
	}

	public boolean equals(Conditional other) {
		return Objects.equals(ifExpr, other.ifExpr) && Objects.equals(thenExpr, other.thenExpr)
				&& Objects.equals(elseExpr, other.elseExpr);
	}
}
