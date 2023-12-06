/********************************************************************************/
/*                                                                              */
/*              SeedeBugs.java                                                  */
/*                                                                              */
/*      Code that induces bugs in seede/fait                                    */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */
/*********************************************************************************
 *  Copyright 2011, Brown University, Providence, RI.                            *
 *                                                                               *
 *                        All Rights Reserved                                    *
 *                                                                               *
 * This program and the accompanying materials are made available under the      *
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, *
 * and is available at                                                           *
 *      http://www.eclipse.org/legal/epl-v10.html                                *
 *                                                                               *
 ********************************************************************************/

/* SVN: $Id$ */



package edu.brown.cs.quixbugs;

import java.util.HashSet;
import java.util.Set;

public class SeedeBugs
{

// Seede doesn't seem to like starting at method defined inside method
public static boolean depth_first_search(Node startnode, Node goalnode) {
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
         // Should have:  nodesvisited.add(node);
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

}       // end of class SeedeBugs




/* end of SeedeBugs.java */

