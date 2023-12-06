/********************************************************************************/
/*										*/
/*		CompilerTestCode.java						*/
/*										*/
/*	Code for running closure compiler					*/
/*										*/
/********************************************************************************/
/*	Copyright 2011 Brown University -- Steven P. Reiss		      */
/*********************************************************************************
 *  Copyright 2011, Brown University, Providence, RI.				 *
 *										 *
 *			  All Rights Reserved					 *
 *										 *
 *  Permission to use, copy, modify, and distribute this software and its	 *
 *  documentation for any purpose other than its incorporation into a		 *
 *  commercial product is hereby granted without fee, provided that the 	 *
 *  above copyright notice appear in all copies and that both that		 *
 *  copyright notice and this permission notice appear in supporting		 *
 *  documentation, and that the name of Brown University not be used in 	 *
 *  advertising or publicity pertaining to distribution of the software 	 *
 *  without specific, written prior permission. 				 *
 *										 *
 *  BROWN UNIVERSITY DISCLAIMS ALL WARRANTIES WITH REGARD TO THIS		 *
 *  SOFTWARE, INCLUDING ALL IMPLIED WARRANTIES OF MERCHANTABILITY AND		 *
 *  FITNESS FOR ANY PARTICULAR PURPOSE.  IN NO EVENT SHALL BROWN UNIVERSITY	 *
 *  BE LIABLE FOR ANY SPECIAL, INDIRECT OR CONSEQUENTIAL DAMAGES OR ANY 	 *
 *  DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS,		 *
 *  WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS		 *
 *  ACTION, ARISING OUT OF OR IN CONNECTION WITH THE USE OR PERFORMANCE 	 *
 *  OF THIS SOFTWARE.								 *
 *										 *
 ********************************************************************************/



package edu.brown.cs.d4jspr;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.javascript.jscomp.AstValidator;
import com.google.javascript.jscomp.BasicErrorManager;
import com.google.javascript.jscomp.CheckLevel;
import com.google.javascript.jscomp.CodingConvention;
import com.google.javascript.jscomp.Compiler;
import com.google.javascript.jscomp.CompilerInput;
import com.google.javascript.jscomp.CompilerOptions;
import com.google.javascript.jscomp.CompilerPass;
import com.google.javascript.jscomp.DiagnosticType;
import com.google.javascript.jscomp.ErrorManager;
import com.google.javascript.jscomp.GoogleCodingConvention;
import com.google.javascript.jscomp.JSError;
import com.google.javascript.jscomp.JSModule;
import com.google.javascript.jscomp.LineNumberCheck;
import com.google.javascript.jscomp.MarkNoSideEffectCalls;
import com.google.javascript.jscomp.NodeUtil;
import com.google.javascript.jscomp.Normalize;
import com.google.javascript.jscomp.PrepareAst;
import com.google.javascript.jscomp.ProcessClosurePrimitives;
import com.google.javascript.jscomp.PureFunctionIdentifier;
import com.google.javascript.jscomp.RecentChange;
import com.google.javascript.jscomp.SourceFile;
import com.google.javascript.jscomp.TypeCheck;
import com.google.javascript.jscomp.CompilerOptions.LanguageMode;
import com.google.javascript.jscomp.type.ReverseAbstractInterpreter;
import com.google.javascript.jscomp.type.SemanticReverseAbstractInterpreter;
import com.google.javascript.rhino.Node;
import com.google.javascript.rhino.testing.BaseJSTypeTestCase;
import com.google.javascript.jscomp.DiagnosticGroups;



