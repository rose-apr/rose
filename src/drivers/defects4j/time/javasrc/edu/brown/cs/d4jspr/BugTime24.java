/********************************************************************************/
/*                                                                              */
/*              BugTime24.java                                                  */
/*                                                                              */
/*      Defects4J Bug Time 24                                                   */
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

import org.joda.time.Chronology;
import org.joda.time.LocalDate;
import org.joda.time.chrono.GJChronology;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class BugTime24 implements BugConstants
{


public static void main(String [] args) 
{
   testTime24();
}


private static void testTime24()
{
   Chronology chrono = GJChronology.getInstanceUTC();
   DateTimeFormatter f = DateTimeFormat.forPattern("xxxx-MM-ww").withChronology(chrono);
   LocalDate ld1 = new LocalDate(2010,1,4,chrono);
   LocalDate ld2 = f.parseLocalDate("2010-01-01");
   assert ld1.equals(ld2);
}

}       // end of class BugTime24




/* end of BugTime24.java */

