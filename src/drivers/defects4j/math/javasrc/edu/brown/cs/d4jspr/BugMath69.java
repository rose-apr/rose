/********************************************************************************/
/*                                                                              */
/*              BugMath69.java                                                  */
/*                                                                              */
/*      Defects4J bug Math_69                                                   */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */


package edu.brown.cs.d4jspr;

import org.apache.commons.math.stat.correlation.PearsonsCorrelation;

public class BugMath69 implements BugConstants
{



public static void main(String [] args)
{
   testMath69();
}


public static void testMath69()
{
   /*
         * Create a dataset that has r -> 1, p -> 0 as dimension increases.
         * Prior to the fix for MATH-371, p vanished for dimension >= 14.
         * Post fix, p-values diminish smoothly, vanishing at dimension = 127.
         * Tested value is ~1E-303.
         */
   int dimension = 120;
   double[][] data = new double[dimension][2];
   for (int i = 0; i < dimension; i++) {
      data[i][0] = i;
      data[i][1] = i + 1/((double)i + 1);
    }
   PearsonsCorrelation corrInstance = new PearsonsCorrelation(data);
   try {
      double v = corrInstance.getCorrelationPValues().getEntry(0, 1);
      assert v > 0 && v < 0.00000001;
    }
   catch (Exception e) {
       throw new  Error(e);
    }
}



}       // end of class BugMath69




/* end of BugMath69.java */

