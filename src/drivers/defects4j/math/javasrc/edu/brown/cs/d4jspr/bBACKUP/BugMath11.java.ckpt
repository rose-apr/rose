/********************************************************************************/
/*                                                                              */
/*              BugMath11.java                                                  */
/*                                                                              */
/*      description of class                                                    */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */

package edu.brown.cs.d4jspr;

import java.util.Random;


import org.apache.commons.math3.distribution.MultivariateNormalDistribution;
import org.apache.commons.math3.distribution.NormalDistribution;

public class BugMath11 implements BugConstants
{



public static void main(String [] args)
{
   testMath11();
}


public static void testMath11()
{
   final double[] mu = { -1.5 };
   final double[][] sigma = { { 1 } };
   
// try {
//    Class<?> c1 = Class.forName("org.apache.commons.math3.util.FastMath$ExpIntTable");
//    java.lang.reflect.Field f1 = c1.getDeclaredField("EXP_INT_TABLE_A");
//    System.err.println("FOUND " + f1);
//  }
// catch (Throwable t) {
//    t.printStackTrace();
//  }
// try {
//    Object o1 = edu.brown.cs.seede.poppy.PoppyValue.getStaticFieldValue("org.apache.commons.math3.util.FastMath.ExpIntTable.EXP_INT_TABLE_A");
//    System.err.println("POPPY FOUND " + o1);
//  }
// catch (Throwable t) {
//    t.printStackTrace();
//  }
   
   final MultivariateNormalDistribution multi = new MultivariateNormalDistribution(mu, sigma);
   
   final NormalDistribution uni = new NormalDistribution(mu[0], sigma[0][0]);
   final Random rng = new Random(10);
   final int numCases = 3;
   final double tol = Math.ulp(1d);
   for (int i = 0; i < numCases; i++) {
      final double v = rng.nextDouble() * 10 - 5;
      double v0 = uni.density(v);
      double v1 = multi.density(new double[] { v });
      assert Math.abs(v0-v1) <= tol;
    }
}
   
}       // end of class BugMath11




/* end of BugMath11.java */

