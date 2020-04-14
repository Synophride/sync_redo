package org.syno.sync.redo.parsing.ast;

import java.util.List;

public class NodeCall extends Expression {
	private String nodeIdentifier;
	private List<Expression> parameters;
	
	public NodeCall(String identifier, List<Expression> params) {
		nodeIdentifier = identifier;
		parameters = params;
	}
}
