/********************************************************************************/
/*                                                                              */
/*              BugMath104.java                                                 */
/*                                                                              */
/*      Defects4J bug Math_104                                                  */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */



package edu.brown.cs.d4jspr;

import org.apache.commons.math.special.Gamma;

public class BugMath104 implements BugConstants
{

public static void main(String [] args)
{
   testMath104();
}


public static void testMath104()
{
   double expected = 0.632120558828558;
   double a = 1.0;
   double x = 1.0;
   double actualP = Gamma.regularizedGammaP(a, x);
   double actualQ = Gamma.regularizedGammaQ(a, x);
   assert Math.abs(expected-actualP) < 10e-15;
   assert Math.abs(actualP-(1.0-actualQ)) < 10e-15;
}

}       // end of class BugMath104




/* end of BugMath104.java */

