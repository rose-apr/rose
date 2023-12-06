/********************************************************************************/
/*                                                                              */
/*              BugChart01.java                                                 */
/*                                                                              */
/*      Defects4J bug Chart_1                                                   */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */


package edu.brown.cs.d4jspr;

import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.AbstractCategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class BugChart01 implements BugConstants
{


public static void main(String [] args)
{
   testChart01();
}



public static void testChart01()
{
   AbstractCategoryItemRenderer r = new LineAndShapeRenderer();
   DefaultCategoryDataset dataset = new DefaultCategoryDataset();
   CategoryPlot plot = new CategoryPlot();
   plot.setDataset(dataset);
   plot.setRenderer(r);
   dataset.addValue(1.0, "S1", "C1");
   LegendItemCollection lic = r.getLegendItems();
   assert lic.getItemCount() == 1;
   assert lic.get(0).getLabel().equals("S1");
}



}       // end of class BugChart01




/* end of BugChart01.java */

