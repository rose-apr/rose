/********************************************************************************/
/*                                                                              */
/*              BugChart17.java                                                 */
/*                                                                              */
/*      Defects4J Bug Chart 17                                                  */
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

import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;

public class BugChart17 implements BugConstants
{


public static void main(String [] args)
{
   testChart17();
}


public static void testChart17()
{
   TimeSeries s1 = new TimeSeries("Series");
   TimeSeries s2 = null;
   try {
      s2 = (TimeSeries) s1.clone();
    }
   catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
   assert s1 != s2;
   assert s1.getClass() == s2.getClass();
   assert s1.equals(s2);
   
   // test independence
   s1.add(new Day(1, 1, 2007), 100.0);
   assert !s1.equals(s2);
}


}       // end of class BugChart17




/* end of BugChart17.java */

