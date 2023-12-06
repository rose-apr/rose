/********************************************************************************/
/*                                                                              */
/*              ShortestPaths.java                                              */
/*                                                                              */
/*      description of class                                                    */
/*                                                                              */
/********************************************************************************/
/**
 *
 * @author Angela Chen
 */

package edu.brown.cs.quixbugs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestPaths
{
final static int INF = 99999;


public static Map<String, Integer> shortest_paths(String source, Map<List<String>,Integer> weight_by_edge) {
   Map<String,Integer> weight_by_node = new HashMap<String,Integer>();
   for (List<String> edge : weight_by_edge.keySet()) {
      weight_by_node.put(edge.get(1), INF);
      weight_by_node.put(edge.get(0), INF);
    }
   
   weight_by_node.put(source, 0);
   for (int i = 0; i < weight_by_node.size(); i++) {
      for (List<String> edge : weight_by_edge.keySet()) {
         int update_weight = Math.min(
               weight_by_node.get(edge.get(0))
                                + weight_by_edge.get(edge),
                                weight_by_node.get(edge.get(1)));
         weight_by_edge.put(edge, update_weight);   // edge-> edge.get(1)
       }
    }
   return weight_by_node;
}



public static void main(String [] args)
{
   // Case 1: All vertex is reachable from starting vertex
   // Output: ('A', 0) ('B', 1) ('C', 3) ('D', 10) ('E', 5) ('F', 4)
   Map<List<String>, Integer> graph = new HashMap<>();
   graph.put(new ArrayList<String>(Arrays.asList("A", "C")), 3);
   graph.put(new ArrayList<String>(Arrays.asList("A", "F")), 5);
   graph.put(new ArrayList<String>(Arrays.asList("C", "B")), -2);
   graph.put(new ArrayList<String>(Arrays.asList("C", "D")), 7);
   graph.put(new ArrayList<String>(Arrays.asList("C", "E")), 4);
   graph.put(new ArrayList<String>(Arrays.asList("D", "E")), -5);
   graph.put(new ArrayList<String>(Arrays.asList("E", "F")), -1);
   
   Map<String, Integer> weight_by_node = new HashMap<String, Integer>();
   weight_by_node = shortest_paths("A", graph);
   String resultStr = "";
   for (String node : weight_by_node.keySet()) {
      resultStr += "("+node+","+weight_by_node.get(node)+")";					
    }
   assert resultStr.equals("(A,0)(B,1)(C,3)(D,10)(E,5)(F,4)");  
}

}       // end of class ShortestPaths




/* end of ShortestPaths.java */

