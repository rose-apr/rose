/********************************************************************************/
/*                                                                              */
/*              TopologicalOrdering.java                                        */
/*                                                                              */
/*      QuixBugs: TOPOLOGICAL_ORDERING                                          */
/*                                                                              */
/********************************************************************************/


package edu.brown.cs.quixbugs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TopologicalOrdering
{

public static ArrayList<Node> topological_ordering (List<Node> directedGraph) {
   ArrayList<Node> orderedNodes = new ArrayList<Node>();
   for (Node node : directedGraph) {
      if (node.getPredecessors().isEmpty()) {
         orderedNodes.add(node);
       }
    }
   
   int listSize = orderedNodes.size();
   for (int i = 0; i < listSize; i++) {
      Node node = orderedNodes.get(i);
      for (Node nextNode : node.getSuccessors()) {
         if (orderedNodes.containsAll(nextNode.getSuccessors()) && !orderedNodes.contains(nextNode)) {
            // should have been getPredecessors
            orderedNodes.add(nextNode);
            listSize++;
          }
       }
    }
   return orderedNodes;
}



public static void main(String [] args)
{
   Node five = new Node("5");
   Node seven = new Node("7");
   Node three = new Node("3");
   Node eleven = new Node("11");
   Node eight = new Node("8");
   Node two = new Node("2");
   Node nine = new Node("9");
   Node ten = new Node("10");
   
   five.setSuccessors(new ArrayList<Node>(Arrays.asList(eleven)));
   seven.setSuccessors(new ArrayList<Node>(Arrays.asList(eleven, eight)));
   three.setSuccessors(new ArrayList<Node>(Arrays.asList(eight, ten)));
   eleven.setPredecessors(new ArrayList<Node>(Arrays.asList(five, seven)));
   eleven.setSuccessors(new ArrayList<Node>(Arrays.asList(two, nine, ten)));
   eight.setPredecessors(new ArrayList<Node>(Arrays.asList(seven, three)));
   eight.setSuccessors(new ArrayList<Node>(Arrays.asList(nine)));
   two.setPredecessors(new ArrayList<Node>(Arrays.asList(eleven)));
   nine.setPredecessors(new ArrayList<Node>(Arrays.asList(eleven, eight)));
   ten.setPredecessors(new ArrayList<Node>(Arrays.asList(eleven, three)));
   
   new ArrayList<Node>(Arrays.asList(five, seven, three, eleven, eight, two, nine, ten));
   
   ArrayList<Node> results = topological_ordering(
         new ArrayList<Node>(Arrays.asList(five, seven, three, eleven, eight, two, nine, ten)));
   
   String resultStr = "";
   for (Node node : results) {
      resultStr += node.getValue() + " ";
    }
   assert resultStr.equals("5 7 3 11 8 10 2 9 ");
   
}


}       // end of class TopologicalOrdering




/* end of TopologicalOrdering.java */

