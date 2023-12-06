/********************************************************************************/
/*                                                                              */
/*              BugClosure57.java                                               */
/*                                                                              */
/*      Defects4J bug Closure_57                                                   */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */


package edu.brown.cs.d4jspr;

import com.google.javascript.jscomp.ClosureCodingConvention;
import com.google.javascript.jscomp.Compiler;
import com.google.javascript.rhino.Node;

public class BugClosure57 implements BugConstants
{

public static void main(String [] args)
{
   testClosure57();
}



public static void testClosure57()
{
   String r = "goog.require(foo)";
   Compiler c = new Compiler();
   Node n = c.parseTestCode(r).getFirstChild();
   runTest57(n);
}


public static void runTest57(Node n)
{
   ClosureCodingConvention conv = new ClosureCodingConvention();
   String s = conv.extractClassNameIfRequire(n.getFirstChild(),n);
   assert s == null;
}

}       // end of class BugClosure57




/* end of BugClosure57.java */

