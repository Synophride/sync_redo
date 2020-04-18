package org.syno.sync.redo.ast.expressions;

import java.util.ArrayList;
import java.util.List;

import org.syno.sync.redo.ast.programstructure.NodeInfo;
import org.syno.sync.redo.ast.types.CompoundType;
import org.syno.sync.redo.ast.types.Type;
import org.syno.sync.redo.ast.types.VoidType;
import org.syno.sync.redo.typing.Environment;
import org.syno.sync.redo.typing.NodeNotFoundException;
import org.syno.sync.redo.typing.TypingException;
import org.syno.sync.redo.typing.VariableNotFoundException;

public class NodeCall extends Expression {
	private final String nodeIdentifier;
	private final List<Expression> parameters;

	public NodeCall(final String identifier, final List<Expression> params) {
		nodeIdentifier = identifier;
		parameters = params;
	}

	// TODO : refacto cette fonction
	@Override
	public Type getType(final Environment e) throws TypingException {
		NodeInfo calledNode = e.getNodeInformation(nodeIdentifier).get();
		Type inputType = calledNode.getInputs();
		List<Type> parameterTypes = new ArrayList<>();
		for (Expression expr : parameters) {
			parameterTypes.add(expr.getType(e));
		}

		if (inputType.isVoid()) {
			if (parameterTypes.size() > 0) {
				throw new TypingException(VoidType.get(), new CompoundType(parameterTypes));
			}
		} else if (inputType.isSimple()) {
			if (parameterTypes.size() != 1) {
				throw new TypingException(inputType, new CompoundType(parameterTypes));
			}
			if (!parameterTypes.get(0).equals(calledNode.getInputs())) {
				throw new TypingException(inputType, parameterTypes.get(0));
			}
		} else {
			Type paramsType = new CompoundType(parameterTypes);
			if (!paramsType.equals(inputType)) {
				throw new TypingException(inputType, paramsType);
			}
		}
		return calledNode.getOutputs();
	}

	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();
		ret.append(nodeIdentifier);
		for (Expression param : parameters) {
			ret.append(param.toString());
		}
		return ret.toString();
	}

	@Override
	public void preprocessing(Environment e) throws VariableNotFoundException, NodeNotFoundException {
		if (!e.getNodes().containsKey(nodeIdentifier))
			throw new NodeNotFoundException(nodeIdentifier);
		for (Expression expr : parameters)
			expr.preprocessing(e);
	}
}
