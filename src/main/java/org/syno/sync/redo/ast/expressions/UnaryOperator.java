package org.syno.sync.redo.ast.expressions;

import org.syno.sync.redo.ast.types.SimpleType;
import org.syno.sync.redo.ast.types.Type;

/**
 * Enum listant les opérateurs unaires
 * 
 * @author jguyot2
 *
 */
public enum UnaryOperator {
	MINUS("-"), NOT("!"), PRE("pre");

	private String repr;

	private UnaryOperator(final String s) {
		repr = s;
	}

	/**
	 * Détermine si le type en entrée est correct
	 * @param inputType
	 * @return true si l'entrée est bonne, false sinon
	 */
	public boolean isLegitInputType(final Type inputType) {
		switch (this) {
		case PRE:
			return true;
		case NOT:
			return inputType.isBoolean();
		case MINUS:
			return inputType.isNumber();
		}
		throw new Error();
	}
	public Type getExpectedType(final Type input) {
		switch (this) {
		case PRE:
			return input;
		case NOT:
			return SimpleType.getBool();
		case MINUS:
			return SimpleType.getInt();
		}
		throw new Error();
	}
	@Override
	public String toString() {
		return repr;
	}
}
