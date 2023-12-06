/********************************************************************************/
/*                                                                              */
/*              BugMockito38.java                                               */
/*                                                                              */
/*      Defects4J bug Mockito_38                                                */
/*                                                                              */
/********************************************************************************/


package edu.brown.cs.d4jspr;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matcher;
import org.mockito.internal.matchers.Equals;
import org.mockito.internal.verification.argumentmatching.ArgumentMatchingTool;

public class BugMockito38 implements BugConstants
{

public static void main(String [] args)
{
   testMockito38();
}


public static void testMockito38()
{
   ArgumentMatchingTool tool = new ArgumentMatchingTool();
   List<Matcher> matchers = new ArrayList<>();
   matchers.add(new Equals(20));
   
   Integer[] suspicious = tool.getSuspiciouslyNotMatchingArgsIndexes(matchers, 
         new Object[] {null});
   
   assert suspicious.length == 0;
   
}

}       // end of class BugMockito38




/* end of BugMockito38.java */

