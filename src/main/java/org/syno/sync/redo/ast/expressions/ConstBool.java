package org.syno.sync.redo.ast.expressions;

import org.syno.sync.redo.ast.types.SimpleType;
import org.syno.sync.redo.ast.types.Type;
import org.syno.sync.redo.typing.Environment;
import org.syno.sync.redo.typing.NodeNotFoundException;
import org.syno.sync.redo.typing.VariableNotFoundException;

/**
 * Constante booléenne
 * @author jguyot2
 *
 */
public class ConstBool extends Expression {
	private final boolean value;

	public ConstBool(final String s) {
		value = Boolean.getBoolean(s);
	}

	public boolean equals(final ConstBool other) {
		return this.value == other.value;
	}

	@Override
	public Type getType(final Environment e) {
		return SimpleType.getBool();
	}

	public boolean getValue() {
		return value;
	}

	@Override
	public void preprocessing(final Environment e) throws VariableNotFoundException, NodeNotFoundException {
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
