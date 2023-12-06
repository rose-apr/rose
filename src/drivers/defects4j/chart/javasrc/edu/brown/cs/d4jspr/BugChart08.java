/********************************************************************************/
/*                                                                              */
/*              BugChart08.java                                                 */
/*                                                                              */
/*      Defects4J bug Chart_8                                                   */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */



package edu.brown.cs.d4jspr;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import org.jfree.data.time.Week;

public class BugChart08 implements BugConstants
{


public static void main(String [] args)
{
   testChart08();
}



public static void testChart08() 
{
   GregorianCalendar cal =  (GregorianCalendar) Calendar.getInstance(TimeZone.getDefault());
   cal.set(2007, Calendar.AUGUST, 26, 1, 0, 0);
   cal.set(Calendar.MILLISECOND, 0);
   Date t = cal.getTime();
   Week w = new Week(t, TimeZone.getTimeZone("Europe/Copenhagen"));
   assert w.getWeek() == 35;
   Week w1 = new Week(t,TimeZone.getTimeZone("Europe/Copenhagen"),
         new Locale("da","DK"));
   assert w1.getWeek() == 34;
}




}       // end of class BugChart08




/* end of BugChart08.java */

