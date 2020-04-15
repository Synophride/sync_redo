package org.syno.sync.redo.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;

import org.syno.sync.redo.parsing.ast.Expression;
import org.syno.sync.redo.parsing.parser.ParseException;
import org.syno.sync.redo.parsing.parser.Parser;

public final class Main {
	public static void main(String... args) throws ParseException, FileNotFoundException {
		File folder = new File("/home/jguyot2/workspace/sync.redo/src/test/testLusFiles/programs/correct/");
		File[] listOfFiles = folder.listFiles();
		
		for(File f :listOfFiles) {
			if(! f.getName().endsWith(".lus"))
				continue;
			System.out.println("Parsing " + f + "...");
			Parser p = new Parser(new FileReader(f));
			System.out.println();
			System.out.println(p.program());
			System.out.println();
			System.out.println();
		}
	}
}
