/********************************************************************************/
/*                                                                              */
/*              BugMockito26.java                                               */
/*                                                                              */
/*      Defects4J bug Mockito_26                                                */
/*                                                                              */
/********************************************************************************/



package edu.brown.cs.d4jspr;

import org.mockito.internal.progress.HandyReturnValues;

public class BugMockito26 implements BugConstants
{

public static void main(String [] args)
{
   testMockito26();
}


public static void testMockito26()
{
   HandyReturnValues h = new HandyReturnValues();
   
   double d = (Double) h.returnFor(double.class);
   
   assert d == 0.0d;
}

}       // end of class BugMockito26




/* end of BugMockito26.java */

