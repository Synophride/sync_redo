package org.syno.sync.redo.ast.expressions;

import org.syno.sync.redo.ast.programstructure.ParsingPosition;
import org.syno.sync.redo.ast.types.Type;
import org.syno.sync.redo.typing.Environment;
import org.syno.sync.redo.typing.NodeNotFoundException;
import org.syno.sync.redo.typing.TypingException;
import org.syno.sync.redo.typing.VariableNotFoundException;

public abstract class Expression {
	protected ParsingPosition pos;

	public abstract Type getType(Environment e) throws TypingException;

	/**
	 * Vérifie que les propriétés suivantes sont vérifiées : - Pas d'appel de
	 * variable non déclarée - Pas d'appel de noeud non déclaré
	 * 
	 * @param e
	 */
	public abstract void preprocessing(Environment e) throws VariableNotFoundException, NodeNotFoundException;

}
