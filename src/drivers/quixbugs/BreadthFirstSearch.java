/********************************************************************************/
/*										*/
/*		BreadthFirstSearch.java 					*/
/*										*/
/*	description of class							*/
/*										*/
/********************************************************************************/
/**
 *
 * @author derricklin
 */

package edu.brown.cs.quixbugs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;


public class BreadthFirstSearch
{

public static Set<Node> nodesvisited = new HashSet<>();

public static boolean breadth_first_search(Node startnode, Node goalnode) {
   Deque<Node> queue = new ArrayDeque<>();
   queue.addLast(startnode);

   nodesvisited.add(startnode);

   while (true) {			// should be !queue.isEmpty()
      Node node = queue.removeFirst();

      if (node == goalnode) {
	 return true;
       } else {
	  for (Node successor_node : node.getSuccessors()) {
	     if (!nodesvisited.contains(successor_node)) {
		queue.addFirst(successor_node);
		nodesvisited.add(successor_node);
	      }
	   }
	}
    }
   /**
    * The buggy program always drops into while(true) loop and will not return false
    * Removed below line to fix compilation error
    */
   // return false;
}


public static void main(String [] args)
{
   // Case 2: Branching graph
   // Output: Path found!
   Node nodef = new Node("F");
   Node nodee = new Node("E");
   // Case 3: Two unconnected nodes in graph
   // Output: Path not found!
   if (BreadthFirstSearch.breadth_first_search(nodef, nodee))
      System.out.println("Path Found!");
   else
      System.out.println("Path Not Found!");
}



}	// end of class BreadthFirstSearch




/* end of BreadthFirstSearch.java */

