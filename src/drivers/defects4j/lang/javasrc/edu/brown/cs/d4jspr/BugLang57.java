/********************************************************************************/
/*                                                                              */
/*              BugLang57.java                                                  */
/*                                                                              */
/*      Defects4J Bug Lang57                                                 */
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

import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.LocaleUtils;

public class BugLang57 implements BugConstants
{

public static void main(String [] args)
{
   testLang57();
}


private static void testLang57()
{
   List l1 = LocaleUtils.availableLocaleList();
   Set s1 = LocaleUtils.availableLocaleSet();
   assert l1 != null;
}

}       // end of class BugLang57




/* end of BugLang57.java */

