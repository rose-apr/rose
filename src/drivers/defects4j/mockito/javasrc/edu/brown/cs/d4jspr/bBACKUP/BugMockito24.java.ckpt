/********************************************************************************/
/*                                                                              */
/*              BugMockito24.java                                               */
/*                                                                              */
/*      Defects4J bug Mockito_24                                                */
/*                                                                              */
/********************************************************************************/


package edu.brown.cs.d4jspr;

import static org.mockito.Mockito.mock;

import java.util.Date;

import org.mockito.internal.MockitoCore;
import org.mockito.internal.stubbing.defaultanswers.ReturnsEmptyValues;
import org.mockito.invocation.Invocation;



public class BugMockito24 implements BugConstants
{

public static void main(String [] args)
{
   testMockito24();
}


public static void testMockito24()
{
   Date d = mock(Date.class);
   d.compareTo(d);
   Invocation compareTo = new MockitoCore().getLastInvocation();
   ReturnsEmptyValues values = new ReturnsEmptyValues();
   
   //when
   Object result = values.answer(compareTo);
   
   //then
   assert result.equals(0);
}

}       // end of class BugMockito24




/* end of BugMockito24.java */

