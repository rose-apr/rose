/********************************************************************************/
/*                                                                              */
/*              BugClosure123.java                                              */
/*                                                                              */
/*      Defects4J bug Closure_123                                               */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */
package edu.brown.cs.d4jspr;

import com.google.javascript.rhino.Node;

public class BugClosure123 implements BugConstants
{


public static void main(String [] args)
{
   testClosure123();
}


public static void testClosure123()
{
   PrintParser pp = new PrintParser();
   String txt = "for(a=c?0:(0 in d);;)foo()";
   Node n = pp.parse(txt);
   runTest123(txt,pp,n);
}



private static void runTest123(String txt,PrintParser pp,Node n)
{
   String r = pp.print(n);
   assert txt.equals(r);
}

}       // end of class BugClosure123




/* end of BugClosure123.java */

