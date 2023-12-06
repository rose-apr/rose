/********************************************************************************/
/*                                                                              */
/*              BugChart24.java                                                 */
/*                                                                              */
/*      Defects4J bug Chart_24                                                  */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */


package edu.brown.cs.d4jspr;

import java.awt.Color;

import org.jfree.chart.renderer.GrayPaintScale;

public class BugChart24 implements BugConstants
{

public static void main(String [] args)
{
   testChart24();
}



public static void testChart24() 
{
   GrayPaintScale gps = new GrayPaintScale();
   Color c = (Color) gps.getPaint(-0.5);
}





}       // end of class BugChart24




/* end of BugChart24.java */

