package org.syno.sync.redo.parsing.ast;

import java.util.List;

public class Pattern {
	private List<String> identList;
	public Pattern(List<String> lst) {
		identList = lst;
	}
	
	public String toString() {
		StringBuilder bd = new StringBuilder("(");
		for(String id : identList) {
			bd.append(id + ", ");
		}
		bd.append(")");
		
		return bd.toString();
	}
}