abstract class CompilerTestCode
{


/********************************************************************************/
/*										*/
/*	Private Storage 							*/
/*										*/
/********************************************************************************/

/** Externs for the test */
private final List<SourceFile> externsInputs;

/** Whether to compare input and output as trees instead of strings */
private final boolean compareAsTree;

/** Whether to parse type info from JSDoc comments */
protected boolean parseTypeInfo;

/** Whether we check warnings without source information. */
private boolean allowSourcelessWarnings = false;

/** True iff closure pass runs before pass being tested. */
private boolean closurePassEnabled = false;

/** True iff type checking pass runs before pass being tested. */
private boolean typeCheckEnabled = false;

/** Error level reported by type checker. */
private CheckLevel typeCheckLevel;

/** Whether to the test compiler pass before the type check. */
protected boolean runTypeCheckAfterProcessing = false;

/** Whether the Normalize pass runs before pass being tested. */
private boolean normalizeEnabled = false;

/** Whether the expected JS strings should be normalized. */
private boolean normalizeExpected = false;

/** Whether to check that all line number information is preserved. */
private boolean checkLineNumbers = true;

/** Whether we expect parse warnings in the current test. */
private boolean expectParseWarningsThisTest = false;

/**
   * An expected symbol table error. Only useful for testing the
   * symbol table error-handling.
   */
private DiagnosticType expectedSymbolTableError = null;

/**
   * Whether the MarkNoSideEffectsCalls pass runs before the pass being tested
   */
private boolean markNoSideEffects = false;

/**
   * Whether the PureFunctionIdentifier pass runs before the pass being tested
   */
private boolean computeSideEffects = false;

/** The most recently used Compiler instance. */
private Compiler lastCompiler;

/**
   * Whether to acceptES5 source.
   */
private boolean acceptES5 = true;

/**
   * Whether externs changes should be allowed for this pass.
   */
private boolean allowExternsChanges = false;

/**
   * Whether the AST should be validated.
   */
private boolean astValidationEnabled = true;

private String filename = "testcode";


/********************************************************************************/
/*										*/
/*	Constructors								*/
/*										*/
/********************************************************************************/

protected CompilerTestCode(String externs, boolean compareAsTree) {
   this.externsInputs = ImmutableList.of(
	 SourceFile.fromCode("externs", externs));
   this.compareAsTree = compareAsTree;
   this.parseTypeInfo = false;
}


/**
   * Constructs a test. Uses AST comparison.
   * @param externs Externs JS as a string
   */
protected CompilerTestCode(String externs) {
   this(externs, true);
}

/**
   * Constructs a test. Uses AST comparison and no externs.
   */
protected CompilerTestCode() {
   this("", true);
}

protected void tearDown() throws Exception {
   expectParseWarningsThisTest = false;
}

/**
   * Gets the compiler pass instance to use for a test.
   *
   * @param compiler The compiler
   * @return The pass to test
   */
protected abstract CompilerPass getProcessor(Compiler compiler);


/**
   * Gets the compiler options to use for this test. Use getProcessor to
   * determine what passes should be run.
   */
protected CompilerOptions getOptions() {
   return getOptions(new CompilerOptions());
}

/**
   * Gets the compiler options to use for this test. Use getProcessor to
   * determine what passes should be run.
   */
protected CompilerOptions getOptions(CompilerOptions options) {
   if (this.acceptES5) {
      options.setLanguageIn(LanguageMode.ECMASCRIPT5);
    }

   // This doesn't affect whether checkSymbols is run--it just affects
   // whether variable warnings are filtered.
   options.checkSymbols = true;

   options.setWarningLevel(
	 DiagnosticGroups.MISSING_PROPERTIES, CheckLevel.WARNING);
   options.setWarningLevel(
	 DiagnosticGroups.INVALID_CASTS, CheckLevel.WARNING);
   options.setCodingConvention(getCodingConvention());
   return options;
}

protected CodingConvention getCodingConvention() {
   return new GoogleCodingConvention();
}

public void setFilename(String filename) {
   this.filename = filename;
}

/**
   * Returns the number of times the pass should be run before results are
   * verified.
   */
protected int getNumRepetitions() {
   // Since most compiler passes should be idempotent, we run each pass twice
   // by default.
   return 2;
}

/** Expect warnings without source information. */
void allowSourcelessWarnings() {
   allowSourcelessWarnings = true;
}

/** The most recently used JSComp instance. */
Compiler getLastCompiler() {
   return lastCompiler;
}

/**
   * Whether to allow ECMASCRIPT5 source parsing.
   */
protected void enableEcmaScript5(boolean acceptES5) {
   this.acceptES5 = acceptES5;
}

/**
   * Whether to allow externs changes.
   */
protected void allowExternsChanges(boolean allowExternsChanges) {
   this.allowExternsChanges = allowExternsChanges;
}

/**
   * Perform type checking before running the test pass. This will check
   * for type errors and annotate nodes with type information.
   *
   * @param level the level of severity to report for type errors
   *
   * @see TypeCheck
   */
public void enableTypeCheck(CheckLevel level) {
   typeCheckEnabled  = true;
   typeCheckLevel = level;
}

/**
   * Check to make sure that line numbers were preserved.
   */
public void enableLineNumberCheck(boolean newVal) {
   checkLineNumbers = newVal;
}

/**
   * Do not run type checking before running the test pass.
   *
   * @see TypeCheck
   */
void disableTypeCheck() {
   typeCheckEnabled  = false;
}

/**
   * Process closure library primitives.
   */
// TODO(nicksantos): Fix other passes to use this when appropriate.
void enableClosurePass() {
   closurePassEnabled = true;
}

/**
   * Perform AST normalization before running the test pass, and anti-normalize
   * after running it.
   *
   * @see Normalize
   */
protected void enableNormalize() {
   enableNormalize(true);
}

/**
   * Perform AST normalization before running the test pass, and anti-normalize
   * after running it.
   *
   * @param normalizeExpected Whether to perform normalization on the
   * expected JS result.
   * @see Normalize
   */
protected void enableNormalize(boolean normalizeExpected) {
   normalizeEnabled = true;
   this.normalizeExpected = normalizeExpected;
}

/**
   * Don't perform AST normalization before running the test pass.
   * @see Normalize
   */
protected void disableNormalize() {
   normalizeEnabled = false;
}

/**
   * Run the MarkSideEffectCalls pass before running the test pass.
   *
   * @see MarkNoSideEffectCalls
   */
// TODO(nicksantos): This pass doesn't get run anymore. It should be removed.
void enableMarkNoSideEffects() {
   markNoSideEffects  = true;
}

/**
   * Run the PureFunctionIdentifier pass before running the test pass.
   *
   * @see MarkNoSideEffectCalls
   */
void enableComputeSideEffects() {
   computeSideEffects  = true;
}

/**
   * Whether to allow Validate the AST after each run of the pass.
   */
protected void enableAstValidation(boolean validate) {
   astValidationEnabled = validate;
}

/** Whether we should ignore parse warnings for the current test method. */
protected void setExpectParseWarningsThisTest() {
   expectParseWarningsThisTest = true;
}

/** Returns a newly created TypeCheck. */
private static TypeCheck createTypeCheck(Compiler compiler,
      CheckLevel level) {
   ReverseAbstractInterpreter rai =
      new SemanticReverseAbstractInterpreter(compiler.getCodingConvention(),
	    compiler.getTypeRegistry());

   return new TypeCheck(compiler, rai, compiler.getTypeRegistry(), level);
}

/**
   * Verifies that the compiler pass's JS output matches the expected output.
   *
   * @param js Input
   * @param expected Expected JS output
   */
public void test(String js, String expected) {
   test(js, expected, (DiagnosticType) null);
}

/**
   * Verifies that the compiler pass's JS output matches the expected output,
   * or that an expected error is encountered.
   *
   * @param js Input
   * @param expected Expected output, or null if an error is expected
   * @param error Expected error, or null if no error is expected
   */
public void test(String js, String expected, DiagnosticType error) {
   test(js, expected, error, null);
}


/**
   * Verifies that the compiler pass's JS output matches the expected output,
   * or that an expected error is encountered.
   *
   * @param js Input
   * @param expected Expected output, or null if an error is expected
   * @param error Expected error, or null if no error is expected
   * @param warning Expected warning, or null if no warning is expected
   * @param description The content of the error expected
   */
public void test(String js, String expected, DiagnosticType error,
      DiagnosticType warning, String description) {
   test(externsInputs, js, expected, error, warning, description);
}

/**
   * Verifies that the compiler pass's JS output matches the expected output
   * and (optionally) that an expected warning is issued. Or, if an error is
   * expected, this method just verifies that the error is encountered.
   *
   * @param js Input
   * @param expected Expected output, or null if an error is expected
   * @param error Expected error, or null if no error is expected
   * @param warning Expected warning, or null if no warning is expected
   */
public void test(String js, String expected,
      DiagnosticType error, DiagnosticType warning) {
   test(externsInputs, js, expected, error, warning, null);
}

/**
   * Verifies that the compiler pass's JS output matches the expected output
   * and (optionally) that an expected warning is issued. Or, if an error is
   * expected, this method just verifies that the error is encountered.
   *
   * @param externs Externs input
   * @param js Input
   * @param expected Expected output, or null if an error is expected
   * @param error Expected error, or null if no error is expected
   * @param warning Expected warning, or null if no warning is expected
   */
public void test(String externs, String js, String expected,
      DiagnosticType error, DiagnosticType warning) {
   test(externs, js, expected, error, warning, null);
}

/**
   * Verifies that the compiler pass's JS output matches the expected output
   * and (optionally) that an expected warning is issued. Or, if an error is
   * expected, this method just verifies that the error is encountered.
   *
   * @param externs Externs input
   * @param js Input
   * @param expected Expected output, or null if an error is expected
   * @param error Expected error, or null if no error is expected
   * @param warning Expected warning, or null if no warning is expected
   * @param description The description of the expected warning,
   *	  or null if no warning is expected or if the warning's description
   *	  should not be examined
   */
public void test(String externs, String js, String expected,
      DiagnosticType error, DiagnosticType warning,
      String description) {
   List<SourceFile> externsInputs = ImmutableList.of(
	 SourceFile.fromCode("externs", externs));
   test(externsInputs, js, expected, error, warning, description);
}

/**
   * Verifies that the compiler pass's JS output matches the expected output
   * and (optionally) that an expected warning is issued. Or, if an error is
   * expected, this method just verifies that the error is encountered.
   *
   * @param externs Externs inputs
   * @param js Input
   * @param expected Expected output, or null if an error is expected
   * @param error Expected error, or null if no error is expected
   * @param warning Expected warning, or null if no warning is expected
   * @param description The description of the expected warning,
   *	  or null if no warning is expected or if the warning's description
   *	  should not be examined
   */
public void test(List<SourceFile> externs, String js, String expected,
      DiagnosticType error,
      DiagnosticType warning, String description) {
   Compiler compiler = createCompiler();
   lastCompiler = compiler;

   CompilerOptions options = getOptions();

   if (this.acceptES5) {
      options.setLanguageIn(LanguageMode.ECMASCRIPT5);
    }
   // Note that in this context, turning on the checkTypes option won't
   // actually cause the type check to run.
   options.checkTypes = parseTypeInfo;
   compiler.init(externs, ImmutableList.of(
	 SourceFile.fromCode(filename, js)), options);

   BaseJSTypeTestCase.addNativeProperties(compiler.getTypeRegistry());

   test(compiler, maybeCreateArray(expected), error, warning, description);
}

private String[] maybeCreateArray(String expected) {
   if (expected != null) {
      return new String[] { expected };
    }
   return null;
}

/**
   * Verifies that the compiler pass's JS output matches the expected output.
   *
   * @param js Inputs
   * @param expected Expected JS output
   */
public void test(String[] js, String[] expected) {
   test(js, expected, null);
}

/**
   * Verifies that the compiler pass's JS output matches the expected output,
   * or that an expected error is encountered.
   *
   * @param js Inputs
   * @param expected Expected JS output
   * @param error Expected error, or null if no error is expected
   */
public void test(String[] js, String[] expected, DiagnosticType error) {
   test(js, expected, error, null);
}

/**
   * Verifies that the compiler pass's JS output matches the expected output
   * and (optionally) that an expected warning is issued. Or, if an error is
   * expected, this method just verifies that the error is encountered.
   *
   * @param js Inputs
   * @param expected Expected JS output
   * @param error Expected error, or null if no error is expected
   * @param warning Expected warning, or null if no warning is expected
   */
public void test(String[] js, String[] expected, DiagnosticType error,
      DiagnosticType warning) {
   test(js, expected, error, warning, null);
}

/**
   * Verifies that the compiler pass's JS output matches the expected output
   * and (optionally) that an expected warning is issued. Or, if an error is
   * expected, this method just verifies that the error is encountered.
   *
   * @param js Inputs
   * @param expected Expected JS output
   * @param error Expected error, or null if no error is expected
   * @param warning Expected warning, or null if no warning is expected
   * @param description The description of the expected warning,
   *	  or null if no warning is expected or if the warning's description
   *	  should not be examined
   */
public void test(String[] js, String[] expected, DiagnosticType error,
      DiagnosticType warning, String description) {
   Compiler compiler = createCompiler();
   lastCompiler = compiler;

   List<SourceFile> inputs = Lists.newArrayList();
   for (int i = 0; i < js.length; i++) {
      inputs.add(SourceFile.fromCode("input" + i, js[i]));
    }
   compiler.init(externsInputs, inputs, getOptions());
   test(compiler, expected, error, warning, description);
}

/**
   * Verifies that the compiler pass's JS output matches the expected output.
   *
   * @param modules Module inputs
   * @param expected Expected JS outputs (one per module)
   */
public void test(JSModule[] modules, String[] expected) {
   test(modules, expected, null);
}

/**
   * Verifies that the compiler pass's JS output matches the expected output,
   * or that an expected error is encountered.
   *
   * @param modules Module inputs
   * @param expected Expected JS outputs (one per module)
   * @param error Expected error, or null if no error is expected
   */
public void test(JSModule[] modules, String[] expected,
      DiagnosticType error) {
   test(modules, expected, error, null);
}

/**
   * Verifies that the compiler pass's JS output matches the expected output
   * and (optionally) that an expected warning is issued. Or, if an error is
   * expected, this method just verifies that the error is encountered.
   *
   * @param modules Module inputs
   * @param expected Expected JS outputs (one per module)
   * @param error Expected error, or null if no error is expected
   * @param warning Expected warning, or null if no warning is expected
   */
public void test(JSModule[] modules, String[] expected,
      DiagnosticType error, DiagnosticType warning) {
   Compiler compiler = createCompiler();
   lastCompiler = compiler;

   compiler.initModules(
	 externsInputs, Lists.newArrayList(modules), getOptions());
   test(compiler, expected, error, warning);
}

/**
   * Verifies that the compiler pass's JS output is the same as its input.
   *
   * @param js Input and output
   */
public void testSame(String js) {
   test(js, js);
}

/**
   * Verifies that the compiler pass's JS output is the same as its input
   * and (optionally) that an expected warning is issued.
   *
   * @param js Input and output
   * @param warning Expected warning, or null if no warning is expected
   */
public void testSame(String js, DiagnosticType warning) {
   test(js, js, null, warning);
}

/**
   * Verifies that the compiler pass's JS output is the same as its input
   * and (optionally) that an expected warning is issued.
   *
   * @param js Input and output
   * @param diag Expected error or warning, or null if none is expected
   * @param error true if diag is an error, false if it is a warning
   */
public void testSame(String js, DiagnosticType diag, boolean error) {
   if (error) {
      test(js, js, diag);
    } else {
       test(js, js, null, diag);
     }
}

/**
   * Verifies that the compiler pass's JS output is the same as its input
   * and (optionally) that an expected warning is issued.
   *
   * @param externs Externs input
   * @param js Input and output
   * @param warning Expected warning, or null if no warning is expected
   */
public void testSame(String externs, String js, DiagnosticType warning) {
   testSame(externs, js, warning, null);
}

/**
   * Verifies that the compiler pass's JS output is the same as its input
   * and (optionally) that an expected warning is issued.
   *
   * @param externs Externs input
   * @param js Input and output
   * @param diag Expected error or warning, or null if none is expected
   * @param error true if diag is an error, false if it is a warning
   */
public void testSame(
      String externs, String js, DiagnosticType diag, boolean error) {
   if (error) {
      test(externs, js, js, diag, null);
    } else {
       test(externs, js, js, null, diag);
     }
}

/**
   * Verifies that the compiler pass's JS output is the same as its input
   * and (optionally) that an expected warning and description is issued.
   *
   * @param externs Externs input
   * @param js Input and output
   * @param warning Expected warning, or null if no warning is expected
   * @param description The description of the expected warning,
   *	  or null if no warning is expected or if the warning's description
   *	  should not be examined
   */
public void testSame(String externs, String js, DiagnosticType warning,
      String description) {
   List<SourceFile> externsInputs = ImmutableList.of(
	 SourceFile.fromCode("externs", externs));
   test(externsInputs, js, js, null, warning, description);
}

/**
   * Verifies that the compiler pass's JS output is the same as its input.
   *
   * @param js Inputs and outputs
   */
public void testSame(String[] js) {
   test(js, js);
}

/**
   * Verifies that the compiler pass's JS output is the same as its input,
   * and emits the given error.
   *
   * @param js Inputs and outputs
   * @param error Expected error, or null if no error is expected
   */
public void testSame(String[] js, DiagnosticType error) {
   test(js, js, error);
}

/**
   * Verifies that the compiler pass's JS output is the same as its input,
   * and emits the given error and warning.
   *
   * @param js Inputs and outputs
   * @param error Expected error, or null if no error is expected
   * @param warning Expected warning, or null if no warning is expected
   */
public void testSame(
      String[] js, DiagnosticType error, DiagnosticType warning) {
   test(js, js, error, warning);
}

/**
   * Verifies that the compiler pass's JS output is the same as the input.
   *
   * @param modules Module inputs
   */
public void testSame(JSModule[] modules) {
   testSame(modules, null);
}

/**
   * Verifies that the compiler pass's JS output is the same as the input.
   *
   * @param modules Module inputs
   * @param warning A warning, or null for no expected warning.
   */
public void testSame(JSModule[] modules, DiagnosticType warning) {
   try {
      String[] expected = new String[modules.length];
      for (int i = 0; i < modules.length; i++) {
	 expected[i] = "";
	 for (CompilerInput input : modules[i].getInputs()) {
	    expected[i] += input.getSourceFile().getCode();
	  }
       }
      test(modules, expected, null, warning);
    } catch (IOException e) {
       throw new RuntimeException(e);
     }
}

/**
   * Verifies that the compiler pass's JS output matches the expected output
   * and (optionally) that an expected warning is issued. Or, if an error is
   * expected, this method just verifies that the error is encountered.
   *
   * @param compiler A compiler that has been initialized via
   *	 {@link Compiler#init}
   * @param expected Expected output, or null if an error is expected
   * @param error Expected error, or null if no error is expected
   * @param warning Expected warning, or null if no warning is expected
   */
protected void test(Compiler compiler, String[] expected,
      DiagnosticType error, DiagnosticType warning) {
   test(compiler, expected, error, warning, null);
}

/**
   * Verifies that the compiler pass's JS output matches the expected output
   * and (optionally) that an expected warning is issued. Or, if an error is
   * expected, this method just verifies that the error is encountered.
   *
   * @param compiler A compiler that has been initialized via
   *	 {@link Compiler#init}
   * @param expected Expected output, or null if an error is expected
   * @param error Expected error, or null if no error is expected
   * @param warning Expected warning, or null if no warning is expected
   * @param description The description of the expected warning,
   *	  or null if no warning is expected or if the warning's description
   *	  should not be examined
   */
private void test(Compiler compiler, String[] expected,
      DiagnosticType error, DiagnosticType warning,
      String description) {
   RecentChange recentChange = new RecentChange();
   compiler.addChangeHandler(recentChange);

   Node root = compiler.parseInputs();
   assert root != null;
   if (!expectParseWarningsThisTest) {
      assert compiler.getWarnings().length == 0;
    }

   if (astValidationEnabled) {
      (new AstValidator()).validateRoot(root);
    }
   Node externsRoot = root.getFirstChild();
   Node mainRoot = root.getLastChild();

   // Save the tree for later comparison.
   Node rootClone = root.cloneTree();
   Node externsRootClone = rootClone.getFirstChild();
   Node mainRootClone = rootClone.getLastChild();
   Map<Node, Node> mtoc = NodeUtil.mapMainToClone(mainRoot, mainRootClone);

   int numRepetitions = getNumRepetitions();
   ErrorManager[] errorManagers = new ErrorManager[numRepetitions];
   int aggregateWarningCount = 0;
   List<JSError> aggregateWarnings = Lists.newArrayList();
   boolean hasCodeChanged = false;

   assert !recentChange.hasCodeChanged();

   for (int i = 0; i < numRepetitions; ++i) {
      if (compiler.getErrorCount() == 0) {
	 errorManagers[i] = new BlackHoleErrorManager(compiler);
	
	 // Only run process closure primitives once, if asked.
	 if (closurePassEnabled && i == 0) {
	    recentChange.reset();
	    new ProcessClosurePrimitives(compiler, null, CheckLevel.ERROR)
	    .process(null, mainRoot);
	    hasCodeChanged = hasCodeChanged || recentChange.hasCodeChanged();
	  }
	
	 // Only run the type checking pass once, if asked.
	 // Running it twice can cause unpredictable behavior because duplicate
	 // objects for the same type are created, and the type system
	 // uses reference equality to compare many types.
	 if (!runTypeCheckAfterProcessing && typeCheckEnabled && i == 0) {
	    TypeCheck check = createTypeCheck(compiler, typeCheckLevel);
	    check.processForTesting(externsRoot, mainRoot);
	  }
	
	 // Only run the normalize pass once, if asked.
	 if (normalizeEnabled && i == 0) {
	    normalizeActualCode(compiler, externsRoot, mainRoot);
	  }
	
	 if (computeSideEffects && i == 0) {
	    PureFunctionIdentifier.Driver mark =
	       new PureFunctionIdentifier.Driver(compiler, null, false);
	    mark.process(externsRoot, mainRoot);
	  }
	
	 if (markNoSideEffects && i == 0) {
	    MarkNoSideEffectCalls mark = new MarkNoSideEffectCalls(compiler);
	    mark.process(externsRoot, mainRoot);
	  }
	
	 recentChange.reset();
	
	 getProcessor(compiler).process(externsRoot, mainRoot);
	 if (astValidationEnabled) {
	    (new AstValidator()).validateRoot(root);
	  }
	 if (checkLineNumbers) {
	    (new LineNumberCheck(compiler)).process(externsRoot, mainRoot);
	  }
	
	 if (runTypeCheckAfterProcessing && typeCheckEnabled && i == 0) {
	    TypeCheck check = createTypeCheck(compiler, typeCheckLevel);
	    check.processForTesting(externsRoot, mainRoot);
	  }
	
	 hasCodeChanged = hasCodeChanged || recentChange.hasCodeChanged();
	 aggregateWarningCount += errorManagers[i].getWarningCount();
	 aggregateWarnings.addAll(Lists.newArrayList(compiler.getWarnings()));
	
	 if (normalizeEnabled) {
	    boolean verifyDeclaredConstants = true;
	    new Normalize.VerifyConstants(compiler, verifyDeclaredConstants)
	    .process(externsRoot, mainRoot);
	  }
       }
    }

   if (error == null) {
      assert compiler.getErrorCount() == 0;
      // Verify the symbol table.
      ErrorManager symbolTableErrorManager =
	 new BlackHoleErrorManager(compiler);
      Node expectedRoot = null;
      if (expected != null) {
	 expectedRoot = parseExpectedJs(expected);
	 expectedRoot.detachFromParent();
       }

      JSError[] stErrors = symbolTableErrorManager.getErrors();
      if (expectedSymbolTableError != null) {
         assert stErrors.length == 1;
	 assert stErrors[0].getType().equals(expectedSymbolTableError);
       } else {
          assert stErrors.length == 0;
	}

      if (warning == null) {
         assert aggregateWarningCount == 0;
       } else {
          assert numRepetitions == aggregateWarningCount;
	  for (int i = 0; i < numRepetitions; ++i) {
	     JSError[] warnings = errorManagers[i].getWarnings();
	     JSError actual = warnings[0];
             assert warning.equals(actual.getType());
	
	     // Make sure that source information is always provided.
	     if (!allowSourcelessWarnings) {
                assert actual.sourceName != null && !actual.sourceName.isEmpty();
                assert actual.lineNumber != -1;
                assert actual.getCharno() != -1;
	      }
	
	     if (description != null) {
                assert description.equals(actual.description);
	      }
	   }
	}

      // If we ran normalize on the AST, we must also run normalize on the
      // clone before checking for changes.
      if (normalizeEnabled) {
	 normalizeActualCode(compiler, externsRootClone, mainRootClone);
       }

      boolean codeChange = !mainRootClone.isEquivalentTo(mainRoot);
      boolean externsChange = !externsRootClone.isEquivalentTo(externsRoot);

      // Generally, externs should not be changed by the compiler passes.
      if (externsChange && !allowExternsChanges) {
	 String explanation = externsRootClone.checkTreeEquals(externsRoot);
         throw new Error("Unexpected changes to externs" +
	       "\nExpected: " + compiler.toSource(externsRootClone) +
	       "\nResult: " + compiler.toSource(externsRoot) +
	       "\n" + explanation);
       }

      if (!codeChange && !externsChange) {
         assert !hasCodeChanged;
       } else {
          assert hasCodeChanged;
	}

      // Check correctness of the changed-scopes-only traversal
      NodeUtil.verifyScopeChanges(mtoc, mainRoot, false, compiler);

      if (expected != null) {
	 if (compareAsTree) {
	    String explanation = expectedRoot.checkTreeEquals(mainRoot);
            assert explanation == null;
	  } else if (expected != null) {
             assert Joiner.on("").join(expected).equals(compiler.toSource(mainRoot));
	   }
       }

      // Verify normalization is not invalidated.
      Node normalizeCheckRootClone = root.cloneTree();
      Node normalizeCheckExternsRootClone =
	 normalizeCheckRootClone.getFirstChild();
      Node normalizeCheckMainRootClone = normalizeCheckRootClone.getLastChild();
      new PrepareAst(compiler).process(
	    normalizeCheckExternsRootClone, normalizeCheckMainRootClone);
      String explanation =
	 normalizeCheckMainRootClone.checkTreeEquals(mainRoot);
      assert explanation == null;

      // TODO(johnlenz): enable this for most test cases.
      // Currently, this invalidates test for while-loops, for-loop
      // initializers, and other naming.  However, a set of code
      // (Closure primitive rewrites, etc) runs before the Normalize pass,
      // so this can't be force on everywhere.
      if (normalizeEnabled) {
	 new Normalize(compiler, true).process(
	       normalizeCheckExternsRootClone, normalizeCheckMainRootClone);
	 explanation =	normalizeCheckMainRootClone.checkTreeEquals(mainRoot);
         assert explanation == null;
       }
    } else {
       String errors = "";
       for (JSError actualError : compiler.getErrors()) {
	  errors += actualError.description + "\n";
	}
       assert compiler.getErrorCount() == 1;
       assert compiler.getErrors()[0].getType().equals(error);

       if (warning != null) {
	  String warnings = "";
	  for (JSError actualError : compiler.getWarnings()) {
	     warnings += actualError.description + "\n";
	   }
          assert compiler.getWarningCount() == 1;
          assert compiler.getWarnings()[0].getType().equals(warning);
	}
     }
}

private void normalizeActualCode(
      Compiler compiler, Node externsRoot, Node mainRoot) {
   Normalize normalize = new Normalize(compiler, false);
   normalize.process(externsRoot, mainRoot);
}

/**
   * Parses expected JS inputs and returns the root of the parse tree.
   */
protected Node parseExpectedJs(String[] expected) {
   Compiler compiler = createCompiler();
   List<SourceFile> inputs = Lists.newArrayList();
   for (int i = 0; i < expected.length; i++) {
      inputs.add(SourceFile.fromCode("expected" + i, expected[i]));
    }
   compiler.init(externsInputs, inputs, getOptions());
   Node root = compiler.parseInputs();
   assert root != null;
   Node externsRoot = root.getFirstChild();
   Node mainRoot = externsRoot.getNext();
   // Only run the normalize pass, if asked.
   if (normalizeEnabled && normalizeExpected && !compiler.hasErrors()) {
      Normalize normalize = new Normalize(compiler, false);
      normalize.process(externsRoot, mainRoot);
    }
   return mainRoot;
}

protected void testExternChanges(
      String input, String expectedExtern) {
   testExternChanges("", input, expectedExtern);
}

protected void testExternChanges(
      String extern, String input, String expectedExtern) {
   Compiler compiler = createCompiler();
   CompilerOptions options = getOptions();
   compiler.init(
	 ImmutableList.of(SourceFile.fromCode("extern", extern)),
	 ImmutableList.of(SourceFile.fromCode("input", input)),
	 options);
   compiler.parseInputs();
   assert !compiler.hasErrors();

   Node externsAndJs = compiler.getRoot();
   Node root = externsAndJs.getLastChild();

   Node externs = externsAndJs.getFirstChild();

   Node expected = compiler.parseTestCode(expectedExtern);
   assert !compiler.hasErrors();

   (getProcessor(compiler)).process(externs, root);

   String externsCode = compiler.toSource(externs);
   String expectedCode = compiler.toSource(expected);

   assert expectedCode.equals(externsCode);
}

protected Node parseExpectedJs(String expected) {
   return parseExpectedJs(new String[] {expected});
}

/**
   * Generates a list of modules from a list of inputs, such that each module
   * depends on the module before it.
   */
static JSModule[] createModuleChain(String... inputs) {
   JSModule[] modules = createModules(inputs);
   for (int i = 1; i < modules.length; i++) {
      modules[i].addDependency(modules[i - 1]);
    }
   return modules;
}

/**
   * Generates a list of modules from a list of inputs, such that each module
   * depends on the first module.
   */
static JSModule[] createModuleStar(String... inputs) {
   JSModule[] modules = createModules(inputs);
   for (int i = 1; i < modules.length; i++) {
      modules[i].addDependency(modules[0]);
    }
   return modules;
}

/**
   * Generates a list of modules from a list of inputs, such that modules
   * form a bush formation. In a bush formation, module 2 depends
   * on module 1, and all other modules depend on module 2.
   */
static JSModule[] createModuleBush(String ... inputs) {
   Preconditions.checkState(inputs.length > 2);
   JSModule[] modules = createModules(inputs);
   for (int i = 1; i < modules.length; i++) {
      modules[i].addDependency(modules[i == 1 ? 0 : 1]);
    }
   return modules;
}

/**
   * Generates a list of modules from a list of inputs, such that modules
   * form a tree formation. In a tree formation, module N depends on
   * module `floor(N/2)`, So the modules form a balanced binary tree.
   */
static JSModule[] createModuleTree(String ... inputs) {
   JSModule[] modules = createModules(inputs);
   for (int i = 1; i < modules.length; i++) {
      modules[i].addDependency(modules[(i - 1) / 2]);
    }
   return modules;
}

/**
   * Generates a list of modules from a list of inputs. Does not generate any
   * dependencies between the modules.
   */
static JSModule[] createModules(String... inputs) {
   JSModule[] modules = new JSModule[inputs.length];
   for (int i = 0; i < inputs.length; i++) {
      JSModule module = modules[i] = new JSModule("m" + i);
      module.add(SourceFile.fromCode("i" + i, inputs[i]));
    }
   return modules;
}

private static class BlackHoleErrorManager extends BasicErrorManager {
   private BlackHoleErrorManager(Compiler compiler) {
      compiler.setErrorManager(this);
    }

   @Override
   public void println(CheckLevel level, JSError error) {}
   
   @Override
   public void printSummary() {}
}


Compiler createCompiler() {
   Compiler compiler = new Compiler();
   return compiler;
}

protected void setExpectedSymbolTableError(DiagnosticType type) {
   this.expectedSymbolTableError = type;
}

/** Finds the first matching qualified name node in post-traversal order. */
protected final Node findQualifiedNameNode(final String name, Node root) {
   final List<Node> matches = Lists.newArrayList();
   NodeUtil.visitPostOrder(root,
	 new NodeUtil.Visitor() {
      @Override public void visit(Node n) {
	 if (name.equals(n.getQualifiedName())) {
	    matches.add(n);
	  }
       }
    },
    Predicates.<Node>alwaysTrue());
   return matches.get(0);
}

}	// end of class CompilerTestCode




/* end of CompilerTestCode.java */

