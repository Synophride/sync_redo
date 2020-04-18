package org.syno.sync.redo.ast.programstructure;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.syno.sync.redo.ast.types.CompoundType;
import org.syno.sync.redo.ast.types.SimpleType;
import org.syno.sync.redo.ast.types.Type;
import org.syno.sync.redo.ast.types.VoidType;
import org.syno.sync.redo.typing.Environment;
import org.syno.sync.redo.typing.NodeNotFoundException;
import org.syno.sync.redo.typing.TypingException;
import org.syno.sync.redo.typing.VariableNotFoundException;

public class Node {

	private final List<Equation> equations;
	private final List<Parameter> inputs;
	private final List<Parameter> localVars;
	private final String nodeName;
	private final List<Parameter> outputs;

	public Node(final String name, final List<Parameter> in, final List<Parameter> out, final List<Parameter> loc,
			final List<Equation> eqs) {

		nodeName = name;
		equations = eqs;
		inputs = in;
		outputs = out;
		localVars = loc;
	}

	public List<Equation> getEquations() {
		return equations;
	}

	public List<Parameter> getInputs() {
		return inputs;
	}

	public Type getInputType() {
		switch (inputs.size()) {
		case 0:
			return VoidType.get();
		case 1:
			return inputs.get(0).getType();
		default:
			return new CompoundType(inputs.stream().map(param -> param.getType()).collect(Collectors.toList()));
		}
	}

	public List<Parameter> getLocalVars() {
		return localVars;
	}

	public String getName() {
		return nodeName;
	}

	public List<Parameter> getOutputs() {
		return outputs;
	}

	@Override
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
		for (Equation eq : equations) {
			b.append("\t" + eq + "\n");
		}
		b.append("}");
		return b.toString();
	}

	public NodeInfo getNodeInformation() {
		return new NodeInfo(getInputType(), getOutputType());
	}

	public void typeNode(Environment e) throws TypingException, VariableNotFoundException, NodeNotFoundException {
		for(Equation eq : equations)
			eq.type(e);
	}
	
	public HashMap<String, SimpleType> getLocals() {
		HashMap<String, SimpleType> ret = new HashMap<>();
		for (Parameter p : inputs) {
			ret.put(p.getName(), p.getType());
		}
		for (Parameter p : localVars) {
			ret.put(p.getName(), p.getType());
		}
		for (Parameter p : outputs) {
			ret.put(p.getName(), p.getType());
		}
		return ret;
	}

	public Type getOutputType() {
		List<Type> typeList = outputs.stream().map(parameter -> parameter.getType()).collect(Collectors.toList());
		switch (typeList.size()) {
		case 0:
			throw new Error("Output void type/node without outputs");
		case 1:
			return typeList.get(0);
		default:
			return new CompoundType(typeList);
		}
	}
	
	/**
	 * Vérifie les propriétés du programme:
	 *  Pas d'appel de variable non déclarée,
	 *  pas d'appel de noeud non déclaré
	 *  pas deux assignation de variables dans un noeud
	 *  pas d'assignation d'une entrée dans un noeud
	 *  [opt] : Assignation de toutes les sorties. 
	 */
	public void preprocess(Environment e) {
	}
}
