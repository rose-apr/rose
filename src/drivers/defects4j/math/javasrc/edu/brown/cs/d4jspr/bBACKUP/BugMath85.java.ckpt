/********************************************************************************/
/*                                                                              */
/*              BugMath85.java                                                  */
/*                                                                              */
/*      Defects4J bug Math_85                                                   */
/*                                                                              */
/********************************************************************************/



package edu.brown.cs.d4jspr;

import org.apache.commons.math.distribution.NormalDistribution;

public class BugMath85 implements BugConstants
{


public static void main(String [] args)
{
   testMath85();
}


public static void testMath85()
{
   NormalDistribution normal = new NormalDistribution(0,1);
   double result = normal.inverseCumulativeProbability(0.9772498680518209);
   assert Math.abs(result - 2.0) < 1e-12;
}




}       // end of class BugMath85




/* end of BugMath85.java */

