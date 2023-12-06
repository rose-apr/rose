/********************************************************************************/
/*                                                                              */
/*              BugClosure104.java                                              */
/*                                                                              */
/*      Defects4J bug Closure_104                                               */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */


package edu.brown.cs.d4jspr;

import com.google.javascript.rhino.ErrorReporter;
import com.google.javascript.rhino.jstype.JSType;
import com.google.javascript.rhino.jstype.JSTypeNative;
import com.google.javascript.rhino.jstype.JSTypeRegistry;

public class BugClosure104 implements BugConstants
{

private static JSTypeRegistry registry;
private static JSType EVAL_ERROR_TYPE;
private static JSType URI_ERROR_TYPE;
private static JSType STRING_OBJECT_TYPE;
private static JSType NO_OBJECT_TYPE;


public static void main(String [] args)
{
   setup();
   testClosure104();
}


private static void setup()
{
   TestErrorReporter errorReporter = new TestErrorReporter();
   registry = new JSTypeRegistry(errorReporter);
   EVAL_ERROR_TYPE =
      registry.getNativeObjectType(JSTypeNative.EVAL_ERROR_TYPE);
   URI_ERROR_TYPE =
      registry.getNativeObjectType(JSTypeNative.URI_ERROR_TYPE);
   STRING_OBJECT_TYPE =
      registry.getNativeObjectType(JSTypeNative.STRING_OBJECT_TYPE);
   NO_OBJECT_TYPE =
      registry.getNativeObjectType(JSTypeNative.NO_OBJECT_TYPE);
   
}

public static void testClosure104()
{
   JSType errUnion = registry.createUnionType(EVAL_ERROR_TYPE, URI_ERROR_TYPE);
   JSType gst = errUnion.getGreatestSubtype(STRING_OBJECT_TYPE);
   assert gst == NO_OBJECT_TYPE;
}


private static class TestErrorReporter implements ErrorReporter {
   
   public void error(String msg,String src,int line,int off) { }
   public void warning(String msg,String src,int line,int off) { }
   
}

}       // end of class BugClosure104




/* end of BugClosure104.java */

