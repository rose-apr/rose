/********************************************************************************/
/*                                                                              */
/*              BugMath105.java                                                 */
/*                                                                              */
/*      Defects4J bug Math_105                                                  */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */



package edu.brown.cs.d4jspr;

import org.apache.commons.math.stat.regression.SimpleRegression;

public class BugMath105 implements BugConstants
{


public static void main(String [] args)
{
   testMath105();
}


public static void testMath105()
{
   double[] y = { 8915.102, 8919.302, 8923.502 };
   double[] x = { 1.107178495E2, 1.107264895E2, 1.107351295E2 };
   SimpleRegression reg = new SimpleRegression();
   for (int i = 0; i < x.length; i++) {
      reg.addData(x[i], y[i]);
    }
   assert reg.getSumSquaredErrors() >= 0.0;
}


}       // end of class BugMath105




/* end of BugMath105.java */

