/********************************************************************************/
/*                                                                              */
/*              Flatten.java                                                    */
/*                                                                              */
/*      QuixBugs: FLATTEN                                                       */
/*                                                                              */
/********************************************************************************/
/**
 *
 * @author derricklin
 */

package edu.brown.cs.quixbugs;

import java.util.ArrayList;
public class Flatten
{

@SuppressWarnings({ "rawtypes", "unchecked" })
public static Object flatten(Object arr) {
   if (arr instanceof ArrayList) {
      ArrayList narr = (ArrayList) arr;
      ArrayList result = new ArrayList(50);
      for (Object x : narr) {
         if (x instanceof ArrayList) {
            result.addAll((ArrayList) flatten(x));
          } 
         else {
            result.add(flatten(x));            // should be result.add(x)
          }
       }
      return result;
    } 
   else {
      return flatten(arr);
    }
}


public static void main(String [] args)
{
   Object result;
   String resultFormatted;
   
   result = flatten(new java.util.ArrayList<>(java.util.Arrays.asList(new java.util.ArrayList<>(java.util.Arrays.asList(1, 
         new java.util.ArrayList<>(java.util.Arrays.asList()), new java.util.ArrayList<>(java.util.Arrays.asList(2, 3)))), 
         new java.util.ArrayList<>(java.util.Arrays.asList(new java.util.ArrayList<>(java.util.Arrays.asList(4)))), 5)));
   resultFormatted = result.toString();
   assert resultFormatted.equals("[1, 2, 3, 4, 5]");
   
}



}       // end of class Flatten




/* end of Flatten.java */

