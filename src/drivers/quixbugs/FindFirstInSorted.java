/********************************************************************************/
/*                                                                              */
/*              FindFirstInSorted.java                                          */
/*                                                                              */
/*      QuixBugs FIND_FIRST_IN_SORTED                                           */
/*                                                                              */
/********************************************************************************/
/**
 *
 * @author derricklin
 */

package edu.brown.cs.quixbugs;



public class FindFirstInSorted
{

public static int find_first_in_sorted(int[] arr, int x) {
   int lo = 0;
   int hi = arr.length;
   
   while (lo <= hi) {                   // should be <
      int mid = (lo + hi) / 2; // check if this is floor division
      
      if (x == arr[mid] && (mid == 0 || x != arr[mid-1])) {
         return mid;
       } else if (x <= arr[mid]) {
          hi = mid;
        } else {
           lo = mid + 1;
         }
    }
   
   return -1;
}


public static void main(String [] args)
{
   int result;
   result = find_first_in_sorted(new int[]{3,4,5,5,5,5,6},(int)5);
   org.junit.Assert.assertEquals( (int) 2, result);
   result = find_first_in_sorted(new int[]{3,4,5,5,5,5,6},(int)7);
   org.junit.Assert.assertEquals( (int) -1, result);
}


}       // end of class FindFirstInSorted




/* end of FindFirstInSorted.java */

