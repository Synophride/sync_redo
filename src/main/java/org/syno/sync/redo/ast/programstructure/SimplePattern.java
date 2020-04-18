package org.syno.sync.redo.ast.programstructure;

import java.util.Set;

import org.syno.sync.redo.ast.types.Type;
import org.syno.sync.redo.typing.Environment;

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
	public void verifyUniquenessOfAssignments(Environment e, Set<String> sawIdenifiers) throws AlreadyFoundException {
		if(sawIdenifiers.contains(identifier))
			throw new AlreadyFoundException();
		sawIdenifiers.add(identifier);
	}
}
