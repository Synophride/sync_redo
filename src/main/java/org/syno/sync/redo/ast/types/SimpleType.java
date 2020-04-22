package org.syno.sync.redo.ast.types;


/**
 * Type contenant uniquement un type atomique
 * @author jguyot2
 *
 */
public class SimpleType extends Type {
	public static SimpleType getBool() {
		return new SimpleType(BasicType.BOOL);
	}

	public static SimpleType getInt() {
		return new SimpleType(BasicType.INT);
	}

	public static SimpleType getReal() {
		return new SimpleType(BasicType.REAL);
	}

	private final BasicType t;

	public SimpleType(final BasicType type) {
		t = type;
	}

	public boolean equals(final SimpleType other) {
		return t == other.t;
	}

	public BasicType getType() {
		return t;
	}

	@Override
	public boolean isBoolean() {
		return t == BasicType.BOOL;
	}

	@Override
	public boolean isInteger() {
		return t == BasicType.INT;
	}

	@Override
	public boolean isNumber() {
		return t == BasicType.INT || t == BasicType.REAL;
	}

	@Override
	public boolean isSimple() {
		return true;
	}

	@Override
	public boolean isVoid() {
		return false;
	}
	
	public String toString() {
		return this.t.toString();
	}

	@Override
	public boolean equals(Type other) {

		if(other instanceof SimpleType)
			return this.equals((SimpleType) other);
		else 
			return false;
	}


}
