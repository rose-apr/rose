/********************************************************************************/
/*                                                                              */
/*              BugClosure73.java                                               */
/*                                                                              */
/*      Defects4J bug Closure_73                                                */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */


package edu.brown.cs.d4jspr;

import com.google.javascript.rhino.Node;


public class BugClosure73 implements BugConstants
{



public static void main(String [] args)
{
   testClosure73();
}


public static void testClosure73()
{
   String txt = "var x ='\\x7f';";
   String tgt = "var x=\"\\u007f\"";
   PrintParser pp = new PrintParser();
   Node n = pp.parse(txt);
   runTest73(tgt,pp,n);
}



private static void runTest73(String txt,PrintParser pp,Node n)
{
   String r = pp.print(n);
   assert txt.equals(r);
}


}       // end of class BugClosure73




/* end of BugClosure73.java */

