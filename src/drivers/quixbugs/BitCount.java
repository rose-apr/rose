/********************************************************************************/
/*                                                                              */
/*              BitCount.java                                                   */
/*                                                                              */
/*      description of class                                                    */
/*                                                                              */
/********************************************************************************/

/**
 *
 * @author derricklin
 */

package edu.brown.cs.quixbugs;



public class BitCount
{

public static int bitcount(int n) 
{
   int count = 0;
   while (n != 0) {
      n = (n ^ (n - 1));
      count++;
      // BREAK ON AssertionError
      // PROBLEM: AssertionError
      assert count <= 64;
    }
   return count;
}


public static void main(String [] args) 
{
   // FIRST STOP IS CORRECT
   int btc = bitcount(3005);
   assert btc == 9;
}


}       // end of class BitCount




/* end of BitCount.java */

