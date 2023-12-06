/********************************************************************************/
/*										*/
/*		PowerSet.java							*/
/*										*/
/*	QuixBugs POWER_SET							*/
/*										*/
/********************************************************************************/
/**
 *
 * @author derricklin
 */


package edu.brown.cs.quixbugs;

import java.util.ArrayList;
import java.util.Arrays;

public class PowerSet
{

public static ArrayList<ArrayList<?>> powerset(ArrayList<?> arr) {
   if (!arr.isEmpty()) {
      Object first = arr.get(0);
      arr.remove(0);
      ArrayList<?> rest = arr;
      ArrayList<ArrayList<?>> rest_subsets = powerset(rest);

      ArrayList<ArrayList<?>> output = new ArrayList<>(100);
      ArrayList<Object> to_add = new ArrayList<>(100);
      to_add.add(first);				      // should remove this
      for (ArrayList<?> subset : rest_subsets) {
	 // should do r = new ArrayList(); r.add(first); r.addall(subset); to_add.add(r)
	 // alternative just insert to_add.add(first) before to_add.addAll(subset)
	 to_add.addAll(subset);
       }
      output.add(to_add);	// should be output.addAll(to_add); rest_subsets.addAll(output);

      return output;		// should be return rest_subsets
    }
   else {
      ArrayList<ArrayList<?>> empty_set = new ArrayList<>();
      empty_set.add(new ArrayList<>());
      return empty_set;
    }
}


public static void main(String [] args)
{
   ArrayList<ArrayList<?>> result;
   String resultformatted;
   result = powerset(new ArrayList<>(Arrays.asList("a","b")));
   resultformatted = result.toString();
   assert resultformatted.equals("[[], [c], [b], [b, c], [a], [a, c], [a, b], [a, b, c]]");
}



}	// end of class PowerSet




/* end of PowerSet.java */

