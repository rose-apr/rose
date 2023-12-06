/********************************************************************************/
/*										*/
/*		ReverseLinkedList.java						*/
/*										*/
/*	QuixBugs REVERSE_LINKED_LIST						*/
/*										*/
/********************************************************************************/
/**
 *
 * @author derricklin
 */

package edu.brown.cs.quixbugs;



public class ReverseLinkedList
{

public static Node reverse_linked_list(Node node) {
   Node prevnode = null;
   Node nextnode;
   while (node != null) {
      nextnode = node.getSuccessor();
      node.setSuccessor(prevnode);	// add: prevnode = node
      node = nextnode;
    }
   return prevnode;
}


public static void main(String [] args)
{
   Node node1 = new Node("1");
   Node node2 = new Node("2", node1);
   Node node3 = new Node("3", node2);
   Node node4 = new Node("4", node3);
   Node node5 = new Node("5", node4);

   Node result = reverse_linked_list(node5);

   if (result.getValue() == node1.getValue()) {
      System.out.printf("Reversed! ");
    }
   else {
      System.out.printf("Not Reversed! ");
    }
}

}	// end of class ReverseLinkedList




/* end of ReverseLinkedList.java */

