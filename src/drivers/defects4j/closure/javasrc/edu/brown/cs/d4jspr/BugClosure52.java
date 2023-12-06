/********************************************************************************/
/*                                                                              */
/*              BugClosure52.java                                               */
/*                                                                              */
/*      Defects4J bug Closure_52                                                */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */


package edu.brown.cs.d4jspr;

import com.google.javascript.rhino.Node;


public class BugClosure52 implements BugConstants
{


public static void main(String [] args)
{
   testClosure52();
}


public static void testClosure52()
{
   PrintParser pp = new PrintParser();
   String txt = "var x = {'010': 1};";
   String exp = "var x={\"010\":1}";
   Node n = pp.parse(txt);
   runTest52(exp,pp,n);
}



private static void runTest52(String txt,PrintParser pp,Node n)
{
   String r = pp.print(n);
   assert txt.equals(r);
}


}       // end of class BugClosure52




/* end of BugClosure52.java */

