package org.syno.sync.redo.ast.programstructure;

import java.util.HashMap;
import java.util.List;

import org.syno.sync.redo.typing.Environment;
import org.syno.sync.redo.typing.NodeNotFoundException;
import org.syno.sync.redo.typing.TypingException;
import org.syno.sync.redo.typing.VariableNotFoundException;

public class Program {
	private final List<Node> nodes;

	public Program(final List<Node> nodeList) {
		nodes = nodeList;
	}

	public List<Node> getNodeList() {
		return nodes;
	}

	@Override
	public String toString() {
		StringBuilder retour = new StringBuilder("Programme: +\n");
		for (Node node : nodes) {
			retour.append(node);
			retour.append("\n\n");
		}
		return retour.toString();
	}

	public void typing() throws TypingException, VariableNotFoundException, NodeNotFoundException {
		Environment e;
		HashMap<String, NodeInfo> nodeInformation = new HashMap<>();
		for (Node n : nodes)
			nodeInformation.put(n.getName(), new NodeInfo(n.getInputType(), n.getOutputType()));
		for (Node n : nodes) {
			e = new Environment(n.getLocals(), nodeInformation);
			n.typeNode(e);
		}
	}

	/**
	 * Vérifie les propriétés du programme: Pas d'appel de variable non déclarée,
	 * pas d'appel de noeud non déclaré, pas deux assignation de variables dans un
	 * noeud, pas d'assignation d'une entrée dans un noeud [opt] : Assignation de
	 * toutes les sorties.
	 */
	public void preprocess() {
		Environment e;
		HashMap<String, NodeInfo> nodeInformation = new HashMap<>();
		for (Node n : nodes)
			nodeInformation.put(n.getName(), new NodeInfo(n.getInputType(), n.getOutputType()));
		for (Node n : nodes) {
			e = new Environment(n.getLocals(), nodeInformation);
			n.preprocess(e);
		}
	}
}
