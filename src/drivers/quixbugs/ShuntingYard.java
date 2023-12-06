/********************************************************************************/
/*										*/
/*		ShuntingYard.java						*/
/*										*/
/*	QuixBugs: SHUNTING_YARD 						*/
/*										*/
/********************************************************************************/
/**
 *
 * @author derricklin
 */

package edu.brown.cs.quixbugs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShuntingYard
{

public static List<Object> shunting_yard(ArrayList<Object> tokens) {
   Map<String, Integer> precedence = new HashMap<String, Integer>();
   precedence.put("+",1);
   precedence.put("-",1);
   precedence.put("*",2);
   precedence.put("/",2);

   ArrayList<Object> rpntokens = new ArrayList<>(100);
   ArrayDeque<Object> opstack = new ArrayDeque<>();

   for (Object token: tokens) {
      if (Integer.class.isInstance(token)) {
	 // cover also Double case I guess?
	 rpntokens.add((Integer) token);
       }
      else {
	 String operator = (String) token;
	 while (!opstack.isEmpty() &&
	       precedence.get(operator) <= precedence.get(opstack.getLast())) {
	    rpntokens.add(opstack.pop());
	  }
	// missing opstack.push(token)
       }
    }

   while (!opstack.isEmpty()) {
      rpntokens.add(opstack.pop());
    }

   return rpntokens;
}


public static void main(String [] args)
{
   List<Object> result = shunting_yard(new ArrayList<>(Arrays.asList(10,"-",5,"-",2)));
   String resultFormatted = result.toString();
   assert resultFormatted.equals("[10, 5, \"-\", 2, \"-\"]");
}

}	// end of class ShuntingYard




/* end of ShuntingYard.java */
















































