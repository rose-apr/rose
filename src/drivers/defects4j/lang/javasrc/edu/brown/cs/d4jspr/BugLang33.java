/********************************************************************************/
/*                                                                              */
/*              BugLang33.java                                                  */
/*                                                                              */
/*      Defects4J bug Lang_33                                                   */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */



package edu.brown.cs.d4jspr;

import org.apache.commons.lang3.ClassUtils;

public class BugLang33 implements BugConstants
{

public static void main(String [] args)
{
   testLang33();
}



public static void testLang33()
{
   Class<?> [] rslt = ClassUtils.toClass(new Object[] { "Test", null, 99d });
   assert rslt[0] == String.class;
   assert rslt[1] == null;
   assert rslt[2] == Double.class;
}




}       // end of class BugLang33




/* end of BugLang33.java */

