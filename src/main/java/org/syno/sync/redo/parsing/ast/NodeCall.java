package org.syno.sync.redo.parsing.ast;

import java.util.List;

public class NodeCall extends Expression {
	private String nodeIdentifier;
	private List<Expression> parameters;
	
	public NodeCall(String identifier, List<Expression> params) {
		nodeIdentifier = identifier;
		parameters = params;
	}
	
	public String toString() {
		StringBuilder ret = new StringBuilder(); 
		ret.append(nodeIdentifier);
		for (Expression param : parameters) {
			ret.append(param.toString());
		}
		return ret.toString();
	}
}
