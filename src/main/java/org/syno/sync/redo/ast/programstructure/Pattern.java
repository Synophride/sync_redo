package org.syno.sync.redo.ast.programstructure;

import java.util.Set;

import org.syno.sync.redo.ast.types.Type;
import org.syno.sync.redo.typing.Environment;

public abstract class Pattern {
	public abstract Type getType(Environment e);

	public abstract boolean isSimple();

	public abstract void verifyUniquenessOfAssignments(Environment e, Set<String> sawIdenifiers)
			throws AlreadyFoundException;
}
