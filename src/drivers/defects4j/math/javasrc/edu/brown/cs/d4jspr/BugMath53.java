/********************************************************************************/
/*                                                                              */
/*              BugMath53.java                                                  */
/*                                                                              */
/*      Defects4J Bug Math53                                                    */
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

import org.apache.commons.math.complex.Complex;

public class BugMath53 implements BugConstants
{


private static double nan = Double.NaN;


public static void main(String [] args)
{
   testMath53();
}



private static void testMath53()
{
   Complex x = new Complex(3.0, 4.0);
   Complex z = x.add(Complex.NaN);
   assert z.isNaN();
   z = new Complex(1, nan);
   Complex w = x.add(z);
   assert Double.isNaN(w.getReal());
   assert Double.isNaN(w.getImaginary());
}



}       // end of class BugMath53




/* end of BugMath53.java */

