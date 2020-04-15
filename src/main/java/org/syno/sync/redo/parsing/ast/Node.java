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
	
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("NODE " + nodeName + "\n");
		b.append(" IN: ");
		for (Parameter p : inputs) {
			b.append(p + ", ");
		}
		b.append("\n OUT: ");
		for (Parameter p : outputs) {
			b.append(p + ", ");
		}
		b.append("\n LOCALS: ");
		for (Parameter p : localVars) {
			b.append(p + ", ");
		}
		b.append("\n");
		b.append("{");
		for (Equation eq : equations)
			b.append("\t" + eq + "\n");
		b.append("}");
		return b.toString();
	}
	
}
