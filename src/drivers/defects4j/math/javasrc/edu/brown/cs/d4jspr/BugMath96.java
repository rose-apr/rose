/********************************************************************************/
/*                                                                              */
/*              BugMath96.java                                                  */
/*                                                                              */
/*      Defects4J bug Math_96                                                   */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */



package edu.brown.cs.d4jspr;

import org.apache.commons.math.complex.Complex;

public class BugMath96 implements BugConstants
{

public static void main(String [] args)
{
   testMath96();
}


public static void testMath96()
{
   Complex c0 = new Complex(0,-1);
   Complex c1 = new Complex(0,1);
   Complex c2 = new Complex(-1,0);
   Complex c3 = c1.multiply(c2);
   assert c0.equals(c3);
}

}       // end of class BugMath96




/* end of BugMath96.java */

