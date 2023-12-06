/********************************************************************************/
/*                                                                              */
/*              ToBase.java                                                     */
/*                                                                              */
/*      QuixBugs: TO_BASE                                                       */
/*                                                                              */
/********************************************************************************/
/**
 *
 * @author derricklin
 */

package edu.brown.cs.quixbugs;



public class ToBase
{
public static String to_base(int num, int b) {
   String result = "";
   String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   int i;
   while (num > 0) {
      i = num % b;
      num = num / b; // floor division?
      result = result + String.valueOf(alphabet.charAt(i));     // result on right, not left
    }
   
   return result;
}



public static void main(String [] args)
{
   String result = to_base(31,16);
   assert result.equals("1F");
}



}       // end of class ToBase




/* end of ToBase.java */

