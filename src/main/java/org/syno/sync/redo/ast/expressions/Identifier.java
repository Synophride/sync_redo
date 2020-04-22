package org.syno.sync.redo.ast.expressions;

import java.util.Optional;

import org.syno.sync.redo.ast.types.SimpleType;
import org.syno.sync.redo.ast.types.Type;
import org.syno.sync.redo.typing.Environment;
import org.syno.sync.redo.typing.VariableNotFoundException;

/**
 * Expression constituée d'un nom de variable
 * @author jguyot2
 *
 */
public class Identifier extends Expression {
	private final String identifier;

	
	public Identifier(final String s) {
		identifier = s;
	}

	@Override
	public Type getType(final Environment e) {
		Optional<SimpleType> typeOpt = e.getLocalType(identifier);
		return typeOpt.get();
	}

	@Override
	public void preprocessing(final Environment e) throws VariableNotFoundException {
		if (!e.getLocals().containsKey(identifier)) {
			throw new VariableNotFoundException(identifier);
		}
	}

	@Override
	public String toString() {
		return identifier;
	}
}
