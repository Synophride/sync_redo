package org.syno.sync.redo.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.LinkedList;

import org.syno.sync.redo.ast.programstructure.Program;
import org.syno.sync.redo.parsing.parser.ParseException;
import org.syno.sync.redo.parsing.parser.Parser;

/**
 * TODO: Clock typing
 * TODO: refaire le preprocessing de l'instruction EVERY.
 * TODO: Vérification d'absence de boucles de causalité
 * TODO: Normalisation
 * TODO: Pseudo-cache pour le type (=mémoriser le type associé à chaque expression)
 * TODO: Ajout de la localisation dans le parseur 
 */
public final class Main {
	public static void main(final String... args) 
			throws Exception {
		File folder = new File("/home/jguyot2/workspace/sync.redo/src/test/testLusFiles/programs/correct/");
		File[] listOfFiles = folder.listFiles();

		for(File f :listOfFiles) {
			if(! f.getName().endsWith(".lus"))
				continue;

			System.out.println("Parsing " + f + "...");
			Parser p = new Parser(new FileReader(f));
			Program prog = p.program();
			
			System.out.println("Processing and typing");
			prog.process();
			System.out.println();
			System.out.println(prog);
			System.out.println();
			System.out.println();
		}
	}
}
