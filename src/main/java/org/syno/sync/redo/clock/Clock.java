package org.syno.sync.redo.clock;

public abstract class Clock {
	/*
	 * Règles associées à l'horloge -> Pour tout noeud, toute entrée et sortie sont
	 * sur la même horloge -> Environnement associé aux horloges, associant une
	 * hologe à chaque variable (/expression ?) -> Dans le futur : Des noeuds de
	 * sortie en fonction des noeuds d'entrée ?
	 * 
	 * CAS: -> Appel d'un noeud : Vérifier que toutes les entrées sont sur la même
	 * horloge (ou compatibles?) -> Opérateur binaire: Même chose -> x fby y -> y.
	 * 
	 * 
	 * -> WHEN: x when const -> Clock of const(x). Plus petit que clock(x). ->
	 * MERGE: merge(x) (true => e1) (false => e2) e1 = of(x true). (op trinaire au
	 * lieu de MERGE ?) e2 = of(x false) clock de l'expression == clock(x)
	 * 
	 * Typage dans les équations =? -> Remplacement de la clock lors du clock-typing
	 * d'une expression ? -> Besoin de retyper ? -> Liaison dans la HM ?
	 * 
	 * ClockEnvironment Créer une clock séparée pour toutes les variables locales
	 * puis inférer ? Inférence = ?
	 * 
	 * 
	 *
	 *
	 * Fusion entre Clocks pour indiquer que + Possibilité de sous-typage de sets de
	 * clock.
	 * 
	 * Map : String -> Set <Clock> + pointage vers une clock parente
	 *
	 * Génération d'une liste de contraintes sur les clocks. De la forme c1 <= c2 ||
	 * c1 == c2. -> Calcul d'un ordre partiel sur les clocks ?
	 * 
	 */
}
