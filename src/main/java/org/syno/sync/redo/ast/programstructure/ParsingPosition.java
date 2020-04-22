package org.syno.sync.redo.ast.programstructure;

/**
 * Position de parsing dans un fichier
 * @author jguyot2
 *
 */
public class ParsingPosition {
	private final int beginColumn;
	private final int beginLine;
	private final int endColumn;
	private final int endLine;

	public ParsingPosition(final int beginL, final int beginC, final int endL, final int endC) {
		beginLine = beginL;
		beginColumn = beginC;
		endLine = endL;
		endColumn = endC;
	}

	public int getBeginColumn() {
		return beginColumn;
	}

	public int getBeginLine() {
		return beginLine;
	}

	public int getEndColumn() {
		return endColumn;
	}

	public int getEndLine() {
		return endLine;
	}
}
