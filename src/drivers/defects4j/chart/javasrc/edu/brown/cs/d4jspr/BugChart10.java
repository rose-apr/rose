/********************************************************************************/
/*                                                                              */
/*              BugChart10.java                                                 */
/*                                                                              */
/*      Defects4J Bug Chart_10                                                  */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */



package edu.brown.cs.d4jspr;

import org.jfree.chart.imagemap.StandardToolTipTagFragmentGenerator;

public class BugChart10 implements BugConstants
{

public static void main(String [] args)
{
   testChart10();
}



public static void testChart10() 
{
   StandardToolTipTagFragmentGenerator g = new StandardToolTipTagFragmentGenerator();
   String s1 = g.generateToolTipFragment("Series \"A\", 100.0");
   assert s1.equals(" title=\"Series &quot;A&quot;, 100.0\" alt=\"\"");
}





}       // end of class BugChart10




/* end of BugChart10.java */

