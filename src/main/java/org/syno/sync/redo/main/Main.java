package org.syno.sync.redo.main;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedList;

import org.syno.sync.redo.parsing.parser.ParseException;

/**
 * TODO: Gestion des types tuple dans d'autres tuples ? -> Implique
 * refactorisation de la classe pattern et du parser -> Refacto des méthodes
 * getType() TODO: Javadoc TODO: refacto du parser ? TODO: Ajout de la
 * localisation dans le parseur
 */
public final class Main {
	public static void main(final String... args) throws ParseException, FileNotFoundException {
		// List<Object> l1, l2;
		HashSet<Object> l1;
		LinkedList<Object> l2;
		l1 = new HashSet<>();
		l2 = new LinkedList<>();
		System.out.println(l1.equals(l2));
	}
}
