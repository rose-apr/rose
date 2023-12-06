/********************************************************************************/
/*                                                                              */
/*              BugLang61.java                                                  */
/*                                                                              */
/*      Defects4J bug Lang_61                                                   */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */



package edu.brown.cs.d4jspr;

import org.apache.commons.lang3.text.StrBuilder;

public class BugLang61 implements BugConstants
{

public static void main(String [] args)
{
   testLang61();
}



public static void testLang61()
{
   StrBuilder sb = new StrBuilder("onetwothree");
   sb.deleteFirst("three");
   assert sb.indexOf("three") == -1;
   
   StrBuilder sb1 = new StrBuilder("\n%BLAH%\nDo more stuff\neven more stuff\n%BLAH%\n");
   sb1.deleteAll("\n%BLAH%");
   assert sb1.toString().equals("\nDo more stuff\neven more stuff\n");
}




}       // end of class BugLang61




/* end of BugLang61.java */

