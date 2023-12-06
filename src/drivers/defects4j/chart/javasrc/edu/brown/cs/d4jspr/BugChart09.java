/********************************************************************************/
/*                                                                              */
/*              BugChart09.java                                                 */
/*                                                                              */
/*      description of class                                                    */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */



package edu.brown.cs.d4jspr;

import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;

public class BugChart09 implements BugConstants
{



public static void main(String [] args)
{
   testChart09();
}



public static void testChart09() 
{
   TimeSeries s = new TimeSeries("S");
   s.add(new Day(19, 8, 2005), 1);
   s.add(new Day(31, 1, 2006), 1);
   try {
      s.createCopy(new Day(1, 12, 2005), new Day(18, 1, 2006));
    }
   catch (CloneNotSupportedException e) {
      throw new Error(e);
    }
}




}       // end of class BugChart09




/* end of BugChart09.java */

