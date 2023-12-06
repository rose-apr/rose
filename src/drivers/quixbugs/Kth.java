/********************************************************************************/
/*										*/
/*		Kth.java							*/
/*										*/
/*	QuixBugs KTH example							*/
/*										*/
/********************************************************************************/



package edu.brown.cs.quixbugs;

import java.util.ArrayList;
import java.util.Arrays;

public class Kth
{

public static int kth(ArrayList<Integer> arr, int k) {
   int pivot = arr.get(0);
   ArrayList<Integer> below, above;
   below = new ArrayList<Integer>(arr.size());
   above = new ArrayList<Integer>(arr.size());
   for (Integer x : arr) {
      if (x < pivot) {
	 below.add(x);
       }
      else if (x > pivot) {
	 above.add(x);
       }
    }

   int num_less = below.size();
   int num_lessoreq = arr.size() - above.size();
   if (k < num_less) {
      return kth(below, k);
    }		
   else if (k >= num_lessoreq) {
      return kth(above, k);		// k => k-num_lessoreq
    }
   else {
      return pivot;
    }
}



public static void main(String [] args)
{
   int result;
   result = kth(new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7)),4);
   assert result == 5;

   result = kth(new ArrayList<>(Arrays.asList(3,6,7,1,6,3,8,9)),5);
   assert result == 7;
}



}	// end of class Kth




/* end of Kth.java */
