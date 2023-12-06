/********************************************************************************/
/*                                                                              */
/*              Wrap.java                                                       */
/*                                                                              */
/*      QuixBugs: WRAP                                                          */
/*                                                                              */
/********************************************************************************/
/**
 *
 * @author derricklin
 */


package edu.brown.cs.quixbugs;

import java.util.ArrayList;

public class Wrap
{

public static ArrayList<String> wrap(String text, int cols) {
   ArrayList<String> lines = new ArrayList<String>();
   
   String line;
   while (text.length() > cols) {
      int end = text.lastIndexOf(" ", cols); // off by one?
      if (end == -1) {
         end = cols;
       }
      line = text.substring(0,end);
      text = text.substring(end);
      lines.add(line);
    }
   // missing: lines.add(text)
   
   return lines;
}


public static void main(String [] args)
{
   ArrayList<String> result = wrap("The leaves did not stir on the trees, grasshoppers chirruped, and the monotonous hollow sound of the sea rising up from below, spoke of the peace, of the eternal sleep awaiting us. So it must have sounded when there was no Yalta, no Oreanda here; so it sounds now, and it will sound as indifferently and monotonously when we are all no more. And in this constancy, in this complete indifference to the life and death of each of us, there lies hid, perhaps, a pledge of our eternal salvation, of the unceasing movement of life upon earth, of unceasing progress towards perfection. Sitting beside a young woman who in the dawn seemed so lovely, soothed and spellbound in these magical surroundings - the sea, mountains, clouds, the open sky - Gurov thought how in reality everything is beautiful in this world when one reflects: everything except what we think or do ourselves when we forget our human dignity and the higher aims of our existence.",(int)50);
   String fmt = result.toString();
   assert fmt.endsWith("existence.]");
}

}       // end of class Wrap




/* end of Wrap.java */

