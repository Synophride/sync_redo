package org.syno.sync.redo.ast.types;


/**
 * Enumération représentant les types atomiques
 * @author jguyot2
 *
 */
public enum BasicType {
	BOOL("bool"), INT("int"), REAL("float");

	String msg;

	private BasicType(final String s) {
		msg = s;
	}

	public boolean isNumber() {
		return this == INT || this == REAL;
	}

	@Override
	public String toString() {
		return msg;
	}
}