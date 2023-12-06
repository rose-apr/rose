/********************************************************************************/
/*                                                                              */
/*              BugLang59.java                                                  */
/*                                                                              */
/*      Defects4J bug Lang_59                                                   */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */


package edu.brown.cs.d4jspr;

import org.apache.commons.lang3.text.StrBuilder;

public class BugLang59 implements BugConstants
{


public static void main(String [] args)
{
   testLang59();
}



public static void testLang59()
{
   StrBuilder sb = new StrBuilder(1);
   sb.appendFixedWidthPadRight("foo", 1, '-');
   assert sb.toString().equals("f");
}



}       // end of class BugLang59




/* end of BugLang59.java */

