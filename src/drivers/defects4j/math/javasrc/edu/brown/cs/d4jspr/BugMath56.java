/********************************************************************************/
/*                                                                              */
/*              BugMath56.java                                                  */
/*                                                                              */
/*      Defects4J Bug Math56                                                    */
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

import org.apache.commons.math.util.MultidimensionalCounter;

public class BugMath56 implements BugConstants
{

final static MultidimensionalCounter c = new MultidimensionalCounter(2, 3, 4);
final static int[][] expected = new int[][] {
      { 0, 0, 0 },
      { 0, 0, 1 },
      { 0, 0, 2 },
      { 0, 0, 3 },
      { 0, 1, 0 },
      { 0, 1, 1 },
      { 0, 1, 2 },
      { 0, 1, 3 },
      { 0, 2, 0 },
      { 0, 2, 1 },
      { 0, 2, 2 },
      { 0, 2, 3 },
      { 1, 0, 0 },
      { 1, 0, 1 },
      { 1, 0, 2 },
      { 1, 0, 3 },
      { 1, 1, 0 },
      { 1, 1, 1 },
      { 1, 1, 2 },
      { 1, 1, 3 },
      { 1, 2, 0 },
      { 1, 2, 1 },
      { 1, 2, 2 },
      { 1, 2, 3 }
};

final static int totalSize = c.getSize();
final static int nDim = c.getDimension();

public static void main(String [] args) 
{
   testMath56();
}



private static void testMath56()
{
   final MultidimensionalCounter.Iterator iter = c.iterator();
   for (int i = 0; i < totalSize; i++) {
      if (!iter.hasNext()) {
         throw new Error("Too short");
       }
      final int uniDimIndex = iter.next();
      assert i == uniDimIndex;
      
      for (int dimIndex = 0; dimIndex < nDim; dimIndex++) {
         assert expected[i][dimIndex] == iter.getCount(dimIndex);
       }
      
      assert c.getCount(expected[i]) == uniDimIndex;
      
      final int[] indices = c.getCounts(uniDimIndex);
      for (int dimIndex = 0; dimIndex < nDim; dimIndex++) {
         assert expected[i][dimIndex] == indices[dimIndex];
       }
    }
   
   if (iter.hasNext()) {
      throw new Error("Too Long");
    }
   
}



}       // end of class BugMath56




/* end of BugMath56.java */

