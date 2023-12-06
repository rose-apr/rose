/********************************************************************************/
/*                                                                              */
/*              BugTime16.java                                                  */
/*                                                                              */
/*      Defects4J bug Time_16                                                   */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */

package edu.brown.cs.d4jspr;

import java.util.Locale;

import org.joda.time.DateTimeZone;
import org.joda.time.MutableDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class BugTime16 implements BugConstants
{

private static final DateTimeZone LONDON = DateTimeZone.forID("Europe/London");
private static final DateTimeZone TOKYO = DateTimeZone.forID("Asia/Tokyo");

public static void main(String [] args)
{
   DateTimeFormatter f = DateTimeFormat.forPattern("M").withLocale(Locale.UK);
   MutableDateTime result = new MutableDateTime(2004, 1, 9, 12, 20, 30, 0, LONDON);
   testTime16(f,result);
}


public static void testTime16(DateTimeFormatter f,MutableDateTime result)
{
   assert f.parseInto(result,"5",0) == 1;
   MutableDateTime nr = new MutableDateTime(2004, 5, 9, 12, 20, 30, 0, LONDON);
   assert nr.equals(result);
  
   MutableDateTime result1 = new MutableDateTime(2004, 12, 31, 12, 20, 30, 0, TOKYO);
   assert f.parseInto(result1,"5",0) == 1;
   MutableDateTime nr1 = new MutableDateTime(2004, 5, 31, 12, 20, 30, 0, TOKYO);
   assert nr1.equals(result);
}

}       // end of class BugTime16




/* end of BugTime16.java */

