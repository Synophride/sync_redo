package org.syno.sync.redo.ast.programstructure;

import org.syno.sync.redo.ast.types.Type;

/**
 * Contient les types en entrée et en sortie du noeud
 * 
 * @author jguyot2
 */
public class NodeInfo {
	// l'input peut être voidType()
	private final Type inputs;
	private final Type outputs;

	public NodeInfo(final Type in, final Type out) {
		inputs = in;
		outputs = out;
	}

	public Type getInputs() {
		return inputs;
	}

	public Type getOutputs() {
		return outputs;
	}
}
