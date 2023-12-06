/********************************************************************************/
/*                                                                              */
/*              BugClosure62.java                                               */
/*                                                                              */
/*      Defects4J bug Closure_62                                                */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */


package edu.brown.cs.d4jspr;

import com.google.javascript.jscomp.DiagnosticType;
import com.google.javascript.jscomp.JSError;
import com.google.javascript.jscomp.LightweightMessageFormatter;
import com.google.javascript.jscomp.Region;
import com.google.javascript.jscomp.SourceExcerptProvider;

public class BugClosure62 implements BugConstants
{


private static final DiagnosticType FOO_TYPE =
   DiagnosticType.error("TEST_FOO", "error description here");


public static void main(String [] args)
{ 
   testClosure62();
}


public static void testClosure62()
{
   JSError error = JSError.make("javascript/complex.js",
         1, 10, FOO_TYPE);
   LightweightMessageFormatter formatter = formatter("assert (1;");
   String rslt = formatter.formatError(error);
   String tgt = "javascript/complex.js:1: ERROR - error description here\n" +
         "assert (1;\n" +
         "          ^\n";
   assert rslt.equals(tgt);
}


private static LightweightMessageFormatter formatter(String s)
{
   return new LightweightMessageFormatter(new Source(s));
}


private static class Source implements SourceExcerptProvider {
   
   private String source_text;
   
   Source(String txt) {
      source_text = txt;
    }
   
   public String getSourceLine(String nm,int ln) { return source_text; }
   public Region getSourceRegion(String nm,int ln) {
      throw new UnsupportedOperationException();
    }
   
}       // end of inner class Source

}       // end of class BugClosure62




/* end of BugClosure62.java */

