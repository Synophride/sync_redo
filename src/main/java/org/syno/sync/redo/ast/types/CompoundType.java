package org.syno.sync.redo.ast.types;

import java.util.List;

public class CompoundType extends Type {
	private final List<Type> tupleType;

	public CompoundType(final List<Type> types) {
		assert types.size() > 1;
		tupleType = types;
	}

	public boolean equals(final CompoundType other) {
		return tupleType.equals(other.tupleType);
	}

	public List<Type> getTypeList() {
		return tupleType;
	}

	@Override
	public boolean isBoolean() {
		return false;
	}

	@Override
	public boolean isInteger() {
		return false;
	}

	@Override
	public boolean isNumber() {
		return false;
	}

	@Override
	public boolean isSimple() {
		return true;
	}

	@Override
	public boolean isVoid() {
		return false;
	}
}
