package org.syno.sync.redo.ast.expressions;

import org.syno.sync.redo.ast.types.SimpleType;
import org.syno.sync.redo.ast.types.Type;
import org.syno.sync.redo.typing.Environment;
import org.syno.sync.redo.typing.NodeNotFoundException;
import org.syno.sync.redo.typing.VariableNotFoundException;

/**
 * Constante entière
 * @author jguyot2
 *
 */
public class ConstInt extends Expression {
	private final long value;

	public ConstInt(final String s) {
		value = Long.parseLong(s);
	}

	public boolean equals(final ConstInt other) {
		return this.value == other.value;
	}

	@Override
	public Type getType(final Environment e) {
		return SimpleType.getInt();
	}

	public long getValue() {
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
