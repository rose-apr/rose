/********************************************************************************/
/*                                                                              */
/*              BugMath33.java                                                  */
/*                                                                              */
/*      Defects4J Bug Math_33                                                   */
/*                                                                              */
/********************************************************************************/

package edu.brown.cs.d4jspr;

import java.util.ArrayList;

import org.apache.commons.math3.optimization.PointValuePair;
import org.apache.commons.math3.optimization.linear.LinearConstraint;
import org.apache.commons.math3.optimization.linear.LinearObjectiveFunction;
import org.apache.commons.math3.optimization.linear.Relationship;
import org.apache.commons.math3.optimization.linear.SimplexSolver;
import org.apache.commons.math3.optimization.GoalType;

public class BugMath33 implements BugConstants
{

    
    
public static void main(String [] args)
{
    testMath33();
}


public static void testMath33()
{
    LinearObjectiveFunction f = new LinearObjectiveFunction(new double[] { 2, 6, 7 }, 0);
    
    ArrayList<LinearConstraint> constraints = new ArrayList<LinearConstraint>();
    constraints.add(new LinearConstraint(new double[] { 1, 2, 1 }, Relationship.LEQ, 2));
    constraints.add(new LinearConstraint(new double[] { -1, 1, 1 }, Relationship.LEQ, -1));
    constraints.add(new LinearConstraint(new double[] { 2, -3, 1 }, Relationship.LEQ, -1));
    
    double epsilon = 1e-6;
    SimplexSolver solver = new SimplexSolver();
    PointValuePair solution = solver.optimize(f, constraints, GoalType.MAXIMIZE, false);
    
    double [] sol = solution.getPoint();
    double val = solution.getValue();
    assert sol[0] > 0;
    assert sol[1] > 0;
    assert sol[2] < 0;
    assert val == 2.0;
}



}       // end of class BugMath33




/* end of BugMath33.java */

