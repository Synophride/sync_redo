package org.syno.sync.redo.ast.programstructure;

import java.util.HashMap;
import java.util.List;

import org.syno.sync.redo.typing.Environment;
import org.syno.sync.redo.typing.NodeNotFoundException;
import org.syno.sync.redo.typing.TypingException;
import org.syno.sync.redo.typing.VariableNotFoundException;

public class Program {
	private final List<Node> nodes;

	public void process() throws Exception {
		this.preprocess();
		this.typing();
	}
	public Program(final List<Node> nodeList) {
		nodes = nodeList;
	}

	public List<Node> getNodeList() {
		return nodes;
	}

	/**
	 * Vérifie les propriétés du programme: Pas d'appel de variable non déclarée,
	 * pas d'appel de noeud non déclaré, pas deux assignation de variables dans un
	 * noeud, pas d'assignation d'une entrée dans un noeud [opt] : Assignation de
	 * toutes les sorties.
	 * 
	 * //TODO: Pas de double déclaration
	 * @throws AlreadyFoundException 
	 * @throws NodeNotFoundException 
	 * @throws VariableNotFoundException 
	 */
	public void preprocess() throws VariableNotFoundException, NodeNotFoundException, AlreadyFoundException {
		Environment e;
		HashMap<String, NodeInfo> nodeInformation = new HashMap<>();
		for (Node n : nodes) {
			nodeInformation.put(n.getName(), new NodeInfo(n.getInputType(), n.getOutputType()));
		}
		for (Node n : nodes) {
			e = new Environment(n.getLocals(), nodeInformation);
			n.preprocess(e);
		}
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

	/**
	 * Typage du programme
	 * 
	 * @throws TypingException En cas de problème de type
	 */
	public void typing() throws TypingException {
		Environment e;
		HashMap<String, NodeInfo> nodeInformation = new HashMap<>();
		for (Node n : nodes) {
			nodeInformation.put(n.getName(), new NodeInfo(n.getInputType(), n.getOutputType()));
		}
		for (Node n : nodes) {
			e = new Environment(n.getLocals(), nodeInformation);
			n.typeNode(e);
		}
	}
}
