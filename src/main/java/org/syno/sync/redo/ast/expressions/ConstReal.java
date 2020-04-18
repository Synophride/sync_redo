package org.syno.sync.redo.ast.expressions;

import org.syno.sync.redo.ast.types.SimpleType;
import org.syno.sync.redo.ast.types.Type;
import org.syno.sync.redo.typing.Environment;
import org.syno.sync.redo.typing.NodeNotFoundException;
import org.syno.sync.redo.typing.VariableNotFoundException;

public class ConstReal extends Expression {
	private final double value;

	public ConstReal(final String s) {
		value = Double.parseDouble(s);
	}

	public boolean equals(final ConstReal other) {
		return this.value == other.value;
	}

	@Override
	public Type getType(final Environment e) {
		return SimpleType.getReal();
	}

	public double getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	@Override
	public void preprocessing(Environment e) throws VariableNotFoundException, NodeNotFoundException {
	}
}
