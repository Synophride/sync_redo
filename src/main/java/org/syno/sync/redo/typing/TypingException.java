package org.syno.sync.redo.typing;

import org.syno.sync.redo.ast.types.Type;

/**
 * Exception de typage
 * 
 * @author jguyot2
 */
public class TypingException extends Exception {

	private static final long serialVersionUID = 1L;
	private Type encountered;
	private Type expected;

	public TypingException(final Type expectedType, final Type encounteredType) {
		expected = expectedType;
		encountered = encounteredType;
	}

	public String getMessage() {
		return toString();
	}

	public String toString() {
		return "Type error : Expected " + expected + " but encountered " + encountered;
	}

	public Type getEncountered() {
		return encountered;
	}

	public Type getExpected() {
		return expected;
	}
}
