/********************************************************************************/
/*                                                                              */
/*              BugMath39.java                                                  */
/*                                                                              */
/*      Defects4J Bug Math39                                                    */
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

import org.apache.commons.math.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math.ode.nonstiff.AdaptiveStepsizeIntegrator;
import org.apache.commons.math.ode.nonstiff.DormandPrince853Integrator;
import org.apache.commons.math.util.FastMath;

public class BugMath39 implements BugConstants
{


private static final double start = 0.0;
private static final double end = 0.001;



public static void main(String [] args)
{
   teestMath39();
}



private static void teestMath39()
{
   AdaptiveStepsizeIntegrator integ =
      new DormandPrince853Integrator(0, Double.POSITIVE_INFINITY, Double.NaN, Double.NaN);
   FirstOrderDifferentialEquations equations = new Eqs();
   
    integ.setStepSizeControl(0, 1.0, 1.0e-6, 1.0e-8);
    integ.integrate(equations, start, new double[] { 1.0 }, end, new double[1]);
    
}

private static class Eqs implements FirstOrderDifferentialEquations {
   
   public int getDimension() {
      return 1;
    }
   
   public void computeDerivatives(double t, double[] y, double[] yDot) {
      assert (t >= FastMath.nextAfter(start, Double.NEGATIVE_INFINITY));
      assert (t <= FastMath.nextAfter(end,   Double.POSITIVE_INFINITY));
      yDot[0] = -100.0 * y[0];
    }
   
}       // end of inner class Eqs

}       // end of class BugMath39




/* end of BugMath39.java */

