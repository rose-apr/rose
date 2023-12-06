/********************************************************************************/
/*                                                                              */
/*              BugChart20.java                                                 */
/*                                                                              */
/*      Defects4J bug Chart_20                                                  */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */


package edu.brown.cs.d4jspr;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;

import org.jfree.chart.plot.ValueMarker;

public class BugChart20 implements BugConstants
{


public static void main(String [] args)
{
   testChart20();
}



public static void testChart20()
{
   Stroke stroke = new BasicStroke(1.0f);
   Stroke outlineStroke = new BasicStroke(2.0f);
   ValueMarker m = new ValueMarker(1.0, Color.red, stroke, Color.blue,
         outlineStroke, 0.5f);
   assert m.getValue() == 1.0;
   assert m.getPaint() == Color.RED;
   assert stroke == m.getStroke();
   assert m.getOutlinePaint() == Color.BLUE;
   assert m.getOutlineStroke() == outlineStroke;
   assert m.getAlpha() == 0.5;
}





}       // end of class BugChart20




/* end of BugChart20.java */

