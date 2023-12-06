/********************************************************************************/
/*                                                                              */
/*              BugMath83.java                                                  */
/*                                                                              */
/*      Defects4J bug Math_83                                                   */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */
/*********************************************************************************
 *  Copyright 2011, Brown University, Providence, RI.                            *
 *                                                                               *
 *                        All Rights Reserved                                    *
 *                                                                               *
 * This program and the accompanying materials are made available under the      *
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, *
 * and is available at                                                           *
 *      http://www.eclipse.org/legal/epl-v10.html                                *
 *                                                                               *
 ********************************************************************************/

/* SVN: $Id$ */



package edu.brown.cs.d4jspr;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.math.optimization.GoalType;
import org.apache.commons.math.optimization.RealPointValuePair;
import org.apache.commons.math.optimization.linear.LinearConstraint;
import org.apache.commons.math.optimization.linear.LinearObjectiveFunction;
import org.apache.commons.math.optimization.linear.Relationship;
import org.apache.commons.math.optimization.linear.SimplexSolver;

public class BugMath83 implements BugConstants
{


public static void main(String [] args)
{
   testMath83();
}


public static void testMath83()
{
   LinearObjectiveFunction f = new LinearObjectiveFunction(new double[] { 0.2, 0.3 }, 0 );
   Collection<LinearConstraint> constraints = new ArrayList<LinearConstraint>();
   constraints.add(new LinearConstraint(new double[] { 1, 1 }, Relationship.EQ, 23.0));
   
   RealPointValuePair solution = new SimplexSolver().optimize(f, constraints, GoalType.MAXIMIZE, true);
   assert Math.abs(solution.getValue() - 6.9) < 0.000001;
}


}       // end of class BugMath83




/* end of BugMath83.java */

