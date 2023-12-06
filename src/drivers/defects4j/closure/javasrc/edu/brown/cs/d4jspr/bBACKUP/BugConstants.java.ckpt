/********************************************************************************/
/*                                                                              */
/*              BugConstants.java                                               */
/*                                                                              */
/*      description of class                                                    */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2013 Brown University -- Steven P. Reiss                    */



package edu.brown.cs.d4jspr;

import com.google.javascript.rhino.Node;
import com.google.javascript.jscomp.CodePrinter;
import com.google.javascript.jscomp.Compiler;
import com.google.javascript.jscomp.CompilerOptions;
import com.google.javascript.jscomp.CompilerOptions.LanguageMode;

public interface BugConstants
{



public class PrintParser {
   
   PrintParser() { }
   
   Node parse(String js) {
      Compiler compiler = new Compiler();
      CompilerOptions opts = new CompilerOptions();
      opts.setTrustedStrings(true);
      opts.setLanguageIn(LanguageMode.ECMASCRIPT5);
      compiler.initOptions(opts);
      Node n = compiler.parseTestCode(js);
      assert compiler.getErrors().length == 0;
      assert compiler.getWarnings().length == 0;
      return n;
    }
   
   String print(Node n) {
      CompilerOptions ops = new CompilerOptions();
      ops.setLineLengthThreshold(CodePrinter.DEFAULT_LINE_LENGTH_THRESHOLD);
      ops.setLanguageOut(LanguageMode.ECMASCRIPT5);
      String r = new CodePrinter.Builder(n).setCompilerOptions(ops).build();
      return r;
    }
   
   
   
   
}



}       // end of interface BugConstants




/* end of BugConstants.java */

