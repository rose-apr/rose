/********************************************************************************/
/*                                                                              */
/*              BugMath05.java                                                  */
/*                                                                              */
/*      description of class                                                    */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */


package edu.brown.cs.d4jspr;

import org.apache.commons.math3.complex.Complex;

public class BugMath05 implements BugConstants
{

public static void main(String [] args)
{
   testMath05();
}


public static void testMath05()
{
   Complex z = Complex.ZERO;
   Complex zr = z.reciprocal();
   assert zr.equals(Complex.INF);
}

}       // end of class BugMath05




/* end of BugMath05.java */

