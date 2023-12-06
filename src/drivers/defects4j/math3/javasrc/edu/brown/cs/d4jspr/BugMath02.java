/********************************************************************************/
/*										*/
/*		BugMath02.java							*/
/*										*/
/*	description of class							*/
/*										*/
/********************************************************************************/
/*	Copyright 2011 Brown University -- Steven P. Reiss		      */




package edu.brown.cs.d4jspr;

import org.apache.commons.math3.distribution.HypergeometricDistribution;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937a;

public class BugMath02 implements BugConstants
{


public static void main(String [] args)
{
   testMath02();
}


public static void testMath02()
{
   final int N = 43130568;
   final int m = 42976365;
   final int n = 50;
   RandomGenerator rgen = new Well19937a(37);
   final HypergeometricDistribution dist = new HypergeometricDistribution(rgen,N, m, n);

   for (int i = 0; i < 5; i++) {
      final int sample = dist.sample();
      assert sample >= 0 && sample <= n;
    }
}


}	// end of class BugMath02




/* end of BugMath02.java */

