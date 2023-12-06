/********************************************************************************/
/*                                                                              */
/*              BugClosure65.java                                               */
/*                                                                              */
/*      Defects4J bug Closure_65                                                */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */


package edu.brown.cs.d4jspr;

import com.google.javascript.rhino.Node;


public class BugClosure65 implements BugConstants
{


public static void main(String [] args)
{
   testClosure65();
}


public static void testClosure65()
{
   String t = "var x ='\\0';";
   String r = "var x=\"\\000\"";
   PrintParser pp = new PrintParser();
   Node n = pp.parse(t);
   runTest65(r,pp,n);
}



private static void runTest65(String txt,PrintParser pp,Node n)
{
   String r = pp.print(n);
   assert txt.equals(r);
}



}       // end of class BugClosure65




/* end of BugClosure65.java */

