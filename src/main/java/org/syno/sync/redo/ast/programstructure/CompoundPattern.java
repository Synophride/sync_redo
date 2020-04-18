package org.syno.sync.redo.ast.programstructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.syno.sync.redo.ast.types.CompoundType;
import org.syno.sync.redo.ast.types.Type;
import org.syno.sync.redo.typing.Environment;

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

	// TODO : getter
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
	public void verifyUniquenessOfAssignments(Environment e, Set<String> sawIdenifiers) throws AlreadyFoundException {
		for(Pattern subPattern : patternList)
			subPattern.verifyUniquenessOfAssignments(e, sawIdenifiers);
	}
}
