package org.syno.sync.redo.typing;

public class VariableNotFoundException extends Exception {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private final String name;

	public VariableNotFoundException(final String variableName) {
		name = variableName;
	}

	public String getName() {
		return name;
	}
}
