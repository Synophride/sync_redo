package org.syno.sync.redo.ast.programstructure;

import java.util.Set;

import org.syno.sync.redo.ast.types.Type;
import org.syno.sync.redo.typing.Environment;
import org.syno.sync.redo.typing.VariableNotFoundException;

/**
 * Représente un pattern = les identifiants à gauche d'une affectation
 * 
 * @author jguyot2
 *
 */
public abstract class Pattern {
	/**
	 * Rend le type attendu d'un pattern
	 * 
	 * @param e environnement, utilisé pour associer un type à chaque identifiant
	 * @return le type attendu pour le pattern
	 */
	public abstract Type getType(Environment e);

	/**
	 * @return true si le pattern est uniquement composé d'un identifieur, false
	 *         sinon
	 */
	public abstract boolean isSimple();

	/**
	 * Vérification qu'un pattern est assigné une seule et unique fois. 
	 */
	public abstract void verifyUniquenessOfAssignments(Environment e, Set<String> sawIdenifiers)
			throws AlreadyFoundException;
	
	//TODO:renommage
	public abstract void verifyVarnameExistence(Environment e) throws VariableNotFoundException;
	public abstract String toString();
}
