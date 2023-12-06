/********************************************************************************/
/*										*/
/*		OrigDepthFirstSearch.java					*/
/*										*/
/*	Original version of DEPTH_FIRST_SEARCH					*/
/*										*/
/********************************************************************************/



package edu.brown.cs.quixbugs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OrigDepthFirstSearch {

enum TestEnum { A, B };

public static boolean depth_first_search(Node startnode, Node goalnode) {

// TestEnum enumval = TestEnum.A;

   Set<Node> nodesvisited = new HashSet<>();
   class Search {
    boolean search(Node node) {
       if (nodesvisited.contains(node)) {
	  return false;
	}
       else if (node == goalnode) {
	  return true;
	}
       else {
	  nodesvisited.add(node);
	  for (Node successornodes : node.getSuccessors()) {
	     if (search(successornodes)) { return true; }
	   }
	}
       return false;
     }
    };

    Search s = new Search();
    return s.search(startnode);
}



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



}	// end of class OrigDepthFirstSearch




/* end of OrigDepthFirstSearch.java */

