package org.syno.sync.redo.ast.programstructure;

import java.util.Set;

import org.syno.sync.redo.ast.types.Type;
import org.syno.sync.redo.typing.Environment;
import org.syno.sync.redo.typing.VariableNotFoundException;

/**
 * Pattern simple, id est composé uniquement d'un identifieur
 * 
 * @author jguyot2
 *
 */
public class SimplePattern extends Pattern {
	private final String identifier;

	public SimplePattern(final String id) {
		identifier = id;
	}

	public String getIdentifier() {
		return identifier;
	}

	@Override
	public Type getType(final Environment e) {
		return e.getLocalType(identifier).get();
	}

	@Override
	public boolean isSimple() {
		return true;
	}

	@Override
	public void verifyUniquenessOfAssignments(final Environment e, final Set<String> sawIdenifiers)
			throws AlreadyFoundException {
		if (sawIdenifiers.contains(identifier)) {
			throw new AlreadyFoundException();
		}
		sawIdenifiers.add(identifier);
	}

	@Override
	public void verifyVarnameExistence(Environment e) throws VariableNotFoundException {
		if (!e.getLocals().containsKey(identifier))
			throw new VariableNotFoundException(identifier);
	}

	public String toString() {
		return identifier;
	}
}
