/********************************************************************************/
/*                                                                              */
/*              BugChart11.java                                                 */
/*                                                                              */
/*      Defects4J Bug Chart_11                                                  */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */

package edu.brown.cs.d4jspr;

import java.awt.geom.GeneralPath;

import org.jfree.chart.util.ShapeUtilities;

public class BugChart11 implements BugConstants
{


public static void main(String [] args)
{
   testChart11();
}



public static void testChart11()
{
   GeneralPath g1 = new GeneralPath();
   g1.moveTo(1.0f, 2.0f);
   g1.lineTo(3.0f, 4.0f);
   g1.curveTo(5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f);
   g1.quadTo(1.0f, 2.0f, 3.0f, 4.0f);
   g1.closePath();
   GeneralPath g2 = new GeneralPath();
   g2.moveTo(1.0f, 2.0f);
   g2.lineTo(3.0f, 4.0f);
   g2.curveTo(5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f);
   g2.quadTo(1.0f, 2.0f, 3.0f, 4.0f);
   g2.closePath();
   assert ShapeUtilities.equal(g1,g2);
   
   GeneralPath g3 = new GeneralPath();
   g3.moveTo(11.0f, 22.0f);
   g3.lineTo(3.0f, 4.0f);
   g3.curveTo(5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f);
   g3.quadTo(1.0f, 2.0f, 3.0f, 4.0f);
   g3.closePath();
   assert !ShapeUtilities.equal(g1,g3);
}





}       // end of class BugChart11




/* end of BugChart11.java */

