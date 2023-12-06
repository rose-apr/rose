/********************************************************************************/
/*                                                                              */
/*              BugClosure38.java                                               */
/*                                                                              */
/*      Defects4J bug Closure_38                                                */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */

package edu.brown.cs.d4jspr;

import com.google.javascript.rhino.Node;

public class BugClosure38 implements BugConstants
{



public static void main(String [] args)
{
   testClosure38();
}


public static void testClosure38()
{
   PrintParser pp = new PrintParser();
   String txt = "x- -0";
   String exp = "x- -0.0";
   Node n = pp.parse(txt);
   runTest38(exp,pp,n);
}



private static void runTest38(String txt,PrintParser pp,Node n)
{
   String r = pp.print(n);
   assert txt.equals(r);
}



}       // end of class BugClosure38




/* end of BugClosure38.java */

