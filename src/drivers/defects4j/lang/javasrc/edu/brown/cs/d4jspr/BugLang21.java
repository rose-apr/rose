/********************************************************************************/
/*                                                                              */
/*              BugLang21.java                                                  */
/*                                                                              */
/*      Defects4J Bug Lang_21                                                   */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */

package edu.brown.cs.d4jspr;

import java.util.Calendar;

import org.apache.commons.lang3.time.DateUtils;

public class BugLang21 implements BugConstants
{


public static void main(String [] args)
{
   testLang21();
}



public static void testLang21()
{
   Calendar cal3 = Calendar.getInstance();
   Calendar cal4 = Calendar.getInstance();
   cal3.set(2004, 6, 9, 4,  0, 0);
   cal4.set(2004, 6, 9, 16, 0, 0);
   cal3.set(Calendar.MILLISECOND, 0);
   cal4.set(Calendar.MILLISECOND, 0);
   assert DateUtils.isSameLocalTime(cal3,cal3);
   assert !DateUtils.isSameLocalTime(cal3,cal4);
}


}       // end of class BugLang21




/* end of BugLang21.java */

