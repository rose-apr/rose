/********************************************************************************/
/*                                                                              */
/*              BugMath82.java                                                  */
/*                                                                              */
/*      Defects4J bug Math_82                                                   */
/*                                                                              */
/********************************************************************************/



package edu.brown.cs.d4jspr;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.math.optimization.GoalType;
import org.apache.commons.math.optimization.RealPointValuePair;
import org.apache.commons.math.optimization.linear.LinearConstraint;
import org.apache.commons.math.optimization.linear.LinearObjectiveFunction;
import org.apache.commons.math.optimization.linear.Relationship;
import org.apache.commons.math.optimization.linear.SimplexSolver;

public class BugMath82 implements BugConstants
{


public static void main(String [] args)
{
   testMath82();
}


public static void testMath82()
{
   LinearObjectiveFunction f = new LinearObjectiveFunction(new double[] { 7, 3, 0, 0 }, 0 );
   Collection<LinearConstraint> constraints = new ArrayList<LinearConstraint>();
   constraints.add(new LinearConstraint(new double[] { 3, 0, -5, 0 }, Relationship.LEQ, 0.0));
   constraints.add(new LinearConstraint(new double[] { 2, 0, 0, -5 }, Relationship.LEQ, 0.0));
   constraints.add(new LinearConstraint(new double[] { 0, 3, 0, -5 }, Relationship.LEQ, 0.0));
   constraints.add(new LinearConstraint(new double[] { 1, 0, 0, 0 }, Relationship.LEQ, 1.0));
   constraints.add(new LinearConstraint(new double[] { 0, 1, 0, 0 }, Relationship.LEQ, 1.0));
   
   SimplexSolver solver = new SimplexSolver();
   RealPointValuePair solution = solver.optimize(f, constraints, GoalType.MAXIMIZE, true);
   assert solution.getValue() == 10.0;
}



}       // end of class BugMath82




/* end of BugMath82.java */

