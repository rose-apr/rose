/********************************************************************************/
/*                                                                              */
/*              DetectCycle.java                                                */
/*                                                                              */
/*      description of class                                                    */
/*                                                                              */
/********************************************************************************/
/**
 *
 * @author derricklin
 */

package edu.brown.cs.quixbugs;



public class DetectCycle
{

public boolean detect_cycle(Node node) {
   Node hare = node;
   Node tortoise = node;
   
   while (true) {
      // should check for hare being null
      if (hare.getSuccessor() == null)
         return false;
      
      tortoise = tortoise.getSuccessor();
      hare = hare.getSuccessor().getSuccessor();
      
      if (hare == tortoise)
         return true;
    }
}

public static void main(String [] args)
{
   DetectCycle dc = new DetectCycle();
   boolean result;
   Node node6 = new Node("6");
   Node node7 = new Node("7", node6);
   result = dc.detect_cycle(node7);
   assert result == false;
}

}       // end of class DetectCycle




/* end of DetectCycle.java */

