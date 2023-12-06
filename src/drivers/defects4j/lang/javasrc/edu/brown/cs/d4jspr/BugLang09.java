/********************************************************************************/
/*                                                                              */
/*              BugLang09.java                                                  */
/*                                                                              */
/*      Defects4J Bug Lang 09                                                   */
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
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateParser;
import org.apache.commons.lang3.time.FastDateParser;

public class BugLang09 implements BugConstants
{


private static final TimeZone NEW_YORK = TimeZone.getTimeZone("America/New_York");



public static void main(String [] args) 
{
   testLangO9();
}



private static void testLangO9()
{
   try {
      String format = "'d'd'";
      String date = "d3";
      DateParser fdp = new FastDateParser(format, NEW_YORK, Locale.US);
      fdp.parse(date);
      throw new Error("Should not be here");
    }
   catch (Exception t) { }
}


}       // end of class BugLang09




/* end of BugLang09.java */

