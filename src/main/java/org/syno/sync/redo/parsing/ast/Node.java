package org.syno.sync.redo.parsing.ast;

import java.util.List;
public class Node {
	
	private String nodeName;
	private List<Equation> equations;
	private List<Parameter> inputs;
	private List<Parameter> outputs;
	private List<Parameter> localVars;
	
	
	public Node(String name,
			List<Parameter> in,
			List<Parameter> out,
			List<Parameter> loc,
			List<Equation> eqs) {
		
		nodeName = name;
		equations = eqs;
		inputs = in;
		outputs = out;
		localVars = loc;
	}
	
	public String getName() {
		return nodeName;
	}

	public List<Equation> getEquations() {
		return equations;
	}

	public List<Parameter> getInputs() {
		return inputs;
	}

	public List<Parameter> getOutputs() {
		return outputs;
	}

	public List<Parameter> getLocalVars() {
		return localVars;
	}
	
}
