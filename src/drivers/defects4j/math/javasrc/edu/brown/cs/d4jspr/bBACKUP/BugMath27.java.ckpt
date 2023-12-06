/********************************************************************************/
/*                                                                              */
/*              BugMath27.java                                                  */
/*                                                                              */
/*      description of class                                                    */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */

package edu.brown.cs.d4jspr;

import org.apache.commons.math3.fraction.Fraction;

public class BugMath27 implements BugConstants
{



public static void main(String [] args)
{
   testMath27();
}


public static void testMath27()
{
   final int numer = Integer.MAX_VALUE / 99;
   final int denom = 1;
   final double percentage = 100 * ((double) numer) / denom;
   final Fraction frac = new Fraction(numer, denom);
   double fp = frac.percentageValue();
   assert Math.abs(fp-percentage) < 1e-6;
}
   
}       // end of class BugMath27




/* end of BugMath27.java */

