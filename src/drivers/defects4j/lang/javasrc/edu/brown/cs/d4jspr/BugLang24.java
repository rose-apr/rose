/********************************************************************************/
/*                                                                              */
/*              BugLang24.java                                                  */
/*                                                                              */
/*      Defects4J bug Lang_24                                                   */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */


package edu.brown.cs.d4jspr;

import org.apache.commons.lang3.math.NumberUtils;

public class BugLang24 implements BugConstants
{

public static void main(String [] args)
{
   testLang24();
}



public static void testLang24()
{
   assert NumberUtils.isNumber("1234L");
   assert !NumberUtils.isNumber("1.1L");
}



}       // end of class BugLang24




/* end of BugLang24.java */

