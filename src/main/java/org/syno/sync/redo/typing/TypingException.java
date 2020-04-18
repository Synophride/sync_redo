package org.syno.sync.redo.typing;

import org.syno.sync.redo.ast.types.Type;

public class TypingException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Type encountered;
	private Type expected;

	public TypingException() {
	}

	public TypingException(final Type expectedType, final Type encounteredType) {
		expected = expectedType;
		encountered = encounteredType;
	}

	public Type getEncountered() {
		return encountered;
	}

	public Type getExpected() {
		return expected;
	}
}
