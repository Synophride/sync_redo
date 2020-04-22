package org.syno.sync.redo.typing;

/**
 * Exception lancée lors de la rencontre d'un appel à une variable non définie
 * @author jguyot2
 */
public class VariableNotFoundException extends Exception {


	private static final long serialVersionUID = 1L;
	private final String name;

	public VariableNotFoundException(final String variableName) {
		name = variableName;
	}
	
	public String getName() {
		return name;
	}
}
