/********************************************************************************/
/*                                                                              */
/*              BugMath35A.java                                                 */
/*                                                                              */
/*      Math35 first problem from D4J                                                 */
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

import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.genetics.ElitisticListPopulation;

public class BugMath35A implements BugConstants
{


public static void main(String [] args)
{
    testMath35A();
}
    
    
public static void testMath35A()
{
    final double rate = -0.25;
    try {
        new ElitisticListPopulation(100, rate);
        System.err.println("Shouldn't be here");
     }
    catch (OutOfRangeException e) { }
}
    
    
    
}       // end of class BugMath35A




/* end of BugMath35A.java */

