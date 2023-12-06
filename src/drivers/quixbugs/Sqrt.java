/********************************************************************************/
/*										*/
/*		Sqrt.java							*/
/*										*/
/*	QuixBugs SQRT								*/
/*										*/
/********************************************************************************/
/**
 *
 * @author derricklin
 */


package edu.brown.cs.quixbugs;



public class Sqrt
{

public static double sqrt(double x, double epsilon) {
   double approx = x / 2f;
   while (Math.abs(x-approx) > epsilon) {		// x-approx*approx
      approx = 0.5f * (approx + x / approx);
    }
   return approx;
}

public static void main(String [] args)
{
   double result = sqrt(2,0.01);
   double diff = Math.abs(result-1.4166666666666665);
   assert diff < 0.01;
}

}	// end of class Sqrt




/* end of Sqrt.java */
































































































