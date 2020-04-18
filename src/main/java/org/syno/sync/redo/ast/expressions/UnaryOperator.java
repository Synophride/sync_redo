package org.syno.sync.redo.ast.expressions;

import org.syno.sync.redo.ast.types.Type;

public enum UnaryOperator {
	MINUS("-"), NOT("!"), PRE("pre");

	private String repr;

	private UnaryOperator(final String s) {
		repr = s;
	}

	// TODO: Lancer une exception indiquant quel type est attendu ?
	public boolean isLegitInputType(final Type inputType) {
		switch (this) {
		case PRE:
			return true;
		case NOT:
			return inputType.isBoolean();
		case MINUS:
			return inputType.isNumber();
		}
		throw new Error("This should not be happening");
	}

	@Override
	public String toString() {
		return repr;
	}
}
