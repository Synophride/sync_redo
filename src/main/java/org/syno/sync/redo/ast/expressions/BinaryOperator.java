package org.syno.sync.redo.ast.expressions;

import org.syno.sync.redo.ast.types.SimpleType;
import org.syno.sync.redo.ast.types.Type;

public enum BinaryOperator {

	AND("&&", InputType.BOOLEAN), DIV("/", InputType.NUMBER), EQ("==", InputType.ANY),
	EVERY("EVERY", InputType.ANY_THEN_BOOL), FOLLOWED_BY("->", InputType.ANY), GREATER_OR_EQUAL(">=", InputType.NUMBER),
	GREATER_THAN(">", InputType.NUMBER), LESSER_OR_EQUAL("<=", InputType.NUMBER), LESSER_THAN("<", InputType.NUMBER),
	MINUS("-", InputType.NUMBER), MOD("%", InputType.INTEGER), MULT("*", InputType.NUMBER), NEQ("!=", InputType.ANY),
	OR("||", InputType.BOOLEAN), PLUS("+", InputType.NUMBER);// Impl = pour la construction WHEN, aucun
																// sens de le mettre là
	// Peut-être changer ça ? => Dégager l'enum privée ou changer les identifieurs ?

	private enum InputType {
		ANY, ANY_THEN_BOOL, BOOLEAN, INTEGER, NUMBER;
	}

	private InputType expectedInputs; // TODO: dégager ça
	private String s;

	private BinaryOperator(final String str, final InputType t) {
		s = str;
		expectedInputs = t;
	}

	public Type getReturnType(final Type leftOperandType, final Type rightOperandType) {
		switch (this) {
		case AND:
		case OR:
		case LESSER_OR_EQUAL:
		case LESSER_THAN:
		case GREATER_OR_EQUAL:
		case GREATER_THAN:
		case NEQ:
		case EQ:
			return SimpleType.getBool();
		case PLUS:
		case MINUS:
		case MULT:
		case DIV:
		case MOD:
		case FOLLOWED_BY:
		case EVERY:
			return leftOperandType;
		default:
			throw new RuntimeException();
		}
	}

	// TODO : faire en sorte de pouvoir déterminer le type attendu dans le cas de
	// mauvais appels
	public boolean isCorrectCall(final Type leftOperandType, final Type rightOperandType) {
		switch (this) {
		case AND:
		case OR:
			return leftOperandType.isBoolean() && rightOperandType.isBoolean();
		case LESSER_OR_EQUAL:
		case LESSER_THAN:
		case GREATER_OR_EQUAL:
		case GREATER_THAN:
		case PLUS:
		case MINUS:
		case MULT:
		case DIV:
			return leftOperandType.isNumber() && rightOperandType.isNumber()
					&& leftOperandType.equals(rightOperandType);
		case NEQ:
		case EQ:
		case FOLLOWED_BY:
			return leftOperandType.equals(rightOperandType);
		case EVERY:
			return rightOperandType.isBoolean();
		case MOD:
			return leftOperandType.isInteger() && rightOperandType.isInteger();
		default:
			throw new Error();
		}
	}

	public boolean isReturnInput() {
		throw new Error("not implemented");
	}

	@Override
	public String toString() {
		return s;
	}
}
