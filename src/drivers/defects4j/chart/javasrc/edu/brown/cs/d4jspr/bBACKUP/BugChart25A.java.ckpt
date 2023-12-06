/********************************************************************************/
/*                                                                              */
/*              BugChart25A.java                                                */
/*                                                                              */
/*      First chunk of Defects4j Bug Chart 25                                                 */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */
/*********************************************************************************
 *  Copyright 2011, Brown University, Providence, RI.                            *
 *                                                                               *
 *                        All Rights Reserved                                    *
 *                                                                               *
 * This program and the accompanying materials are made available under the      *
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, *
 * and is available at                                                           *
 *      http://www.eclipse.org/legal/epl-v10.html                                *
 *                                                                               *
 ********************************************************************************/

/* SVN: $Id$ */



package edu.brown.cs.d4jspr;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.StatisticalBarRenderer;
import org.jfree.data.statistics.DefaultStatisticalCategoryDataset;

public class BugChart25A implements BugConstants
{


public static void main(String [] args)
{
   testChart25();
}



public static void testChart25() 
{
   DefaultStatisticalCategoryDataset dataset
      = new DefaultStatisticalCategoryDataset();
   dataset.add(1.0, 2.0, "S1", "C1");
   dataset.add(null, Double.valueOf(4.0), "S1", "C2");
   CategoryPlot plot = new CategoryPlot(dataset,
         new CategoryAxis("Category"), new NumberAxis("Value"),
         new StatisticalBarRenderer());
   plot.setOrientation(PlotOrientation.HORIZONTAL);
   JFreeChart chart = new JFreeChart(plot);
   /* BufferedImage image = */ chart.createBufferedImage(300, 200,null);
}




}       // end of class BugChart25A




/* end of BugChart25A.java */

