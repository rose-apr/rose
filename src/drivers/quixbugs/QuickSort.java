/********************************************************************************/
/*                                                                              */
/*              QuickSort.java                                                  */
/*                                                                              */
/*      QuixBugs QUICKSORT                                                      */
/*                                                                              */
/********************************************************************************/
/**
 *
 * @author derricklin
 */


package edu.brown.cs.quixbugs;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort
{

public static ArrayList<Integer> quicksort(ArrayList<Integer> arr) {
   if (arr.isEmpty()) {
      return new ArrayList<Integer>();
    }
   
   Integer pivot = arr.get(0);
   ArrayList<Integer> lesser = new ArrayList<Integer>();
   ArrayList<Integer> greater = new ArrayList<Integer>();
   
   for (Integer x : arr.subList(1, arr.size())) {
      if (x < pivot) {
         lesser.add(x);
       } 
      else if (x > pivot) {                  // >=
         greater.add(x);
       }
    }
   ArrayList<Integer> middle = new ArrayList<Integer>();
   middle.add(pivot);
   lesser = quicksort(lesser);
   greater = quicksort(greater);
   middle.addAll(greater);
   lesser.addAll(middle);
   return lesser;
}



public static void main(String [] args)
{
   ArrayList<Integer> result;
   String out;
   
   result = quicksort(new ArrayList<>(Arrays.asList(3,1,4,1,5,9,2,6,5,3,5,8,9,7,9,3)));
   out = result.toString();
   assert out.equals("[1, 1, 2, 3, 3, 3, 4, 5, 5, 5, 6, 7, 8, 9, 9, 9]");
} 


}       // end of class QuickSort




/* end of QuickSort.java */

