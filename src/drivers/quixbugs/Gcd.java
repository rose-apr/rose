/********************************************************************************/
/*                                                                              */
/*              Gcd.java                                                        */
/*                                                                              */
/*      QuixBugs GCD                                                            */
/*                                                                              */
/********************************************************************************/
/**
 *
 * @author derricklin
 */


package edu.brown.cs.quixbugs;



public class Gcd
{

public static int gcd(int a, int b) {
   if (b == 0) {
      return a;
    } 
   else {
      return gcd(a % b, b);             // should be b, a%b
    }
}


public static void main(String [] args)
{
   int result;
   
   result = gcd(37,600);
   assert result == 1;
   
   result = gcd(20,100);
   assert result == 20;
}


}       // end of class Gcd




/* end of Gcd.java */

