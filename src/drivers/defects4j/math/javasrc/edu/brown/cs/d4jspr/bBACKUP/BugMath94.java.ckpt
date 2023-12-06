/********************************************************************************/
/*                                                                              */
/*              BugMath94.java                                                  */
/*                                                                              */
/*      Defects4J bug Math_94                                                   */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */



package edu.brown.cs.d4jspr;

import org.apache.commons.math.util.ArithmeticUtils;

public class BugMath94 implements BugConstants
{

public static void main(String [] args)
{
   testMath94();
}


public static void testMath94()
{
   int v0 = 3 * (1<<15);
   int v1 = 3 * (1<<20);
   int v2 = 9 * (1<<15);
   int r = ArithmeticUtils.gcd(v1,v2);
   assert r == v0;
}


}       // end of class BugMath94




/* end of BugMath94.java */

