/********************************************************************************/
/*                                                                              */
/*              BugMath59.java                                                  */
/*                                                                              */
/*      Defects4J bug Math_59                                                   */
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

import org.apache.commons.math.util.FastMath;

public class BugMath59 implements BugConstants
{




public static void main(String [] args)
{
   testMath59();
}


public static void testMath59()
{
   float[][] pairs = {
         { -50.0f, 50.0f },
    };
   for (float[] pair : pairs) {
      assert FastMath.max(pair[0],pair[1]) == Math.max(pair[0],pair[1]);
      assert FastMath.max(pair[1],pair[0]) == Math.max(pair[1],pair[0]);
    }
   
}


}       // end of class BugMath59




/* end of BugMath59.java */

