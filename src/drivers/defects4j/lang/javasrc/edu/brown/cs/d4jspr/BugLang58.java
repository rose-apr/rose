/********************************************************************************/
/*                                                                              */
/*              BugLang58.java                                                  */
/*                                                                              */
/*      Defects4J Bug Lang58                                                    */
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

import org.apache.commons.lang3.math.NumberUtils;

public class BugLang58 implements BugConstants
{


public static void main(String [] args)
{
   testLang58();
}


private static void testLang58()
{
   NumberUtils.createNumber("1l");
}

}       // end of class BugLang58




/* end of BugLang58.java */

