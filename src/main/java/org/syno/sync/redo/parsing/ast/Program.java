package org.syno.sync.redo.parsing.ast;

import java.util.List;

public class Program {
	private List<Node> nodes;
	
	public Program(List<Node> nodeList) {
		nodes = nodeList;
	}

	public List<Node> getNodeList() {
		return nodes;
	}
}
