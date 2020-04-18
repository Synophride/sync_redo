package org.syno.sync.redo.ast.programstructure;

import org.syno.sync.redo.ast.types.Type;

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
