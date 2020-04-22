package org.syno.sync.redo.ast.expressions;

import java.util.Arrays;

import org.syno.sync.redo.ast.types.CompoundType;
import org.syno.sync.redo.ast.types.SimpleType;
import org.syno.sync.redo.ast.types.Type;

/**
 * Enumération représentant les opérateurs binaires associés aux opérations
 * 
 * @author jguyot2
 *
 */
public enum BinaryOperator {

	AND("&&"), DIV("/"), EQ("=="), EVERY("EVERY"), FOLLOWED_BY("->"), GREATER_OR_EQUAL(">="), GREATER_THAN(">"),
	LESSER_OR_EQUAL("<="), LESSER_THAN("<"), MINUS("-"), MOD("%"), MULT("*"), NEQ("!="), OR("||"), PLUS("+");

	// représentation de la chaîne
	private String s;

	private BinaryOperator(final String str) {
		s = str;
	}

	/**
	 * Affiche le type de retour attendu par l'opérateur courant en fonction des
	 * opérandes en entrée, sans vérification du correct des opérateurs.
	 * 
	 * @param leftOperandType
	 * @param rightOperandType
	 * @return Le type attendu en fonction des entrées
	 */
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

	/**
	 * Détermine si les entrées sont de type correct par rapport à l'opérateur
	 * 
	 * @param leftOperandType
	 * @param rightOperandType
	 * @return true si l'appel est correct, false sinon
	 */
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

	public Type getExpectedType(Type leftOperandType, Type rightOperandType) {
		switch (this) {
		case AND:
		case OR:
			return new CompoundType(Arrays.asList(SimpleType.getBool(), SimpleType.getBool()));
		case LESSER_OR_EQUAL:
		case LESSER_THAN:
		case GREATER_OR_EQUAL:
		case GREATER_THAN:
		case PLUS:
		case MINUS:
		case MULT:
		case DIV:
			if (leftOperandType.isNumber())
				return new CompoundType(Arrays.asList(leftOperandType, leftOperandType));
			else if (rightOperandType.isNumber())
				return new CompoundType(Arrays.asList(rightOperandType, rightOperandType));
			else
				return new CompoundType(Arrays.asList(SimpleType.getInt(), SimpleType.getInt()));

		case NEQ:
		case EQ:
		case FOLLOWED_BY:
			return new CompoundType(Arrays.asList(leftOperandType, leftOperandType));
		case EVERY:
			return new CompoundType(Arrays.asList(leftOperandType, SimpleType.getBool()));
		case MOD:
			return new CompoundType(Arrays.asList(SimpleType.getInt(), SimpleType.getInt()));
		default:
			throw new Error();
		}
	}

	@Override
	public String toString() {
		return s;
	}
}
