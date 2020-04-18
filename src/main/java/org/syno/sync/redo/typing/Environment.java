package org.syno.sync.redo.typing;

import java.util.HashMap;
import java.util.Optional;

import org.syno.sync.redo.ast.programstructure.NodeInfo;
import org.syno.sync.redo.ast.types.SimpleType;

public class Environment {
	private HashMap<String, SimpleType> locals;
	private HashMap<String, NodeInfo> nodes;

	public Environment(HashMap<String, SimpleType> locals, HashMap<String, NodeInfo> nodeInformation) {
		this.locals = locals;
		nodes = nodeInformation;
	}

	public Environment() {
		locals = new HashMap<>();
		nodes = new HashMap<>();
	}

	public void addLocal(final String nodeName, final SimpleType typ) {
		locals.put(nodeName, typ);
	}

	public void addNode(final String nodeName, final NodeInfo info) {
		nodes.put(nodeName, info);
	}

	public HashMap<String, SimpleType> getLocals() {
		return locals;
	}

	public Optional<SimpleType> getLocalType(final String variableName) {
		if (locals.containsKey(variableName)) {
			return Optional.of(locals.get(variableName));
		} else {
			return Optional.empty();
		}
	}

	public Optional<NodeInfo> getNodeInformation(final String nodeName) {
		if (nodes.containsKey(nodeName)) {
			return Optional.of(nodes.get(nodeName));
		} else {
			return Optional.empty();
		}
	}

	public HashMap<String, NodeInfo> getNodes() {
		return nodes;
	}

	public void setLocals(final HashMap<String, SimpleType> newLocals) {
		locals = newLocals;
	}

	public void setNodes(final HashMap<String, NodeInfo> newNodes) {
		nodes = newNodes;
	}
}
