package org.syno.sync.redo.parsing.ast;

import java.util.List;
public class Node {
	
	private String nodeName;
	private List<Equation> equations;
	private List<Parameter> inputs;
	private List<Parameter> outputs;
	private List<Parameter> localVars;
	
	
	public Node() {
	}
	
}
