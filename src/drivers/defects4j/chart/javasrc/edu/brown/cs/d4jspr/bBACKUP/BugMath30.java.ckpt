/********************************************************************************/
/*                                                                              */
/*              BugMath30.java                                                  */
/*                                                                              */
/*      description of class                                                    */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */

package edu.brown.cs.d4jspr;

import org.apache.commons.math3.stat.inference.MannWhitneyUTest;

public class BugMath30 implements BugConstants
{


public static void main(String [] args)
{
   testMath30();
}


public static void testMath30()
{
   MannWhitneyUTest teststat = new MannWhitneyUTest();
   int ct = 1500;
   double[] d1 = new double[ct];
   double[] d2 = new double[ct];
   for (int i = 0; i < ct; i++) {
      d1[i] = 2 * i;
      d2[i] = 2 * i + 1;
    }
   double result = teststat.mannWhitneyUTest(d1, d2);
   assert result > 0.1;
}



}       // end of class BugMath30




/* end of BugMath30.java */

