/********************************************************************************/
/*                                                                              */
/*              BugLang39.java                                                  */
/*                                                                              */
/*      Defects4J Bug Lang 39                                                   */
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

import org.apache.commons.lang3.StringUtils;

public class BugLang39 implements BugConstants
{

public static void main(String [] args)
{
   testLang39();
}


private static void testLang39()
{
   String v1 = StringUtils.replaceEach("aba", new String[]{"a", "b"}, new String[]{"c", null});
   assert v1.equals("cbc");
}




}       // end of class BugLang39




/* end of BugLang39.java */

