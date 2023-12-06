/********************************************************************************/
/*                                                                              */
/*              BugLang54.java                                                  */
/*                                                                              */
/*      Defects4J Bug Lang 54                                                   */
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

import java.util.Locale;

import org.apache.commons.lang3.LocaleUtils;

public class BugLang54 implements BugConstants
{


public static void main(String [] args)
{
   testLang54();
}


private static void testLang54()
{
   Locale locale = LocaleUtils.toLocale("fr__POSIX");
   assert locale != null;
   assert locale.getCountry().equals("fr");
   assert locale.getVariant().equals("POSIX");
}

}       // end of class BugLang54




/* end of BugLang54.java */

