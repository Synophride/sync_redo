package org.syno.sync.redo.ast.programstructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.syno.sync.redo.ast.types.CompoundType;
import org.syno.sync.redo.ast.types.Type;
import org.syno.sync.redo.typing.Environment;
import org.syno.sync.redo.typing.VariableNotFoundException;

/**
 * Classe représentant un pattern composé de sous-patterns
 * 
 * @author jguyot2
 *
 */
public class CompoundPattern extends Pattern {
	private final List<Pattern> patternList;

	public CompoundPattern(final List<Pattern> lst) {
		assert lst.size() > 1;
		patternList = lst;
	}

	@Override
	public Type getType(final Environment e) {
		List<Type> subPatternTypes = new ArrayList<>();
		for (Pattern p : patternList) {
			subPatternTypes.add(p.getType(e));
		}
		return new CompoundType(subPatternTypes);
	}

	@Override
	public boolean isSimple() {
		return false;
	}

	@Override
	public String toString() {
		StringBuilder bd = new StringBuilder("(");
		for (Pattern id : patternList) {
			bd.append(id + ", ");
		}
		bd.append(")");
		return bd.toString();
	}

	@Override
	public void verifyUniquenessOfAssignments(final Environment e, final Set<String> sawIdenifiers)
			throws AlreadyFoundException {
		for (Pattern subPattern : patternList) {
			subPattern.verifyUniquenessOfAssignments(e, sawIdenifiers);
		}
	}

	@Override
	public void verifyVarnameExistence(Environment e) throws VariableNotFoundException {
		for(Pattern p : patternList)
			p.verifyVarnameExistence(e);
	}
	
	
}
