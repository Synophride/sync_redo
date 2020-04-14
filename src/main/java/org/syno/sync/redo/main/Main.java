package org.syno.sync.redo.main;

import java.io.StringReader;

import org.syno.sync.redo.parsing.ast.Expression;
import org.syno.sync.redo.parsing.parser.ParseException;
import org.syno.sync.redo.parsing.parser.Parser;

public final class Main {
	public static void main(String... args) throws ParseException {
		Parser p = new Parser(new StringReader("true"));
		System.out.println(p.expr());
		
	}
}
