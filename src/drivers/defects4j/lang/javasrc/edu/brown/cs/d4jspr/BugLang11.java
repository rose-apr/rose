/********************************************************************************/
/*                                                                              */
/*              BugLang11.java                                                  */
/*                                                                              */
/*      Defects4J Bug Lang 11                                                   */
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

import org.apache.commons.lang3.RandomStringUtils;

public class BugLang11 implements BugConstants
{

public static void main(String [] args)
{
   testLang11();
}


private static void testLang11()
{
   try {
      RandomStringUtils.random(3,5,5,false,false);
      throw new Error("Shouldn't be here");
    } catch (IllegalArgumentException ex) { // distinguish from Random#nextInt message
       final String msg = ex.getMessage();
       assert msg.contains("start");
       assert msg.contains("end");
     }
    
}

}       // end of class BugLang11




/* end of BugLang11.java */

