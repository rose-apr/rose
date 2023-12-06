/********************************************************************************/
/*                                                                              */
/*              BugMath22A.java                                                 */
/*                                                                              */
/*      D4J Math22 first bug                                                    */
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

import org.apache.commons.math3.distribution.RealDistribution;
import org.apache.commons.math3.distribution.UniformRealDistribution;

public class BugMath22A implements BugConstants
{
    
    private static RealDistribution distribution;
    

public static void main(String [] args)
{
    distribution = new UniformRealDistribution(-0.5,1.25);
    testMath22A();
}
    
    
public static void testMath22A()
{
    final double upperBound = distribution.getSupportUpperBound();
    double result = Double.NaN;
    result = distribution.density(upperBound);
    boolean fg = !Double.isInfinite(upperBound) && !Double.isNaN(result) &&
            !Double.isInfinite(result);
    assert fg == distribution.isSupportUpperBoundInclusive();
}
    
    
}       // end of class BugMath22A




/* end of BugMath22A.java */

