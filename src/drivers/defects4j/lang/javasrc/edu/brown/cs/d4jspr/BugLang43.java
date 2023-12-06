/********************************************************************************/
/*                                                                              */
/*              BugLang43.java                                                  */
/*                                                                              */
/*      D3fects4J Bug Lang 43                                                   */
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

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.apache.commons.lang3.text.FormatFactory;

public class BugLang43 implements BugConstants
{

public static void main(String [] args)
{ 
   testLang43();
}


private static void testLang43()
{
   Map<String,FormatFactory> registry = new HashMap<>();
   String pattern = "it''s a {0,lower} 'test'!";
   ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry);
   String fmt = emf.format(new Object[] { "DUMMY" } );
   assert fmt.equals("it's a dummy test!");
}


}       // end of class BugLang43




/* end of BugLang43.java */

