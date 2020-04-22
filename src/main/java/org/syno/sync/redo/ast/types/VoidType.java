package org.syno.sync.redo.ast.types;

/**
 * Type vide, uniquement utilisé pour indiquer le type d'entrée des
 * noeuds qui ne prennent pas de paramètre
 * @author jguyot2
 *
 */
public class VoidType extends Type {
	private static final VoidType instance = new VoidType();

	public static VoidType get() {
		return instance;
	};

	private VoidType() {
	};

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

	@Override
	public String toString() {
		return "void";
	}

	@Override
	public boolean equals(Type other) {
		return other instanceof VoidType;
	}

}
