package org.syno.sync.redo.ast.types;

import java.util.List;

/**
 * Type tuple, composé de plusieurs sous-types
 * 
 * @author jguyot2
 *
 */
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

	@Override
	public String toString() {
		StringBuilder repr = new StringBuilder("(");
		for (Type t : this.tupleType)
			repr.append(t + ", ");
		return repr.append(")").toString();
	}

	@Override
	public boolean equals(Type other) {
		if (other instanceof CompoundType)
			return this.equals((CompoundType) other);
		else
			return false;
	}

}
