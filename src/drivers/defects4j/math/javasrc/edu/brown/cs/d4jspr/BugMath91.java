/********************************************************************************/
/*                                                                              */
/*              BugMath91.java                                                  */
/*                                                                              */
/*      Defects4J Bug Math 91                                                   */
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

import org.apache.commons.math.fraction.Fraction;

public class BugMath91 implements BugConstants
{

public static void main(String [] args)
{
   testMath91();
}


private static void testMath91()
{
   // these two values are different approximations of PI
   // the first  one is approximately PI - 3.07e-18
   // the second one is approximately PI + 1.936e-17
   Fraction pi1 = new Fraction(1068966896, 340262731);
   Fraction pi2 = new Fraction( 411557987, 131002976);
   assert pi1.compareTo(pi2) == -1;
   assert pi2.compareTo(pi1) == 1;
   assert Math.abs(pi1.doubleValue() - pi2.doubleValue()) < 1e-20;
}


}       // end of class BugMath91




/* end of BugMath91.java */

