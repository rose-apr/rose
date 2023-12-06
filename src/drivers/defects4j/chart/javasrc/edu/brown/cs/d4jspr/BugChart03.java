/********************************************************************************/
/*                                                                              */
/*              BugChart03.java                                                 */
/*                                                                              */
/*      description of class                                                    */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */

package edu.brown.cs.d4jspr;

import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.Year;

public class BugChart03 implements BugConstants
{

public static void main(String [] args)
{
   testChart03();
}



public static void testChart03()
{
   TimeSeries s1 = new TimeSeries("S1");
   s1.add(new Year(2009), 100.0);
   s1.add(new Year(2010), 101.0);
   s1.add(new Year(2011), 102.0);
   try {
      TimeSeries s2 = s1.createCopy(0, 1);
      assert s2.getMinY() == 100.0;
      assert s2.getMaxY() == 101.0;
    }
   catch (CloneNotSupportedException e) { }
}




}       // end of class BugChart03




/* end of BugChart03.java */

