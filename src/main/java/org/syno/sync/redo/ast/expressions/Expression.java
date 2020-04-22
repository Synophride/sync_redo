package org.syno.sync.redo.ast.expressions;

import org.syno.sync.redo.ast.programstructure.ParsingPosition;
import org.syno.sync.redo.ast.types.Type;
import org.syno.sync.redo.clock.Clock;
import org.syno.sync.redo.typing.Environment;
import org.syno.sync.redo.typing.NodeNotFoundException;
import org.syno.sync.redo.typing.TypingException;
import org.syno.sync.redo.typing.VariableNotFoundException;

/**
 * Classe représentant une
 * 
 * @author jguyot2
 *
 */
public abstract class Expression {

	protected ParsingPosition pos;

	/**
	 * Obtention du type de l'expression
	 * 
	 * @param e
	 * @return Le type de l'expression, si cette dernière est bien typée
	 * @throws TypingException si l'expression est mal typée.
	 */
	public abstract Type getType(Environment e) throws TypingException;

	/**
	 * Vérifie que les propriétés suivantes sont vérifiées : Pas d'appel de variable
	 * non déclarée ni d'appel de noeud non déclaré/
	 *
	 * @param e l'environnement dans lequel se trouve l'expression
	 */
	public abstract void preprocessing(Environment e) throws VariableNotFoundException, NodeNotFoundException;

	/**
	 * 
	 * @param e
	 * @return
	 */
	public abstract Clock getClock(Environment e);

}
