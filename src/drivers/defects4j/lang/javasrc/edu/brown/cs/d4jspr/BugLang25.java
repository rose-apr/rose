/********************************************************************************/
/*                                                                              */
/*              BugLang25.java                                                  */
/*                                                                              */
/*      Defects4J Bug Lang 25                                                   */
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

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.text.translate.EntityArrays;

public class BugLang25 implements BugConstants
{

public static void main(String [] args)
{
   testLang25();
}


private static void testLang25()
{
   Set<String> col0 = new HashSet<String>();
   Set<String> col1 = new HashSet<String>();
   String [][] sa = EntityArrays.ISO8859_1_ESCAPE();
   for(int i =0; i <sa.length; i++){
      assert col0.add(sa[i][0]);
      assert col1.add(sa[i][1]);
    }
}


}       // end of class BugLang25




/* end of BugLang25.java */

