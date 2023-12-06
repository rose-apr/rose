/********************************************************************************/
/*                                                                              */
/*              BugTime19.java                                                  */
/*                                                                              */
/*      Defects4J bug Time_19                                                   */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */


package edu.brown.cs.d4jspr;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class BugTime19 implements BugConstants
{



public static void main(String [] args)
{
   testTime19();
}


public static void testTime19()
{
   DateTimeZone zone = DateTimeZone.forID("Europe/London");
   DateTime base = new DateTime(2011, 10, 30, 1, 15, zone);
   assert base.toString().equals("2011-10-30T01:15:00.000+01:00");
   assert base.plusHours(1).toString().equals("2011-10-30T01:15:00.000Z");
}

}       // end of class BugTime19




/* end of BugTime19.java */

