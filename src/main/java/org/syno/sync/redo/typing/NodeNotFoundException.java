package org.syno.sync.redo.typing;

/**
 * Erreur lancée lors de l'appel d'un noeud inexistant
 * @author jguyot2
 *
 */
public class NodeNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	private final String name;

	public NodeNotFoundException(final String nodeName) {
		name = nodeName;
	}

	public String getName() {
		return name;
	}
}
