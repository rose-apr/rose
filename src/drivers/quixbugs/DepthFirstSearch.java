/********************************************************************************/
/*										*/
/*		DepthFirstSearch.java						*/
/*										*/
/*	Depth first search example						*/
/*										*/
/********************************************************************************/
/**
 *
 * @author derricklin
 */

package edu.brown.cs.quixbugs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DepthFirstSearch
{

public static boolean depth_first_search(Node startnode, Node goalnode) {
    Search s = new Search(goalnode);
    return s.search(startnode);
}


private static class Search {

   private Set<Node> nodes_visited;
   private Node goal_node;

   Search(Node goal) {
      nodes_visited = new HashSet<>();
      goal_node = goal;
    }

   boolean search(Node node) {
      if (nodes_visited.contains(node)) {
	 return false;
       }
      else {
	 if (node == goal_node) {
	    return true;
	  }
	 else {
	    // Should add:  nodesvisited.add(node);
	    for (Node successornodes : node.getSuccessors()) {
	       if (search(successornodes)) { return true; }
	     }
	  }
       }
      return false;
    }

}	// end of inner class Search



public static void main(String [] args)
{
   Node nodef = new Node("F");
   Node nodee = new Node("E");
   Node noded = new Node("D");
   Node nodec = new Node("C", new ArrayList<Node>(Arrays.asList(nodef)));
   Node nodeb = new Node("B", new ArrayList<Node>(Arrays.asList(nodee)));
   Node nodea = new Node("A", new ArrayList<Node>(Arrays.asList(nodeb, nodec, noded)));
   nodee.setSuccessors(new ArrayList<Node>(Arrays.asList(nodea)));
   boolean result = depth_first_search(nodea, nodef);
   assert result == true;
}

}	// end of class DepthFirstSearch




/* end of DepthFirstSearch.java */

