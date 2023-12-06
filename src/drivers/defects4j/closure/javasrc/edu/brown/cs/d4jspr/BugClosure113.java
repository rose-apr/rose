/********************************************************************************/
/*                                                                              */
/*              BugClosure113.java                                              */
/*                                                                              */
/*      description of class                                                    */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */


package edu.brown.cs.d4jspr;

import com.google.javascript.jscomp.AbstractCompiler;
import com.google.javascript.jscomp.CheckLevel;
import com.google.javascript.jscomp.Compiler;
import com.google.javascript.jscomp.CompilerOptions;
import com.google.javascript.jscomp.CompilerPass;
import com.google.javascript.jscomp.DiagnosticGroups;
import com.google.javascript.jscomp.NodeTraversal;
import com.google.javascript.jscomp.ProcessClosurePrimitives;
import com.google.javascript.jscomp.VarCheck;
import com.google.javascript.jscomp.NodeTraversal.AbstractPostOrderCallback;
import com.google.javascript.rhino.Node;

import com.google.common.collect.Lists;



public class BugClosure113 extends CompilerTestCode implements BugConstants
{

private static final String EXTERNS = "var window; function alert() {}";

private CheckLevel strictModuleDepErrorLevel;
private boolean sanityCheck = false;

private CheckLevel externValidationErrorLevel;

private boolean declarationCheck;


public void main(String [] args)
{
   BugClosure113 tc = new BugClosure113();
   tc.testClosure113();
}


private BugClosure113()
{
   super(EXTERNS);
}


public void testClosure113()
{
   test("goog.require('namespace.Class1');\n", null,
         ProcessClosurePrimitives.MISSING_PROVIDE_ERROR);
   
}


protected void setUp() throws Exception {
   // Setup value set by individual tests to the appropriate defaults.
   super.allowExternsChanges(true);
   super.enableAstValidation(true);
   strictModuleDepErrorLevel = CheckLevel.OFF;
   externValidationErrorLevel = null;
   sanityCheck = false;
   declarationCheck = false;
}

protected CompilerOptions getOptions() {
   CompilerOptions options = super.getOptions();
   options.setWarningLevel(DiagnosticGroups.STRICT_MODULE_DEP_CHECK,
         strictModuleDepErrorLevel);
   if (externValidationErrorLevel != null) {
      options.setWarningLevel(DiagnosticGroups.EXTERNS_VALIDATION,
            externValidationErrorLevel);
    }
   return options;
}


protected CompilerPass getProcessor(final Compiler compiler) {
   return new CompilerPass() {
      @Override public void process(Node externs, Node root) {
         new VarCheck(compiler, sanityCheck).process(externs, root);
         if (sanityCheck == false && !compiler.hasErrors()) {
            new VarCheck(compiler, true).process(externs, root);
          }
         if (declarationCheck) {
            new VariableTestCheck(compiler).process(externs, root);
          }
       }
    };
}

@Override
protected int getNumRepetitions() {
   // Because we synthesize externs, the second pass won't emit a warning.
   return 1;
}



private final static class VariableTestCheck implements CompilerPass {

   final AbstractCompiler compiler;
   VariableTestCheck(AbstractCompiler compiler) {
      this.compiler = compiler;
    }
   
   @Override
   public void process(Node externs, Node root) {
      NodeTraversal.traverseRoots(compiler, Lists.newArrayList(externs, root),
            new AbstractPostOrderCallback() {
         @Override
                  public void visit(NodeTraversal t, Node n, Node parent) {
            if (n.isName() && !parent.isFunction()
                  && !parent.isLabel()) {
               assert t.getScope().isDeclared(n.getString(), true);
             }
          }
       });
    }
}

public void checkSynthesizedExtern(
      String input, String expectedExtern) {
   checkSynthesizedExtern("", input, expectedExtern);
}

public void checkSynthesizedExtern(
      String extern, String input, String expectedExtern) {
   declarationCheck = !sanityCheck;
   testExternChanges(extern, input, expectedExtern);
}


}       // end of class BugClosure113




/* end of BugClosure113.java */

