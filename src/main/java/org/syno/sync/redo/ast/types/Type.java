package org.syno.sync.redo.ast.types;

public abstract class Type {

	public abstract boolean isBoolean();

	public abstract boolean isInteger();

	public abstract boolean isNumber();

	public abstract boolean isSimple();

	public abstract boolean isVoid();
	
	public abstract String toString();
	
	public abstract boolean equals(Type other);
}
