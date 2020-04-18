package org.syno.sync.redo.ast.types;

public class VoidType extends Type {
	private static final VoidType instance = new VoidType();

	public static VoidType get() {
		return instance;
	};

	private VoidType() {
	};

	public boolean equals(final VoidType other) {
		return true;
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
		return false;
	}

	@Override
	public boolean isVoid() {
		return true;
	}
}
