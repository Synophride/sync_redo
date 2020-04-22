package org.syno.sync.redo.clock;

import org.syno.sync.redo.ast.expressions.Expression;
/*
 * exp1 WHEN exp2
 */

/**
 * 
 * @author jguyot2
 */
public class SubClock extends Clock {

	private Expression leftExpr;
	private Expression whenExpr;

	public SubClock(Expression left, Expression when) {
		leftExpr = left;
		whenExpr = when;
	}

}
