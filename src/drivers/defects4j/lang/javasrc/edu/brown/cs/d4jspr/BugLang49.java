/********************************************************************************/
/*                                                                              */
/*              BugLang49.java                                                  */
/*                                                                              */
/*      description of class                                                    */
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

import org.apache.commons.lang3.math.Fraction;

public class BugLang49 implements BugConstants
{

public static void main(String [] args)
{
   testLang49();
}


private static void testLang49()
{
   Fraction f = Fraction.getReducedFraction(0,100);
   Fraction result = f.reduce();
   assert result == Fraction.ZERO;
}


}       // end of class BugLang49




/* end of BugLang49.java */

