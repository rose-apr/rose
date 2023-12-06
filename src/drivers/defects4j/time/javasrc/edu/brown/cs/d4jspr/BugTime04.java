/********************************************************************************/
/*                                                                              */
/*              BugTime04.java                                                  */
/*                                                                              */
/*      Defects4J bug Time_4                                                    */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */


package edu.brown.cs.d4jspr;

import org.joda.time.Chronology;
import org.joda.time.DateTimeFieldType;
import org.joda.time.Partial;
import org.joda.time.chrono.ISOChronology;

public class BugTime04 implements BugConstants
{


private static final Chronology ISO_UTC = ISOChronology.getInstanceUTC();

public static void main(String [] args)
{
   testTime04();
}


public static void testTime04()
{
   Partial test = createHourMinPartial(10,20,ISO_UTC);
   try {
      Partial test1 = test.with(DateTimeFieldType.clockhourOfDay(), 6);
      System.err.println("Shouldn't be here " + test1);
    } catch (IllegalArgumentException ex) {}
    assert 10 == test.get(DateTimeFieldType.hourOfDay());
    assert 20 == test.get(DateTimeFieldType.minuteOfHour());
}


private static Partial createHourMinPartial(int h,int m,Chronology c)
{
   return new Partial(
         new DateTimeFieldType[] { DateTimeFieldType.hourOfDay(),
               DateTimeFieldType.minuteOfHour() },
               new int[] { h,m },
               c);
}



}       // end of class BugTime04




/* end of BugTime04.java */

