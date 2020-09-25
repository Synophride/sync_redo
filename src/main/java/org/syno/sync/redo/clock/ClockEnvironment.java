package org.syno.sync.redo.clock;

import java.util.Map;

public class ClockEnvironment {
	private Map<String, Clock> evt; // Association d'une horloge à chaque identifieur
	
	public ClockEnvironment(Map<String, Clock> environment) {
		evt = environment;
	}
	
	public Clock getClock(String identifier) {
		return evt.get(identifier);
	}

	public void mergeClock(String id1, String id2) {
		
	}
}
