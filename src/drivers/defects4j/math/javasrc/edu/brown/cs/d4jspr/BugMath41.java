/********************************************************************************/
/*										*/
/*		BugMath41.java							*/
/*										*/
/*	Defects4J bug Math_41							*/
/*										*/
/********************************************************************************/
/*	Copyright 2011 Brown University -- Steven P. Reiss		      */




package edu.brown.cs.d4jspr;

import org.apache.commons.math.stat.descriptive.UnivariateStatistic;
import org.apache.commons.math.stat.descriptive.WeightedEvaluation;
import org.apache.commons.math.stat.descriptive.moment.Variance;

public class BugMath41 implements BugConstants
{

protected static double[] testArray =
   { 12.5, 12.0, 11.8, 14.2, 14.9, 14.5, 21.0,  8.2, 10.3, 11.3,
      14.1,  9.9, 12.2, 12.0, 12.1, 11.0, 19.8, 11.0, 10.0,  8.8,
      9.0, 12.3 };

protected static double[] testWeightsArray =
   {  1.5,  0.8,  1.2,  0.4,  0.8,  1.8,  1.2,  1.1,  1.0,  0.7,
      1.3,  0.6,  0.7,  1.3,  0.7,  1.0,  0.4,  0.1,  1.4,  0.9,
      1.1,  0.3 };


public static void main(String [] args)
{
   testMath41();
}


public static void testMath41()
{
    // See if this statistic computes weighted statistics
    // If not, skip this test
    UnivariateStatistic statistic = new Variance();
    if (!(statistic instanceof WeightedEvaluation)) {
        return;
     }
    final WeightedEvaluation stat = (WeightedEvaluation) new Variance();
    final double[] arrayZero = new double[5];
    final double[] weightZero = new double[5];
    System.arraycopy(testArray, 0, arrayZero, 0, 5);
    System.arraycopy(testWeightsArray, 0, weightZero, 0, 5);
    double v0 = stat.evaluate(arrayZero, weightZero);
    double v1 = stat.evaluate(testArray, testWeightsArray, 0, 5);
    assert v0 == v1;
}


}	// end of class BugMath41




/* end of BugMath41.java */

