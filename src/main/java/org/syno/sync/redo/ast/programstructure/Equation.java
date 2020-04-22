package org.syno.sync.redo.ast.programstructure;

import java.util.HashSet;

import org.syno.sync.redo.ast.expressions.Expression;
import org.syno.sync.redo.ast.types.Type;
import org.syno.sync.redo.typing.Environment;
import org.syno.sync.redo.typing.NodeNotFoundException;
import org.syno.sync.redo.typing.TypingException;
import org.syno.sync.redo.typing.VariableNotFoundException;

/**
 * Classe représentant une équation, de la forme <pattern> = <expr>
 * 
 * @author jguyot2
 */
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

	@Override
	public String toString() {
		return pattern + " = " + expression;
	}

	public void preprocess(Environment e)
			throws VariableNotFoundException, NodeNotFoundException, AlreadyFoundException {
		this.pattern.verifyUniquenessOfAssignments(e, new HashSet<String>());
		this.pattern.verifyVarnameExistence(e);
		this.expression.preprocessing(e);
	}

	/**
	 * Typage du pattern à partir de l'environnement e.
	 * 
	 * @param e
	 * @throws TypingException
	 */
	public void type(final Environment e) throws TypingException {
		Type patternType = pattern.getType(e);
		System.out.println(patternType);
		Type exprType = expression.getType(e);
		System.out.println(exprType);
		System.out.println();
		System.out.println();
		if (!patternType.equals(exprType)) {
			throw new TypingException(patternType, exprType);
		}
	}
}
