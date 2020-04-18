package org.syno.sync.redo.ast.programstructure;

import org.syno.sync.redo.ast.types.SimpleType;

public class Parameter {
	private final String name;
	private final SimpleType type;

	public Parameter(final String name, final SimpleType type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public SimpleType getType() {
		return type;
	}

	@Override
	public String toString() {
		return name + ":" + type;
	}
}
